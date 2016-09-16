package com.provider.serviceImpl;


import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.api.service.BaseMaterialClassService;
import com.exception.MyBusinessException;
import com.provider.dao.BaseMaterialClassDao;
import com.provider.model.BaseMaterialClass;


@Service
public class BaseMaterialClassImpl implements BaseMaterialClassService {
	private Logger logger = LoggerFactory.getLogger(BaseMaterialClassImpl.class);  
	@Resource
	private BaseMaterialClassDao baseMaterialClassDao;

	@Override
	public BaseMaterialClass selectById(Integer id) {
		return baseMaterialClassDao.selectById(id);
	}

	@Override
	public void update(BaseMaterialClass baseMaterialClass) throws MyBusinessException {
		baseMaterialClassDao.updateByIdSelective(baseMaterialClass);
//		MyBusinessException.checkTrue(1==1, logger, "测试可检查异常");
	}

	@Override
	public void save(BaseMaterialClass baseMaterialClass) throws MyBusinessException {
		if(null == baseMaterialClass.getClassId()){
			this.insert(baseMaterialClass);
		}else{
			this.update(baseMaterialClass);
		}
	}
	
	@Override
	public void insert(BaseMaterialClass baseMaterialClass) throws MyBusinessException {
		baseMaterialClassDao.insert(baseMaterialClass);
	}
}