package com.test.service;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.api.service.BaseMaterialClassService;
import com.common.AbstractTest;
import com.exception.MyBusinessException;
import com.provider.model.BaseMaterialClass;
/**
 * 事务： 
 * 	autocommit默认开启：每一sql操作都是一个事务例如：不匹配方法
 * 	显示声明事务：一个Service匹配方法只有一个事务:与执行sql次数无关 只针对从外部类调用本方法（this.方法 不会发生事务）
 * 过程：创建连接 开启事务（conn.setAutoCommit(true/false)） 执行sql 
 *	    提交事务或回滚事务(conn.commit()/conn.rollback();) 关闭连接 	
 * 异常与回滚：
 * 	1  运行时异常和错误默认是回滚(comm.rollback())，检查性异常时不会回滚(conn.commit)
 *  2 通过配置 rollback-for 捕获 触发回滚（rollback())(只针对检查异常，其他种类的异常回滚)
 *    no-rollback-for:前提是回滚(针对运行时异常和错误)
 *    	rollback-for="com.exception.MyException" 只要抛出的检查性异常可以MyException捕获，则rollback,没有则commit
 *  3 其他事务属性
 *  	timeout:一个事务 执行最长时间 若超时则自动回滚 	
 * 	    read-only:只允许查询，若不是查询则抛出异常 <---->读写
 * 		隔离级别：（isolation）并发事务 数据
 * 		事务传播：（propagation）如事务对象是否重用
 *  4 
 * @author Edward
 *
 */
public class BaseMaterialClassServiceTest extends AbstractTest{
	@Resource
	private BaseMaterialClassService baseMaterialClassService;
	private BaseMaterialClass baseMaterialClass;
	
	@Before
	public void test(){
		baseMaterialClass = new BaseMaterialClass();
		baseMaterialClass.setClassCode("3");
		baseMaterialClass.setClassName("3");
		baseMaterialClass.setClassStatus((short)1);
		baseMaterialClass.setCreateTime(new Date());
		baseMaterialClass.setModifyTime(new Date());
		baseMaterialClass.setOrderNo(1);
		baseMaterialClass.setParentClassCode("1");
		baseMaterialClass.setParentHospitalId(1);
	}
	
	
//	@Test
//	public void selectTest(){
//		BaseMaterialClass selectById = baseMaterialClassService.selectById(1);
//		Assert.assertEquals(new Integer(1),selectById.getClassId());
//	}
	
//	@Test
//	public void updateTest() throws MyBusinessException{
//		BaseMaterialClass baseMaterialClass = new BaseMaterialClass();
//		baseMaterialClass.setClassId(1);
//		baseMaterialClass.setClassName("修改");
//		baseMaterialClassService.a(baseMaterialClass);
//	}
	
	@Test
	public void updateTest() throws MyBusinessException{
		BaseMaterialClass baseMaterialClass = new BaseMaterialClass();
		baseMaterialClass.setClassName("修改");
		baseMaterialClass.setClassId(1);
		baseMaterialClassService.update(baseMaterialClass);
	}
	
	@Test
	public void saveTest() throws MyBusinessException{
		baseMaterialClassService.save(baseMaterialClass);
	}
	
	@Test
	public void insertTest() throws MyBusinessException{
		baseMaterialClassService.insert(baseMaterialClass);
	}
}
