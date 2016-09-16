package com.aop;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AddImpl implements AddInterface{

	@Override
	public void add() {
		System.out.println("父接口add");
	}

}

class A{
	
}
