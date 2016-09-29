package com.web.util;

import org.springframework.core.MethodParameter;
import org.springframework.security.util.FieldUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 保存搜索条件
 */
public class SearchParamHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver{
    private ConditionUrl conditionUrl;//暂时不需要

    public void setConditionUrl(ConditionUrl conditionUrl) {
        this.conditionUrl = conditionUrl;
    }

    //执行顺序 要想执行必须有一个标示
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(SearchParam.class);
    }

    //2 可以修改方法参数值
    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest nativeRequest = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        //1 session
        HttpServletRequest request = (HttpServletRequest)nativeRequest;
        Object condition = this.getSessionCondition(request, methodParameter);
        //2 类型转换
        this.fillCondition(condition,request.getParameterMap());//getParameterMap 参数名和参数值列表
        return condition;
    }

    /**
     * 获取condition的值
     * @return
     */
    public Object getSessionCondition(HttpServletRequest request,MethodParameter methodParameter) throws IllegalAccessException, InstantiationException {
        String urlKey = request.getServletPath();
        urlKey = urlKey.substring(0, urlKey.lastIndexOf("/"));
        HttpSession session = request.getSession();
        Object condition = session.getAttribute(urlKey);
        //若为搜索则保存和复制
        if(null == condition || !methodParameter.getParameterType().equals(condition.getClass())){
            condition = methodParameter.getParameterType().newInstance();
            session.setAttribute(urlKey,condition);
        }
        return condition;
    }


    public void fillCondition(Object condition,Map<String, String[]> paramMap) throws IllegalAccessException {
        for (Map.Entry<String,String[]> param : paramMap.entrySet()) {
            Field field = null;
            try {
                //根据对象和字段名得到字段
                field = FieldUtils.getField(condition.getClass(), param.getKey());
            }catch (Exception e){
                e.printStackTrace();
            }

            if(null == param.getValue()){//当传过来的值为null时session的值不变
                continue;
            }
            //普通类型
            this.setValue(field,condition,param.getValue());
        }
    }

    private void setValue(Field field, Object condition, String[] value) throws IllegalAccessException {
        if(value.length == 1 && value[0] != null){
            //1 得到值 主要是类型转换
            Object finalValue = this.valueTypeConverter(field.getType(), value[0]);//type  字段的声明类型 class 类的类型
            //2 设置值
            setPropertyValue(field,condition,finalValue);
        }
    }

    private void setPropertyValue(Field field, Object condition, Object finalValue) throws IllegalAccessException {
        field.setAccessible(true);
        field.set(condition,finalValue);
    }

    /**
     * 将字符串类型转换为字段所需要的类型 常用类型
     * @param fieldClass
     * @param value
     */
    private Object valueTypeConverter(Type fieldClass, String value) {
        if(fieldClass.equals(String.class)){//// TODO: 2016/9/28 type class String
            return value;
        }else if(fieldClass.equals(int.class)){//int Integer
            if(value.isEmpty())// ""
                return 0;
            else
                return Integer.valueOf(value).intValue();
        }else if(fieldClass.equals(Integer.class)){
            if(value.isEmpty())
                return null;
            else
                return Integer.valueOf(value);
        }else if(fieldClass.equals(short.class)){//short Short
            if (value.isEmpty())
                return 0;
            else
                return Short.valueOf(value).shortValue();
        }else if(fieldClass.equals(Short.class)){
            if(value.isEmpty())
                return null;
            else
                return Short.valueOf(value);
        }else if(fieldClass.equals(long.class)){//long Long
            if(value.isEmpty())
                return 0l;
            else
                return Long.valueOf(value).longValue();
        }else if(fieldClass.equals(Long.class)){
            if(value.isEmpty())
                return null;
            else
                return Long.valueOf(value);
        }else if(fieldClass.equals(boolean.class)){//boolean Boolean
            if(value.isEmpty())
                return false;
            else
                return Boolean.valueOf(value).booleanValue();
        }else if(fieldClass.equals(Boolean.class)){
            if(value.isEmpty())
                return null;
            else
                return Boolean.valueOf(value);
        }else if(fieldClass.equals(Date.class)){ //Date
            if(value.isEmpty())
                return null;
            else
                this.stringToDate(value);
        }else if(fieldClass.equals(double.class)){//double Double
            if(value.isEmpty())
                return 0.0;
            else
                return Double.valueOf(value).doubleValue();
        }else if(fieldClass.equals(Double.class)){
            if(value.isEmpty())
                return null;
            else
                return Double.valueOf(value);
        }else if(fieldClass.equals(BigDecimal.class)){ //bigDecimal
            if(value.isEmpty())
                return null;
            else
                return new BigDecimal(value);
        }else {
            throw new RuntimeException("condition中存在不支持的类型");
        }
        return null;
    }

    /**
     * 格式转换
     * @param dateString
     * @return
     */
    private Date stringToDate(String dateString){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException("搜索条件dateString转换date类型时错误");
        }
    }


}
