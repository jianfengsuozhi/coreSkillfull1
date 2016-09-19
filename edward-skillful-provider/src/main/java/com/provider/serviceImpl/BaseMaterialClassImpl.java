package com.provider.serviceImpl;


import com.api.page.AbstractBaseServiceImpl;
import com.api.page.Page;
import com.api.page.PageList;
import com.api.page.SingleTableDao;
import com.api.service.BaseMaterialClassService;
import com.exception.MyIllegalArgumentException;
import com.provider.dao.BaseMaterialClassDao;
import com.provider.model.BaseMaterialClass;
import com.provider.model.BaseMaterialClassCriteria;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class BaseMaterialClassImpl extends AbstractBaseServiceImpl<BaseMaterialClass,BaseMaterialClassCriteria> implements BaseMaterialClassService {
	private Logger logger = LoggerFactory.getLogger(BaseMaterialClassImpl.class);  
	@Resource
	private BaseMaterialClassDao baseMaterialClassDao;

	@Override
	protected SingleTableDao<BaseMaterialClass, BaseMaterialClassCriteria> getMyBatisRepository() {
		return baseMaterialClassDao;
	}

	@Override
	public PageList<BaseMaterialClass> pageList(String className, Page page) {
		BaseMaterialClassCriteria criteria = new BaseMaterialClassCriteria();
		BaseMaterialClassCriteria.Criteria innerCriteria = criteria.or();
		if(StringUtils.isNotBlank(className)){
			innerCriteria.andClassNameLikeInsensitive("%"+className.trim()+"%");
		}
		criteria.setOrderByClause("order_no,class_name");
		criteria.setPage(page);
		return this.queryPageList(criteria,page);
	}
}