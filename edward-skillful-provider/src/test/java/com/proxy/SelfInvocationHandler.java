package com.proxy;

import java.lang.reflect.Method;
/**
 * 自定义方法调用处理器
 * @author Edward
 *
 */
public interface SelfInvocationHandler {
	public void invoke(Object o, Method m);
}
