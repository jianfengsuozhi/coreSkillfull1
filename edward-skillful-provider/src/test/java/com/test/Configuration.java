package com.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * 测试使用
 * @author weideliang
 *
 */
@Component
public class Configuration {
	@Value("${name}")
	private String name;
	@Value("${jdbc.url}")
	private String url;
	
	public String getUrl() {
		return url;
	}
	public String getName() {
		return name;
	}
	
}
