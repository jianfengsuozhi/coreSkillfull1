package com.redis;

import com.api.service.PrivilegeService;
import com.common.AbstractTest;
import com.provider.model.Privilege;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class RedisTest extends AbstractTest {
	@Resource
	private PrivilegeService privilegeService;

	@Test
	public void testSelectAll(){
		List<Privilege> privileges = privilegeService.selectAll();
		System.out.println(privileges.size());
	}
}

