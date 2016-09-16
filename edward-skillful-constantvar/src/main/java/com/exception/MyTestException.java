package com.exception;

import org.slf4j.Logger;

public class MyTestException extends MyException{
	private static final long serialVersionUID = -4889546072577727833L;

	public MyTestException(){
		super("测试异常");
	}
	
	public MyTestException(String errorMsg){
		super(errorMsg);
	}
	
	public MyTestException(String errorMsg,Throwable  cause){
		super(errorMsg, cause);
	}
	
	public static MyTestException create(Logger logger,String errorMsg){
		logger.error(errorMsg);
		return new MyTestException(errorMsg);
	}
	
	public static void checkTrue(Boolean expression,Logger logger,String errorMsg) throws MyTestException{
		if(expression){
			throw create(logger, errorMsg);
		}
	}
}
