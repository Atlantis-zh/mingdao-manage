package com.mingdao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mingdao.api.IMeasdocBaseService;
import com.mingdao.common.utils.DateUtil;
import com.mingdao.domain.Measdoc;

/**
 *
 * <code>TestMeasdocBaseService<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月26日 下午7:22:38
 * @author libinf
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-config.xml" })
public class TestMeasdocBaseService {

	@Autowired
	private IMeasdocBaseService service;

	@Test
	@Rollback(false)
	public void testInsert() {
		Measdoc doc = new Measdoc();
		doc.setCode("KG");
		doc.setName("千克");
		doc.setCreator(Long.valueOf("1"));
		doc.setCreateTime(DateUtil.getCurrentTimestamp());
		service.insert(doc);
		System.out.println(doc.getId());
	}

}
