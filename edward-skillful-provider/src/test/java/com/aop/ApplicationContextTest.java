package com.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aop.AopExample;

public class ApplicationContextTest {
	public static void main(String[] args) {
		//TestAop01类
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("classpath:db-config-test-aop.xml");
//		AopExample bean = ctx.getBean("aopExample",AopExample.class);
//		System.out.println(bean);
		//测试ProceedingJoinPoint参数
//		bean.example("魏德亮", 1,2);
//		bean.exceptionExample();
		
		//TestAop02类
//		ApplicationContext  ctx = new ClassPathXmlApplicationContext("classpath:db-config-test.xml");
//		AopExample bean = ctx.getBean("aopExample",AopExample.class);
//		bean.example("传递参数", 2,3);
//		bean.example(2, "传递参数");
//			bean.exceptionExample();
		
		//添加新功能 
//		AddInterface bean2 = ctx.getBean("aopExample", AddInterface.class);
//		bean2.add();
//		AopExample bean3 = ctx.getBean("aopExample", AopExample.class);//没有add
		
//		System.out.println(ctx.getBean("a"));
	}
}
