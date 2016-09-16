package com.exception;

import org.slf4j.Logger;

public class MyBusinessException extends MyException{
	private static final long serialVersionUID = -4928151425778008716L;
	public MyBusinessException(){
		super("业务异常");
	}
	
	public MyBusinessException(String errorMsg){
		super(errorMsg);
	}
	
	public MyBusinessException(String errorMsg,Throwable  cause){
		super(errorMsg, cause);
	}
	
	public static MyBusinessException create(Logger logger,String errorMsg){
		logger.error(errorMsg);
		return new MyBusinessException(errorMsg);
	}
	
	public static void checkTrue(Boolean expression,Logger logger,String errorMsg) throws MyBusinessException{
		if(expression){
			throw create(logger, errorMsg);
		}
	}
}
