package com.self.plugins;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
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
		 inteface.addSuperInterface(new FullyQualifiedJavaType(properties.getProperty("parentService")));
		 inteface.addImportedType(new FullyQualifiedJavaType(properties.getProperty("parentService")));
		 return inteface;
	}
	
	private TopLevelClass getInterfaceImpl(IntrospectedTable introspectedTable){
		//添加名称
		 String targetPackageName = properties.getProperty("implTargetPackage");
		 //将首字母大写
		 String domainObjectName = introspectedTable.getTableConfiguration().getDomainObjectName();
		 String intefaceImplName = String.format(targetPackageName+".%sImpl", domainObjectName);
		 TopLevelClass topLevelClass = new TopLevelClass(new FullyQualifiedJavaType(intefaceImplName));
		 String modelTargetPackage = getContext().getJavaModelGeneratorConfiguration().getTargetPackage();
		 String modelName = modelTargetPackage +"."+ domainObjectName;
		 String daoName = modelName + "Criteria"; 
		 String superParentImplName = String.format(properties.getProperty("parentImpl")+"<%s,%s>", 
				 modelName, daoName);
		 topLevelClass.setSuperClass(new FullyQualifiedJavaType(superParentImplName));
		 //导入类型
		 topLevelClass.addImportedType(new FullyQualifiedJavaType(properties.getProperty("parentImpl")));
		 topLevelClass.addImportedType(new FullyQualifiedJavaType(daoName));
		 topLevelClass.addImportedType(new FullyQualifiedJavaType(daoName));
		 topLevelClass.setVisibility(JavaVisibility.PUBLIC);
		 //添加字段
		 String filedDao =getContext().getJavaClientGeneratorConfiguration().getTargetPackage()+"."+domainObjectName+"Dao";
		 Field field = new Field(domainObjectName+"Dao",new FullyQualifiedJavaType(filedDao));
		 topLevelClass.addImportedType(new FullyQualifiedJavaType(filedDao));
		 field.setVisibility(JavaVisibility.PRIVATE);
		 topLevelClass.addField(field);
		 //添加方法
		 Method method = new Method("getMyBatisRepository");
		 method.addAnnotation("@Override");
		 method.setVisibility(JavaVisibility.PUBLIC);
		 method.setReturnType(new FullyQualifiedJavaType(String.format("SingleTableDao<%s,%s>", 
				 modelName, daoName)));
		 method.addBodyLine("return "+domainObjectName+"Dao;");
		 topLevelClass.addImportedType(new FullyQualifiedJavaType("com.provider.page.SingleTableDao"));
		 topLevelClass.addMethod(method);
		 return topLevelClass;
	}
}
