package com.self.plugins;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.TopLevelClass;

public class RenameModelPlugin extends PluginAdapter{

	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}
	
	@Override
	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		getContext().getJavaModelGeneratorConfiguration().setTargetPackage(properties.getProperty("criteriaPackage"));
		return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
	}
	
	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		getContext().getJavaModelGeneratorConfiguration().setTargetPackage(properties.getProperty("modelPackage"));
		return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
	}
}
