
package com.web.util;

import com.web.security.MyCurUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.Assert;

import java.util.*;

public class TabUrlHelper {

    private TabNode _rootTab = new TabNode();

    private static final String PAGE_403="/403.do";

    /**
     * 检查当前用户是否有任意一个权限。
     *
     * @author zll
     * @version v2.0.7
     * @date Apr 1, 2014 12:32:15 PM
     *
     * @param authorityCodeList
     *            权限码列表
     * @return true-有权限
     */
    private boolean hasAnyRole(List<String> authorityCodeList) {

        if (authorityCodeList == null || authorityCodeList.isEmpty()) {
            return true;
        }

        SecurityContext secContext = SecurityContextHolder.getContext();
        MyCurUser user = (MyCurUser) secContext.getAuthentication().getPrincipal();
        for (GrantedAuthority authority : user.getAuthorities()) {
            if (authorityCodeList.contains(authority.getAuthority())) {
                return true;
            }
        }
        return false;
    }

    private String tabUrl(TabNode tabNode) {

        if (!hasAnyRole(tabNode.getAuthorityList())) {
            return null;
        }

        if (tabNode.isLeaf()) {
            return StringUtils.trimToNull(tabNode.getUrl());
        }

        for (TabNode childTabNode : tabNode.getChildren()) {
            String url = StringUtils.trimToNull(tabUrl(childTabNode));
            if (url != null) {
                return url;
            }
        }

        return PAGE_403;
    }

    /**
     * 根据指定的tab路径，返回当前用户对其拥有第一个有权限的叶子tab的URL。
     *
     * @author zll
     * @version v2.0.7
     * @date Apr 1, 2014 1:11:49 PM
     *
     * @param tabPath
     *            tab路径，比如："统计查询/收费统计"
     * @return 指定tab下第一个有权限叶子tab的URL。
     */
    public String tabUrl(String tabPath) {

        if (tabPath == null || tabPath.length() == 0) {
            return tabUrl(_rootTab);
        }

        TabNode curTab = _rootTab;
        String[] tabArr = tabPath.split("/");
        // 先检查对父级tab存在、且当前用户对其都有访问权限。
        for (int i = 0; i < tabArr.length; i++) {
            curTab = curTab.getTab(tabArr[i]);
            if (curTab == null || !hasAnyRole(curTab.getAuthorityList())) {
                return PAGE_403;
            }
        }

        // 再返回子级tab中第一个有权限的叶子tab的URL
        return tabUrl(curTab);
    }

    /**
     *
     * 根据第一级目录取第一个有权限的叶子tabName
     *
     * @author jinzhaokang
     * @version v2.2.3
     * @date 2014年10月24日 下午3:36:35
     *
     * @param tabPath
     *        tab路径，比如："统计查询 挂号收费 图像采集"
     * @return
     */

    public String getFirstNode(String tabPath){

        if (tabPath == null || tabPath.length() == 0) {
            return PAGE_403;
        }
        TabNode curTab = _rootTab;
        // 先检查对父级tab存在、且当前用户对其都有访问权限。
        curTab = curTab.getTab(tabPath);
        if (curTab == null || !hasAnyRole(curTab.getAuthorityList())) {
            return PAGE_403;
        }

        // 再返回子级tab中第一个有权限的叶子tabName
        List<TabNode> child = curTab.getChildren();
        if(child != null && child.size() > 0){
            TabNode tn = child.get(0);
            return tabPath + "/" + tn.getTabName();
        }
        return null;
    }

    public void setTabs(List<TabNode> tabs) {

        _rootTab.setChildren(tabs);
    }

    public TabNode getRootTab(){

        return _rootTab;
    }

    public static class TabNode implements BeanPostProcessor {

        private List<TabNode> children;
        private List<String> authorityList;
        private String url;
        private String urlforward;
        private Map<String, TabNode> _children = new LinkedHashMap<String, TabNode>();
        private String tabName;
        private Boolean isForward;

        public boolean isLeaf() {

            return this.url != null && this.url.length() > 0;
        }

        public void setTabName(String tabName) {

            this.tabName = tabName;
        }

        public TabNode getTab(String childTabName) {

            return _children.get(childTabName);
        }

        public String getTabName() {

            return tabName;
        }

        public List<TabNode> getChildren() {

            return children;
        }

        public void setChildren(List<TabNode> children) {

            Assert.isTrue(children.size() > 0, "子级tab不能设置为空");
            this.children = children;
            _children.clear();
            for (TabNode tabNode : children) {
                _children.put(tabNode.getTabName(), tabNode);
            }
        }

        public List<String> getAuthorityList() {

            return authorityList;
        }

        public void setAuthorities(String[] authorities) {

            List<String> tmpauthorities = new ArrayList<String>(Arrays.asList(authorities));

            for (int i = 0; i < tmpauthorities.size(); i++) {
                tmpauthorities.set(i, StringUtils.trimToNull(tmpauthorities.get(i)));
            }

            Iterator<String> it = tmpauthorities.iterator();
            while (it.hasNext()) {
                String auth = it.next();
                if (auth == null) {
                    it.remove();
                }
            }
            this.authorityList = tmpauthorities;
        }

        public String getUrl() {

            return url;
        }

        public void setUrl(String url) {

            this.url = StringUtils.trimToNull(url);
        }

	    public String getUrlforward () {

		    return urlforward;
	    }

	    public void setUrlforward (String urlforward) {

		    this.urlforward = urlforward;
	    }

	    @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

            return bean;
        }

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

            Assert.isTrue(!(this.url != null && this.children != null), "url 和子级tab不能同时设定。");
            Assert.isTrue(!(this.url == null && this.children == null), "url 和子级tab均未设定。");
            return bean;
        }

        public Boolean getIsForward() {

            return isForward;
        }

        public void setIsForward(Boolean isForward) {

            this.isForward = isForward;
        }

    }

}
