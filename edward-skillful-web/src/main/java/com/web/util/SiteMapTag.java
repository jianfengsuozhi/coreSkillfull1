
package com.web.util;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 站点导航标签的实现
 *
 * @author jinzhaokang
 * @version v2.2.3
 * @date 2014年10月22日 上午10:02:00
 * @id $Id$
 */
public class SiteMapTag extends TagSupport {

    private static final long serialVersionUID = -3531938467909884528L;
    private static ApplicationContext applicationContext;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public int doStartTag() throws JspException {

        // 获取applicationContext
        if (applicationContext == null) {
            applicationContext = WebApplicationContextUtils.getWebApplicationContext(this.pageContext.getServletContext());
        }

        // 当前访问的uri
        HttpServletRequest request = (HttpServletRequest) this.pageContext.getRequest();
        String currentPath = (String) request.getAttribute("javax.servlet.forward.request_uri");
        String contextPath = request.getContextPath();

        // 用于匹配xml文件中的url
        currentPath = currentPath.replaceFirst(contextPath, "");

        SiteMapTapSupport siteMapTapSupport = (SiteMapTapSupport) applicationContext.getBean("siteMapTapSupport");
        TabUrlHelper tabHelper = siteMapTapSupport.getTabHelper();
        RedisTemplate redisTemplate = siteMapTapSupport.getRedisTemplate();

/*        Long userId = siteMapTapSupport.getLoginBiz().getCurUser().getUserId();
        String hashKey = userId + "";

        // 用于根据userId保存面包屑数据
        Map<String, String> siteMap = (Map<String, String>) redisTemplate.opsForHash().get(siteMapTapSupport.getCustomerKey().getCacheKey(CacheInfo.SITE_MAP), hashKey);
        if (siteMap == null || siteMap.size() == 0) {
            siteMap = generateSiteMap(tabHelper, tabHelper.getRootTab(), null, null, contextPath);
            redisTemplate.opsForHash().put(CacheInfo.SITE_MAP, hashKey, siteMap);
        }*/

        try {
            Map<String, String> siteMap= generateSiteMap(tabHelper, tabHelper.getRootTab(), null, null, contextPath);
            String sp = siteMap.get(currentPath);
            if (sp != null) {
                this.pageContext.getOut().println(sp.substring(0, sp.length() - 4));
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return super.doStartTag();
    }

    /**
     *
     * 将url作为key保存到map
     *
     * @author jinzhaokang
     * @version v2.2.5
     * @date 2014年12月22日 上午11:20:21
     *
     * @param tabUrlHelper
     * @param tabNode
     * @param bread
     * @param pTabName
     */
    private Map<String, String> generateSiteMap(TabUrlHelper tabUrlHelper, TabUrlHelper.TabNode tabNode, String bread, String pTabName, String contextPath) {

        Map<String, String> map = new HashMap<>();

        List<TabUrlHelper.TabNode> tns = tabNode.getChildren();
        // 需要根据权限获得跟节点的第一个url
        for (TabUrlHelper.TabNode tn : tns) {
            // tab路径，比如："挂号收费/收费/未缴费列表"
            String tabName = pTabName == null ? tn.getTabName() : (pTabName + "/" + tn.getTabName());
            if ("系统管理".equals(tabName))
                continue;
            StringBuffer content = new StringBuffer("");
            // 根据指定的tab路径，返回当前用户对其拥有第一个有权限的叶子tab的URL
            String key = tn.getUrl() != null ? tn.getUrl() : tabUrlHelper.tabUrl(tabName);
            String url = StringUtils.isBlank(tn.getUrlforward()) ? key : tn.getUrlforward();
            Boolean isForward = tn.getIsForward();
            isForward = (isForward == null || isForward == true);
            content.append("&nbsp;<a href='" + (isForward ? (contextPath + url) : "javascript:;") + "'>" + tn.getTabName() + "</a>&nbsp;&gt;");
            String value = bread == null ? content.toString() : (bread + content.toString());
            if (key.contains("?"))
                key = key.substring(0, key.indexOf("?"));
            if (key.contains("#"))
                key = key.substring(0, key.indexOf("#"));

            map.put(key, value);

            if (tn.getChildren() != null && tn.getChildren().size() > 0) {
                map.putAll(generateSiteMap(tabUrlHelper, tn, value, tabName, contextPath));
            }

        }
        return map;
    }

    public static class SiteMapTapSupport {
        private TabUrlHelper tabHelper;
        private RedisTemplate redisTemplate;


        public TabUrlHelper getTabHelper() {

            return tabHelper;
        }

        public void setTabHelper(TabUrlHelper tabHelper) {

            this.tabHelper = tabHelper;
        }

        public RedisTemplate getRedisTemplate() {

            return redisTemplate;
        }

        public void setRedisTemplate(RedisTemplate redisTemplate) {

            this.redisTemplate = redisTemplate;
        }

    }
}
