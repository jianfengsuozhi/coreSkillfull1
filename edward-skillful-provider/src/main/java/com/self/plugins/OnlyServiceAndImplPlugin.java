package com.self.plugins;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.exception.ShellException;
import org.mybatis.generator.internal.DefaultShellCallback;
/**
 * 仅仅生成接口和基本实现
 * @author weideliang
 *
 */
public class OnlyServiceAndImplPlugin extends PluginAdapter{
	private String intefaceName = "";

	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}
	
	@Override
	public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(
			IntrospectedTable introspectedTable) {
		List<GeneratedJavaFile> list = new ArrayList<GeneratedJavaFile>(); 
		//判断相关service是否存在,若存在则不继续生成
		DefaultShellCallback defaultShellCallback = new DefaultShellCallback(false);
		File directory;
		try {
			//将com.a 变成 com/a
			directory = defaultShellCallback.getDirectory(properties.getProperty("targetProject"), properties.getProperty("implTargetPackage"));
			File file = new File(directory,introspectedTable.getTableConfiguration().getDomainObjectName()+"Impl.java");
			if(file.exists()){
				//false 该文件不生成
				return list;
			}
		} catch (ShellException e) {
			return list;
		}
		 Interface inteface = this.getInterface(introspectedTable);
		 TopLevelClass interfaceImpl = this.getInterfaceImpl(introspectedTable);
		 list.add(new GeneratedJavaFile(inteface, properties.getProperty("targetProject"), getContext().getJavaFormatter()));
		 list.add(new GeneratedJavaFile(interfaceImpl, properties.getProperty("targetProject"), getContext().getJavaFormatter()));
		return list;
	}
	
	private Interface getInterface(IntrospectedTable introspectedTable){
		 String targetPackageName = properties.getProperty("interfaceTargetPackage");
		 String domainObjectName = introspectedTable.getTableConfiguration().getDomainObjectName();
		 intefaceName = String.format(targetPackageName+".%sService", domainObjectName);
		 Interface inteface = new Interface(new FullyQualifiedJavaType(intefaceName));
		 inteface.setVisibility(JavaVisibility.PUBLIC);
		 return inteface;
	}
	
	private TopLevelClass getInterfaceImpl(IntrospectedTable introspectedTable){
		//添加名称
		 String targetPackageName = properties.getProperty("implTargetPackage");
		 String domainObjectName = introspectedTable.getTableConfiguration().getDomainObjectName();
		 String intefaceImplName = String.format(targetPackageName+".%sImpl", domainObjectName);
		 TopLevelClass topLevelClass = new TopLevelClass(new FullyQualifiedJavaType(intefaceImplName));
		 topLevelClass.setVisibility(JavaVisibility.PUBLIC);
		 
		 topLevelClass.addSuperInterface(new FullyQualifiedJavaType(intefaceName));
		 topLevelClass.addImportedType(new FullyQualifiedJavaType(intefaceName));
		 
		 //增加dao
		 Field field = new Field();
		 field.addAnnotation("@Resource");
		 field.setVisibility(JavaVisibility.PUBLIC);
		 field.setType(new FullyQualifiedJavaType(domainObjectName+"Dao"));
		 field.setName(this.getFirstCaseLowwer(domainObjectName)+"Dao");
		 
		 topLevelClass.addImportedType(new FullyQualifiedJavaType(introspectedTable.getMyBatis3JavaMapperType()));
		 topLevelClass.addImportedType(new FullyQualifiedJavaType("javax.annotation.Resource"));
		 topLevelClass.addField(field);
		 return topLevelClass;
	}
	
	private String getFirstCaseLowwer(String str){
		return str.substring(0, 1).toLowerCase()+str.substring(1);
	}

}
