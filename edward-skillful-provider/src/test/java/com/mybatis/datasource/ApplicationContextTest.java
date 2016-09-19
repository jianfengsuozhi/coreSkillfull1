package com.mybatis.datasource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {
	public static void main(String[] args) {
		//TestAop01类
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("classpath:db-config-test-transaction.xml");
//		BaseMaterialClassDao bean = ctx.getBean("baseMaterialClassDao", BaseMaterialClassDao.class);
//		System.out.println(bean);
		//测试markerInterface
//		TestDao bean2 = ctx.getBean("testDao", TestDao.class); 无法创建 com.provider.dao.TestDao
//		System.out.println(bean2);
	}
}
