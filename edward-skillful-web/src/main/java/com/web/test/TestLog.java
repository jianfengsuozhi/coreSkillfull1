package com.web.test;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.api.service.BaseMaterialClassService;
import com.provider.model.BaseMaterialClass;

@Controller
public class TestLog {
	@Resource
	private BaseMaterialClassService baseMaterialClassService;
	
	@RequestMapping("index")
	public String test(){
		BaseMaterialClass baseMaterialClass = baseMaterialClassService.selectById(1);
		System.out.println(baseMaterialClass);
		return "index";
	}

}
