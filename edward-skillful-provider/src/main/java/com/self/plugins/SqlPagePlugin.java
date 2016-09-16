package com.self.plugins;

import java.util.Iterator;
import java.util.List;

import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

public class SqlPagePlugin extends PluginAdapter{

	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}
	
	@Override
	public boolean sqlMapDocumentGenerated(Document document,
			IntrospectedTable introspectedTable) {
		//mapper
		XmlElement rootElement = document.getRootElement();
		
		XmlElement sqlElement = new XmlElement("sql");
		sqlElement.addAttribute(new Attribute("id", "mysqlDialectPage"));
		XmlElement ifElement = new XmlElement("if");
		ifElement.addAttribute(new Attribute("test", "page != null and page.begin != null and page.begin gte 0"));
		ifElement.addElement(new TextElement("offset #{page.begin}"));
		sqlElement.addElement(ifElement);
		
		XmlElement ifElement1 = new XmlElement("if");
		ifElement1.addAttribute(new Attribute("test", "page != null and page.pageSize != null and page.pageSize gte 0"));
		ifElement1.addElement(new TextElement("limit #{page.pageSize}"));
		sqlElement.addElement(ifElement1);
		
		rootElement.addElement(sqlElement);
		return super.sqlMapDocumentGenerated(document, introspectedTable);
	}
	
	@Override
	public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(
			XmlElement element, IntrospectedTable introspectedTable) {
		XmlElement xmlElement = new XmlElement("include");
		xmlElement.addAttribute(new Attribute("refid", "mysqlDialectPage"));
		element.addElement(xmlElement);
		return super.sqlMapSelectByExampleWithoutBLOBsElementGenerated(element,
				introspectedTable);
	}
	@Override
	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		//是设置超级类不是addSuperInterface
		topLevelClass.setSuperClass(new FullyQualifiedJavaType(properties.getProperty("pageCriteriaPackage")+".PageCriteria"));
		topLevelClass.addImportedType(new FullyQualifiedJavaType(properties.getProperty("pageCriteriaPackage")+".PageCriteria"));
		Iterator<Field> fields = topLevelClass.getFields().iterator();
		while(fields.hasNext()){
			String name = fields.next().getName();
			if("orderByClause".equals(name)){
				fields.remove();
				break;
			}
		}
		Iterator<Method> methods = topLevelClass.getMethods().iterator();
		while(methods.hasNext()){
			//方法名
			String name = methods.next().getName();
			if("setOrderByClause".equals(name) || "getOrderByClause".equals(name)){
				methods.remove();
			}
		}
		Iterator<InnerClass> innerClasses = topLevelClass.getInnerClasses().iterator();
		while(innerClasses.hasNext()){
			//类名
			String shortName = innerClasses.next().getType().getShortName();
			if("Criterion".equals(shortName)){
				innerClasses.remove();
			}
		}
		return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
	}

}
