package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
/**
 * 传递参数，
 *
 */
@Component
public class TestAop02 {
	@Pointcut("execution(* com.aop..*(..))")
	public void pointcut(){
		
	}
	
	//使用JoinPoint 获取调用信息
	//ProceedingJoinPoint 仅仅支持around且有proceed
	@Before(value="pointcut()")
	public void before(JoinPoint joinPoint){
		System.out.println("before");
	}
	
	//直接获取调用参数值
	//args(str,a) 匹配方法只有两个参数才能执行此方法(个数相同,类型相同) args(str,a,..)以str,a开始,至少3个参数
	//args(str,a,..)分别表示第一个参数，第二个参数(根据位置对应)
	@AfterReturning(value="execution(* com.aop..*(..)) and args(str,a,..)",returning="returnValue")
	public void afterReturning(Object returnValue,Integer a,String str){//根据名称对应
		System.out.println(returnValue);
		System.out.println(str);
		System.out.println(a);
	}
	
	//value=pointcut 都有value,但不都有pointcut
	@AfterThrowing(value="execution(* com.aop..*(..))",throwing="ex")
	public void afterThrowing(Exception ex){
		System.out.println(ex.getMessage());
	}
	
	public void after(){
	}
	
	public void around(JoinPoint joinPoint) throws Throwable{
	}
}
