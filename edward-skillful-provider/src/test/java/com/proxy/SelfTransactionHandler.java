package com.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * 事务处理器
 * @author Edward
 *
 */
public class SelfTransactionHandler implements SelfInvocationHandler{
	private Object target;
	
	public SelfTransactionHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public void invoke(Object o, Method m) {
		System.out.println("开启事务");
		try {
			m.invoke(target);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		System.out.println("结束事务");
	}

}
