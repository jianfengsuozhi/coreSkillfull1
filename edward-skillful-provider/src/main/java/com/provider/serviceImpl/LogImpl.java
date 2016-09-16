package com.provider.serviceImpl;

import com.api.service.LogService;
import com.exception.MyDBFailException;
import com.exception.MyIllegalArgumentException;
import com.provider.dao.LogDao;
import com.provider.model.Log;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
@Service
public class LogImpl implements LogService {
	private Logger logger = LoggerFactory.getLogger(BaseMaterialClassImpl.class);
    @Resource
    public LogDao logDao;

	@Override
	public void save(Log log) {
		MyIllegalArgumentException.checkNull(log, logger, "log不能为null");
		if(null == log.getId()){
			this.insert(log);
		}else{
			this.update(log);
		}
	}

	private void insert(Log log) {
		int count = logDao.insert(log);
		MyDBFailException.checkTrue(count!=1, logger, "插入异常");
	}

	private void update(Log log) {
		int count = logDao.updateById(log);
		MyDBFailException.checkTrue(count!=1, logger, "更新异常");
	}
	
}