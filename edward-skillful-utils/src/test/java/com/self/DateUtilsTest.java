package com.self;

import org.joda.time.DateTime;

/**
 * DateUtils 如获取当前时间，格式转化为String
 */
public class DateUtilsTest {
	public static void main(String[] args) {
		// 时间:DateUtils:如


	/*	System.out.println(DateUtils.getToday());
		Date today = DateUtils.getToday();
		System.out.println(DateUtils.getStartOfDay(today));
		System.out.println(DateUtils.getEndOfDay());*/

		//两种获取当前时间方法 Wed Sep 21 15:59:07 CST 2016 DateUtils功能更强大
	/*	System.out.println(DateUtils.getCurDate());
		System.out.println(DateTime.now().toDate());
*/
		//Property[dayOfMonth] 属性值
		System.out.println(DateTime.now().dayOfMonth());

		//格式转换和变成string
//		DateUtils.toStr("yyyy-MM-dd",new Date());
	}
}
