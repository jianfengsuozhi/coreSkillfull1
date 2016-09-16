package com.aop;

import org.springframework.stereotype.Component;

@Component
public class AopExample {
	public String example(String str,Integer a,Integer b){
//		System.out.println(str);
		return str;
	}
	
	public String example(Integer a,String str){
		return str;
	}
	
	public void exceptionExample(){
		int a = 2/0;
		System.out.println("执行异常方法");
	}

}
