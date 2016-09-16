package com.self.plugins;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;
import static org.mybatis.generator.internal.util.messages.Messages.getString;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;

public class RenameMapperXmlPlugin extends PluginAdapter{
	private String searchString;
	private String replaceString;
	private Pattern pattern;

	@Override
	public boolean validate(List<String> warnings) {
		searchString = properties.getProperty("searchString");
		boolean searchStringHasValue = this.validatePropertiesHasValue(searchString, warnings);
	    replaceString = properties.getProperty("replaceString");
		boolean replaceStringHasValue = this.validatePropertiesHasValue(replaceString, warnings);
		if(searchStringHasValue && replaceStringHasValue){
			pattern = Pattern.compile(searchString);
			return true;
		}
		return false;
	}
	
	private boolean validatePropertiesHasValue(String propertyName,List<String> warnings){
		boolean stringHasValue = stringHasValue(propertyName);
		if(!stringHasValue){
			warnings.add(getString("ValidationError.18", "RenamePlugin", propertyName));//[RenamePlugin requires the null property]
			return false;
		}
		return true;
	}
	
	@Override
	public void initialized(IntrospectedTable introspectedTable) {
		String myBatis3XmlMapperFileName = introspectedTable.getMyBatis3XmlMapperFileName();
		Matcher matcher = pattern.matcher(myBatis3XmlMapperFileName);
		myBatis3XmlMapperFileName = matcher.replaceAll(replaceString);
		introspectedTable.setMyBatis3XmlMapperFileName(myBatis3XmlMapperFileName);
	}

}
