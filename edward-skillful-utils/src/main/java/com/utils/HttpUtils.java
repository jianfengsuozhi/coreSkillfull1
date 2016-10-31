package com.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by weideliang on 2016/10/31.
 */
public class HttpUtils {
    private static String[] IEBrowserSignals = {"MSIE", "Trident", "Edge"};

    /**
     * 判断是否是微软浏览器
     * @param request
     * @return
     */
    public static boolean isMSBrowser(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        for (String signal : IEBrowserSignals) {
            if (userAgent.contains(signal))
                return true;
        }
        return false;
    }
}
