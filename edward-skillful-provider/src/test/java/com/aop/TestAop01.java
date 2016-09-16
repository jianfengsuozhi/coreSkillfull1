package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
/**
 * 测试
 * 匹配方法执行：前，后，都执行
 * ProceedingJoinPoint  
 * @author weideliang
 *
 */
//普通类-->切面
@Component
public class TestAop01 {
	
	public void before(){
		System.out.println("匹配方法执行之前TestAop01");
	}
	
	public void afterReturning(){
		System.out.println("匹配方法执行之后 正常执行TestAop01");
	}
	
	public void afterThrowing(){
		System.out.println("匹配方法执行之后 异常执行TestAop01");
	}
	
	public void after(){
		System.out.println("匹配方法执行之后TestAop01");
	}
	//proceed继续 JoinPoint 连接点(方法调用或处理异常) 中断
	public void around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("匹配方法执行之前和执行之后都执行TestAop01");
		this.proceedingJoinPointTest(pjp);
//		System.out.println("匹配方法执行之前和执行之后都执行");
		
//		Object[] args = pjp.getArgs();
//		if(args!=null && args.length>0 && args[0] instanceof String){
//			args[0] = "改变参数";
//		}
		
		//方法返回值
//		String returnValue =(String)pjp.proceed(args);
//		System.out.println(returnValue);//改变参数
		
		System.out.println("匹配方法执行之前和执行之后都执行TestAop01");
	}
	
	private void proceedingJoinPointTest(ProceedingJoinPoint pjp){
		//匹配方法的参数
//		Object[] args = pjp.getArgs();//魏德亮,1
//		for (Object object : args) {
//			System.out.println(object);
//		}
		
//		System.out.println(pjp.getSignature());//方法签名 void com.aop.AopExample.example(String,Integer)
//		System.out.println(pjp.getSignature().getDeclaringTypeName());//声明类型 com.aop.AopExample
//		System.out.println(pjp.getSignature().getName());//方法名 example
		
//		System.out.println(pjp.getTarget());//com.aop.AopExample@6647555e 就是 ctx.getBean("aopExample",AopExample.class);
//		System.out.println(pjp.getThis());// == getTarget()
	}
}
