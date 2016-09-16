package com.self.plugins;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.util.JavaBeansUtil;

public class ModelAddSetMethodPlugin extends PluginAdapter{

	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}
	
	@Override
	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		topLevelClass.addSuperInterface(new FullyQualifiedJavaType("com.test.Service.ParentService"));
		topLevelClass.addImportedType(new FullyQualifiedJavaType("com.test.Service.ParentService"));
		return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
	}
	
	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		Method method = new Method("getTest");
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setReturnType(new FullyQualifiedJavaType("com.lang.Integer"));
		method.addParameter(new Parameter(new FullyQualifiedJavaType("com.lang.String"),"a"));
		method.addParameter(new Parameter(new FullyQualifiedJavaType("com.lang.Integer"),"b"));
		method.addBodyLine("Integer c =new Integer(a+b);");
		method.addBodyLine("return c;");
		topLevelClass.addMethod(method);
		
		//table配置中第一项为主键
		String tableConfigurationProperty = introspectedTable.getTableConfigurationProperty("primary");
		//使用驼峰命名法如team_id变成teamId
		System.out.println(JavaBeansUtil.getCamelCaseString(tableConfigurationProperty, false));
		return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
	}
}
