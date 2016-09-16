package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 *  执行顺序
 *  1 不同切面：1,2 xml配置aop执行顺序是默认配置顺序
 *  2 一个切面:proceed执行之前执行:around中proceed之前和before(两者的执行顺序不确定)
 *  		 其他都是在proceed之后执行
 *  若个切面时要么都是用xml配置，要么都使用aspect配置，若有的使用xml配置，有的使用aspect配置，则有一种配置不能运行

 * @author Edward
 *
 */
@Component
public class TestAop03 {
	public void before(){
		System.out.println("匹配方法执行之前TestAop03");
	}
	
	public void afterReturning(){
		System.out.println("匹配方法执行之后 正常执行TestAop03");
	}
	
	public void afterThrowing(){
		System.out.println("匹配方法执行之后 异常执行TestAop03");
	}
	
	public void after(){
		System.out.println("匹配方法执行之后TestAop03");
	}
	
	public void around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("匹配方法执行之前和执行之后都执行TestAop03");
	}
	
}
