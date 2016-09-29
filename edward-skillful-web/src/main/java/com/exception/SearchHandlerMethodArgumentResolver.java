package com.exception;

import com.web.util.SearchParam;
import org.springframework.beans.BeanUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Set;

/**
 * Created by Edward on 2016/9/24.
 */
public class SearchHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver{
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(SearchParam.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        Class<?> parameterType = methodParameter.getParameterType();
        //参数值
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> strings = parameterMap.keySet();
        Object instantiate = BeanUtils.instantiateClass(parameterType.getClass());
        for(String str : strings){

        }
        String[] parameterValues = parameterMap.get(methodParameter.getParameterName());
        //session
        if(null != parameterValues){
            HttpSession session = request.getSession();
            String sessionId = request.getRequestURI();
            if(null != session.getAttribute(sessionId)){
                return session.getAttribute(sessionId);
            }else {
                session.setAttribute(sessionId,parameterValues[0]);
            }
            return parameterValues[0];
        }
        return null;
    }
}
