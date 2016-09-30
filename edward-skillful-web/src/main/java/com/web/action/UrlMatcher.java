package com.web.action;

/**
 * Created by weideliang on 2016/9/30.
 */
public interface UrlMatcher{
    Object compile(String paramString);
    boolean pathMatchesUrl(Object paramObject, String paramString);
    String getUniversalMatchPattern();
    boolean requiresLowerCaseUrl();
}
