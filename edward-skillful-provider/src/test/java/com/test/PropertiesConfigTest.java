package com.test;

import javax.annotation.Resource;

import org.junit.Test;

import com.common.AbstractTest;

public class PropertiesConfigTest extends AbstractTest{
	@Resource
	private Configuration configuration;
	
	@Test
	public void test(){
		System.out.println(configuration.getName());
		System.out.println(configuration.getUrl());
	}
}
