package com.web.security;

/**
 * Created by weideliang on 2016/9/30.
 */

import com.api.service.PrivilegeService;
import com.provider.model.Privilege;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service("securityMetadataSource")
public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    private UrlMatcher urlMatcher = new AntUrlPathMatcher();
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
    @Resource
    private PrivilegeService privilegeService;

 /*   //tomcat启动时实例化一次
    public MyInvocationSecurityMetadataSource() {
    }*/
    //url -- 权限码
    private void loadResourceDefine() {
        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
        List<Privilege> privileges = privilegeService.selectAll();
        for (Privilege privilege : privileges) {
            Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
            ConfigAttribute ca = new SecurityConfig(privilege.getPrivilegeCode());
            atts.add(ca);
            resourceMap.put(privilege.getUrl(), atts);
        }

/*        Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
        ConfigAttribute ca = new SecurityConfig("ROLE_USER");
        atts.add(ca);
        resourceMap.put("/index.htm", atts);
        Collection<ConfigAttribute> attsno =new ArrayList<ConfigAttribute>();
        ConfigAttribute cano = new SecurityConfig("ROLE_NO");
        attsno.add(cano);
        resourceMap.put("/other.htm", attsno);*/
    }

    //得到该url所需要的权限  Object: /index.htm
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //tomcat启动时实例化一次
        if(null == resourceMap){
            this.loadResourceDefine();
        }

        // 将参数转为url
        String url = ((FilterInvocation)object).getRequestUrl();
        Iterator<String>ite = resourceMap.keySet().iterator();
        while (ite.hasNext()) {
            String resURL = ite.next();
            //得到访问该url的所有可能角色
            if (urlMatcher.pathMatchesUrl(resURL, url)) {
                return resourceMap.get(resURL);
            }
        }
        return null;
    }
    public boolean supports(Class<?>clazz) {
        return true;
    }
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }
}