package com.web.test;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class TestHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver{
    //执行顺序 1
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
        Map<String, String[]> parameterMap = nativeRequest.getParameterMap();
        parameterMap.get(0);
        return "魏德亮";
    }
}
