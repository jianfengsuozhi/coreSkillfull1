package com.provider.serviceImpl;

import com.api.service.BaseMaterialService;
import com.provider.dao.BaseMaterialDao;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;


@Service
public class BaseMaterialImpl implements BaseMaterialService {
    @Resource
    public BaseMaterialDao baseMaterialDao;
}