package com.proxy;

import org.springframework.stereotype.Component;

@Component
public class RealSubject implements Subject{

	@Override
	public void targetMethod() {
		System.out.println("真实的客户");
	}

}
