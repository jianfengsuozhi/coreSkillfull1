package com.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义异常处理器 Resolver==Handler
 *
 * Created by Edward on 2016/9/23.
 */
public class MyExceptionHandler implements HandlerExceptionResolver {
    /**
     *
     * @param request
     * @param response
     * @param handler xml生成的 MyExceptionHandler对象
     * @param ex 记录错误信息
     * @return
     */
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("ex", ex);

        // 根据不同错误转向不同页面
        if(ex instanceof MyIllegalArgumentException) {
            return new ModelAndView("test/exception/error-myIllegalArgument", model);
        }else if(ex instanceof MyBusinessException) {
            return new ModelAndView("test/exception/error-myBusinessException", model);
        } else {
            return new ModelAndView("test/exception/error", model);
        }
    }
}
