package com.provider.serviceImpl;


import javax.annotation.Resource;

import com.provider.model.BaseMaterialClassCriteria;
import com.provider.model.BaseMaterialCriteria;
import com.provider.page.PageList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.api.service.BaseMaterialClassService;
import com.exception.MyBusinessException;
import com.provider.dao.BaseMaterialClassDao;
import com.provider.model.BaseMaterialClass;

import java.util.List;


@Service
public class BaseMaterialClassImpl implements BaseMaterialClassService {
	private Logger logger = LoggerFactory.getLogger(BaseMaterialClassImpl.class);  
	@Resource
	private BaseMaterialClassDao baseMaterialClassDao;

	@Override
	public BaseMaterialClass selectById(Integer id) {
		return baseMaterialClassDao.selectById(id);
	}

	private void update(BaseMaterialClass baseMaterialClass) throws MyBusinessException {
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
	
	private void insert(BaseMaterialClass baseMaterialClass) throws MyBusinessException {
		baseMaterialClassDao.insert(baseMaterialClass);
	}

	@Override
	public List<BaseMaterialClass> selectAll() {
		BaseMaterialClassCriteria criteria = new BaseMaterialClassCriteria();
		BaseMaterialClassCriteria.Criteria innerCriteria = criteria.or();
		return baseMaterialClassDao.selectByCriteria(criteria);
	}
}