package com.aop;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.stereotype.Component;

import com.api.service.LogService;
import com.provider.model.Log;

/**
 * spring aop实现日志记录
 * 一个事务--一个动态代理方法
 * 事务管理的是动态代理的方法(若切面发生异常则回滚包括sql)
 * @author Edward
 *
 */
@Component
public class ServiceLogAspect {
	@Resource
	private LogService logService;
	
	@AfterReturning
	public void insert(JoinPoint joinPoint){
//		int a = 1/0; 测试若发生异常，则整体回滚
		Log log = this.getLog(joinPoint);
		log.setOperate("插入");
		logService.save(log);
	}
	
	@AfterReturning
	public void update(JoinPoint joinPoint){
		Log log = this.getLog(joinPoint);
		log.setOperate("修改");
		logService.save(log);
	}
	
	@AfterReturning
	public void delete(JoinPoint joinPoint){
		Log log = this.getLog(joinPoint);
		log.setOperate("删除");
		logService.save(log);
	}
	
	@AfterReturning  
	public void save(JoinPoint joinPoint){
		Log log = this.getLog(joinPoint);
		log.setOperate("增加或修改");
		logService.save(log);
	}
	
	private Log getLog(JoinPoint joinPoint){
		Log log = new Log();
//		String argsName = "";
//		Object[] args = joinPoint.getArgs();
//		for(int i=0;i<args.length-1;i++){
//			argsName +=args[i].toString();
//			argsName +=",";
//		}
//		argsName += args[args.length-1].toString();
		log.setArgs("参数");
		log.setMethodName(joinPoint.getSignature().getName());
		return log;
	}
	
	
}
