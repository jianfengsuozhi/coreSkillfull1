package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * 
 * @author Edward
 *
 */
public class JDKDynamicProxy implements InvocationHandler{
	private Object targetObject;
	
	/**
	 * 功能和静态代理实现方法类似
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		beforeMethod();
		method.invoke(targetObject, args);
		afterMethod();
		return null;
	}
	
	public void afterMethod() {
		System.out.println("this is method before proxy..");
	}

	public void beforeMethod() {
		System.out.println("this is method before proxy..");
	}
	
	//创建对象:类似创建静态代理类(接口,真实对象信息)
	public Object createProxy(Object targetObject){
		this.targetObject = targetObject;
		return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
	}
	
	public static void main(String[] args) {
		JDKDynamicProxy jdkDynamicProxy = new JDKDynamicProxy();
		Subject subject = (Subject)jdkDynamicProxy.createProxy(new RealSubject());
		subject.targetMethod();
	}

}
