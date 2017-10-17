package com.mingdao.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mingdao.api.ICustomerBaseService;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.domain.Customer;
import com.mingdao.enumprop.Sex;
import com.mingdao.enumprop.Source;

/**
 *
 * <code>TestCustomerBaseService<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月17日 下午4:02:50
 * @author libinf
 */

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-config.xml" })
public class TestCustomerBaseService {

	@Autowired
	private ICustomerBaseService service;

	@Test
	@Rollback(false)
	public void testInsert() {
		Customer c = new Customer();
		c.setName("libinf");
		c.setCode("libinf");
		c.setBirthday("1991-10-10");
		c.setAddress("北京市海淀区用友软件园");
		c.setIdentityId("123456789");
		c.setCustSource(Source.STORE);
		c.setPhone("13800138000");
		c.setSex(Sex.MEN);
		c.setStoreId(new Long("1"));
		service.insert(c);
		System.out.println(c.getId());
	}

	@Test
	@Rollback(false)
	public void testQueryAndUpdate() {
		Map<String, Object> param=new HashMap<>();
		param.put("id", new Long(1));
		Pager<Customer> result = service.pageQueryByCondition(param);
		List<Customer> list = result.getDatas();
		Customer c = list.get(0);
		c.setName("wushzh");
		service.update(c, null);
		System.out.println("done");
	}

}
