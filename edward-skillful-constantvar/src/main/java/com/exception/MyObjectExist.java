package com.exception;

import org.slf4j.Logger;

public class MyObjectExist extends RuntimeException{
	private static final long serialVersionUID = 2197168986072483023L;
	
	public MyObjectExist(){
		super("对象存在异常");
	}
	
	public MyObjectExist(String errorMsg){
		super(errorMsg);
	}
	
	public MyObjectExist(String errorMsg,Throwable  cause){
		super(errorMsg, cause);
	}
	
	public static MyObjectExist create(Logger logger,String errorMsg){
		logger.error(errorMsg);
		return new MyObjectExist(errorMsg);
	}
	
	public static void checkTrue(Boolean expression,Logger logger,String errorMsg){
		if(expression){
			throw create(logger, errorMsg);
		}
	}
	
	public static void checkNull(Object reference,Logger logger,String errorMsg){
		if(null == reference){
			throw create(logger, errorMsg);
		}
	}
}
