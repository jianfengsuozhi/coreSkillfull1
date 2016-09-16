package com.self;

import java.util.Date;

import com.utils.DateUtils;

public class DateUtilsTest {
	public static void main(String[] args) {
		System.out.println(DateUtils.getToday());
		Date today = DateUtils.getToday();
		System.out.println(DateUtils.getStartOfDay(today));
		System.out.println(DateUtils.getEndOfDay());
	}
}
