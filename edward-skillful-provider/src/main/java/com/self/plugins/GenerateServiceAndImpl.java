package com.self.plugins;

import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.exception.ShellException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用mybatis生成接口继承和接口实现继承
 * @author weideliang
 *
 */
public class GenerateServiceAndImpl extends PluginAdapter{
/*	String modelClass = "";//model的类型 可选
	String criteriaClass = "";//criteria的类型 可选
	String daoClass ="";//dao的类型 可选
	String dao ="";//dao的类型 可选
	String singleDao ="";//singleDao的类型 可选 指定
	String baseImpl ="";//基本实现的类型  可选  指定
	String parentService = "";//parentService的类型 可选 指定
	
	String service = "";//service的类型
	String impl = "";//实现的类型
*/
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
		 //将首字母大写
		 String domainObjectName = introspectedTable.getTableConfiguration().getDomainObjectName();
		 String intefaceName = String.format(targetPackageName+".%sService", domainObjectName);
		 Interface inteface = new Interface(new FullyQualifiedJavaType(intefaceName));
		 inteface.setVisibility(JavaVisibility.PUBLIC);
		 //完整类
		 String fullName = getContext().getJavaModelGeneratorConfiguration().getTargetPackage() +"."+ domainObjectName;
		 inteface.addSuperInterface(new FullyQualifiedJavaType(String.format(properties.getProperty("parentService")+"<%s>",fullName)));
		 inteface.addImportedType(new FullyQualifiedJavaType(properties.getProperty("parentService")));
		 inteface.addImportedType(new FullyQualifiedJavaType(fullName));
		 return inteface;
	}
	
	private TopLevelClass getInterfaceImpl(IntrospectedTable introspectedTable){
		//添加名称
		 String implTargetPackage = properties.getProperty("implTargetPackage");
		 //将首字母大写
		 String domainObjectName = introspectedTable.getTableConfiguration().getDomainObjectName();
		 String intefaceImplName = String.format(implTargetPackage+".%sImpl", domainObjectName);
		 TopLevelClass topLevelClass = new TopLevelClass(new FullyQualifiedJavaType(intefaceImplName));
		 //在class添加@Rescouce
		 topLevelClass.addAnnotation("@Resource");
		 topLevelClass.addImportedType(new FullyQualifiedJavaType("javax.annotation.Resource"));

		 String modelTargetPackage = getContext().getJavaModelGeneratorConfiguration().getTargetPackage();
		 String modelName = modelTargetPackage +"."+ domainObjectName;
		 String daoName = modelName + "Criteria"; 
		 String superParentImplName = String.format(properties.getProperty("parentImpl")+"<%s,%s>", 
				 modelName, daoName);
		 topLevelClass.setSuperClass(new FullyQualifiedJavaType(superParentImplName));
		 //导入类型
		 topLevelClass.addImportedType(new FullyQualifiedJavaType(properties.getProperty("parentImpl")));
		 topLevelClass.addImportedType(new FullyQualifiedJavaType(daoName));
		 topLevelClass.addImportedType(new FullyQualifiedJavaType(modelName));
		 topLevelClass.setVisibility(JavaVisibility.PUBLIC);
		 //添加实现
		String targetPackageName = properties.getProperty("interfaceTargetPackage");
		String intefaceName = String.format(targetPackageName+".%sService", domainObjectName);
		topLevelClass.addSuperInterface(new FullyQualifiedJavaType(intefaceName));
		topLevelClass.addImportedType(new FullyQualifiedJavaType(intefaceName));
		 //添加字段
		 String filedDao =getContext().getJavaClientGeneratorConfiguration().getTargetPackage()+"."+domainObjectName+"Dao";
		 Field field = new Field(domainObjectName.substring(0,1).toLowerCase()+domainObjectName.substring(1)+"Dao",new FullyQualifiedJavaType(filedDao));
		 field.addAnnotation("@Resource");
		 topLevelClass.addImportedType(new FullyQualifiedJavaType(filedDao));
		 topLevelClass.addImportedType(new FullyQualifiedJavaType("javax.annotation.Resource"));
		 field.setVisibility(JavaVisibility.PRIVATE);
		 topLevelClass.addField(field);
		 //添加方法
		 Method method = new Method("getMyBatisRepository");
		 method.addAnnotation("@Override");
		 method.setVisibility(JavaVisibility.PUBLIC);
		 method.setReturnType(new FullyQualifiedJavaType(String.format("SingleTableDao<%s,%s>", 
				 modelName, daoName)));
		 method.addBodyLine("return "+domainObjectName.substring(0,1).toLowerCase()+domainObjectName.substring(1)+"Dao;");
		 topLevelClass.addImportedType(new FullyQualifiedJavaType(properties.getProperty("singleDao")));
		 topLevelClass.addMethod(method);
		 return topLevelClass;
	}
}
