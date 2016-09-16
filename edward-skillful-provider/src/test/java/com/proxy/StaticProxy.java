package com.proxy;
/**
 * 静态代理：
 * 	1 由原来的new 实现 变成new Proxy
 *  2 添加一个额外的功能
 * @author Edward
 *
 */
public class StaticProxy implements Subject{
	private static Subject subject = new RealSubject();

	@Override
	public void targetMethod() {
		beforeMethod();
		subject.targetMethod();
		afterMethod();
	}

	public void afterMethod() {
		System.out.println("this is method before proxy..");
	}

	public void beforeMethod() {
		System.out.println("this is method before proxy..");
	}
	
	public static void main(String[] args) {
		Subject proxy = new StaticProxy();
		proxy.targetMethod();
	}

}
