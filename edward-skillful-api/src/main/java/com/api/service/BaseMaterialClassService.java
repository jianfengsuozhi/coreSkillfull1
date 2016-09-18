package com.api.service;

import com.exception.MyBusinessException;
import com.provider.model.BaseMaterialClass;
import com.provider.page.PageList;

import java.util.List;

public interface BaseMaterialClassService {
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	BaseMaterialClass selectById(Integer id);
	
	/**
	 * 插入和修改
	 * @param baseMaterialClass
	 * @throws MyBusinessException 
	 */
	void save(BaseMaterialClass baseMaterialClass) throws MyBusinessException;

	List<BaseMaterialClass> selectAll();
}