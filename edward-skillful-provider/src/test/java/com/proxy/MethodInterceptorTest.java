package com.proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * methodInterceptor == InvocationHandler
 * 利用拦截器实现aop
 * @author Edward
 *
 */
public class MethodInterceptorTest {
	public static void main(String[] args) {
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("classpath:db-config-test-interceptor.xml");
		//aop基于动态代理，所以下面写会跑异常 必须是接口.method(),而实现类.method()会抛出异常 
//		RealSubject subject =(RealSubject)ctx.getBean("realSubject");
//		subject.targetMethod();
	}
}
