package com.self.plugins;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;
import static org.mybatis.generator.internal.util.messages.Messages.getString;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.exception.ShellException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class RenameMapperJavaPlugin extends PluginAdapter{
	private String searchString;
	private String replaceString;
	private Pattern pattern;
	
	public RenameMapperJavaPlugin() {
		super();
	}
	
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
	public boolean clientGenerated(Interface interfaze,
			TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		//判断相关dao是否存在,若存在则不继续生成
		DefaultShellCallback defaultShellCallback = new DefaultShellCallback(false);
		File directory;
		try {
			//将com.a 变成 com/a
			directory = defaultShellCallback.getDirectory(properties.getProperty("targetProject"), properties.getProperty("targetPackage"));
			File file = new File(directory,introspectedTable.getTableConfiguration().getDomainObjectName()+"Dao.java");
			if(file.exists()){
				//false 该文件不生成
				return false;
			}
		} catch (ShellException e) {
			return false;
		}
		
		//属性可自己添加
		String superInterface = String.format(properties.getProperty("daoInterface")+"<%s,%s>",
				introspectedTable.getBaseRecordType(),introspectedTable.getExampleType());
		FullyQualifiedJavaType fullyQualifiedJavaType = new FullyQualifiedJavaType(superInterface);
		interfaze.addSuperInterface(fullyQualifiedJavaType);
		interfaze.addImportedType(new FullyQualifiedJavaType(properties.getProperty("daoInterface")));
		interfaze.addImportedType(new FullyQualifiedJavaType(introspectedTable.getBaseRecordType()));
		interfaze.addImportedType(new FullyQualifiedJavaType(introspectedTable.getExampleType()));
		
		//使用iterator而不是用list<>便于删除 对其进行删除就是对interfaze的方法进行删除(引用)
		Iterator<Method> iterator = interfaze.getMethods().iterator();
		while(iterator.hasNext()){
			String name = iterator.next().getName();
			if("countByCriteria".equals(name)||"deleteByCriteria".equals(name)||"deleteById".equals(name)
					||"insert".equals(name)||"insertSelective".equals(name)||"selectByCriteria".equals(name)
					||"selectById".equals(name)||"updateByCriteriaSelective".equals(name)||"updateByCriteria".equals(name)
					||"updateByIdSelective".equals(name)||"updateById".equals(name)){
				iterator.remove();
			}
		}
		return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
	}
	
	@Override
	public void initialized(IntrospectedTable introspectedTable) {
			//改名方式
//		String exampleType = introspectedTable.getExampleType();//com.provider.model.StudentExample
//		String baseRecordType = introspectedTable.getBaseRecordType();//com.provider.model.Student
//		String myBatis3JavaMapperType = introspectedTable.getMyBatis3JavaMapperType();//com.provider.dao.StudentMapper
//		String myBatis3XmlMapperFileName = introspectedTable.getMyBatis3XmlMapperFileName();//StudentMapper.xml
//		String myBatis3SqlProviderType = introspectedTable.getMyBatis3SqlProviderType();//com.provider.dao.StudentSqlProvider
//		System.out.println(myBatis3JavaMapperType);
		String myBatis3JavaMapperType = introspectedTable.getMyBatis3JavaMapperType();
		Matcher matcher = pattern.matcher(myBatis3JavaMapperType);
		myBatis3JavaMapperType = matcher.replaceAll(replaceString);
		introspectedTable.setMyBatis3JavaMapperType(myBatis3JavaMapperType);
		
		introspectedTable.setCountByExampleStatementId("countByCriteria");
		introspectedTable.setDeleteByExampleStatementId("deleteByCriteria");
		introspectedTable.setDeleteByPrimaryKeyStatementId("deleteById");
		introspectedTable.setInsertStatementId("insert");
		introspectedTable.setInsertSelectiveStatementId("insertSelective");
		
		introspectedTable.setSelectByExampleStatementId("selectByCriteria");
		introspectedTable.setSelectByPrimaryKeyStatementId("selectById");
		introspectedTable.setUpdateByExampleSelectiveStatementId("updateByCriteriaSelective");
		introspectedTable.setUpdateByExampleStatementId("updateByCriteria");
		introspectedTable.setUpdateByPrimaryKeySelectiveStatementId("updateByIdSelective");
		introspectedTable.setUpdateByPrimaryKeyStatementId("updateById");
		
        introspectedTable.setBaseResultMapId("Base_Result_Map"); //$NON-NLS-1$
        introspectedTable.setExampleWhereClauseId("Criteria_Where_Clause"); //$NON-NLS-1$
        introspectedTable.setBaseColumnListId("Base_Column_List"); //$NON-NLS-1$
        introspectedTable.setMyBatis3UpdateByExampleWhereClauseId("Update_By_Criteria_Where_Clause"); //$NON-NLS-1$
    }

}
