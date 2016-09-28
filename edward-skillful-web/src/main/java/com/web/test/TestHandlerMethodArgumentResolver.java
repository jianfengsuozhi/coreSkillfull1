package com.web.test;

import org.springframework.core.MethodParameter;
import org.springframework.security.util.FieldUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class TestHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver{
    //执行顺序 要想执行必须有一个标示
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(SearchParam.class);
    }

    //2 可以修改方法参数值
    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest nativeRequest = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
//        nativeRequest.getParameterMap();//参数map
//        nativeRequest.getRequestURI();// /edward-skillful-web/test/data/nameP.htm
//        Map<String, String[]> parameterMap = nativeRequest.getParameterMap();
//        String parameterName = methodParameter.getParameterName();
//        String simpleName = methodParameter.getParameterType().getSimpleName();
//        String[] strings = parameterMap.get(parameterName);
//        return strings[0];
        //1 session
        HttpServletRequest request = (HttpServletRequest)nativeRequest;
        Object condition = this.getSessionCondition(request, methodParameter);
        //2 类型转换
        this.fillCondition(condition,request.getParameterMap());
        return condition;
    }

    /**
     * 获取condition的值
     * @return
     */
    public Object getSessionCondition(HttpServletRequest request,MethodParameter methodParameter) throws IllegalAccessException, InstantiationException {
        String urlKey = request.getServletPath();
        Object condition = request.getAttribute(urlKey);
        if(null == condition || !methodParameter.getClass().equals(condition.getClass())){
            condition = methodParameter.getParameterType().newInstance();
        }
        return condition;
    }


    public void fillCondition(Object condition,Map<String, String[]> paramMap){
        for (Map.Entry<String,String[]> param : paramMap.entrySet()) {
            Field field = FieldUtils.getField(condition.getClass(), param.getKey());//?

            if(null == param.getValue()){
                continue;
            }
            //普通类型
            this.setValue(field,condition,param.getValue());
        }
    }

    private void setValue(Field field, Object condition, String[] value) {
        if(value.length == 1 && value[0] != null){
            //1 得到值 主要是类型转换
            valueTypeConverter(field.getClass(),value[0]);
            //2 设置值
        }
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
