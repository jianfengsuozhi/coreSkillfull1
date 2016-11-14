package com.ioc;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * 创建ioc容器
 * ioc容器实现:beanFactory(基本功能) 和applicationContext(高级功能)
 * beanFacotry:获取bean FactoryBean:工厂bean 创建bean
 * Created by Edward on 2016/11/14.
 */
public class CreateIoc01 {
    public static void main(String[] args) {
        //Resource:io操作类 封装信息来源
        ClassPathResource classPathResource = new ClassPathResource("ioc/bean.xml");
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        //处理读取的bean信息
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(classPathResource);

        String name = defaultListableBeanFactory.getBean("name", String.class);
        System.out.println(name);
    }
}
