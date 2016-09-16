package com.api.service;

import com.exception.MyBusinessException;
import com.provider.model.BaseMaterialClass;

public interface BaseMaterialClassService {
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	BaseMaterialClass selectById(Integer id);
	
	/**
	 * 修改
	 * @param baseMaterialClass
	 * @throws MyBusinessException 
	 */
	void update(BaseMaterialClass baseMaterialClass) throws MyBusinessException;
	
	void save(BaseMaterialClass baseMaterialClass) throws MyBusinessException;
	
	void insert(BaseMaterialClass baseMaterialClass) throws MyBusinessException;
}