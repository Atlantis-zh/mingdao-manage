package com.mingdao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mingdao.api.IStoreBaseService;
import com.mingdao.common.utils.DateUtil;
import com.mingdao.domain.Store;

/**
 *
 * <code>TestStoreBaseService<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年9月27日 上午10:37:17
 * @author libinf
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring-config.xml"})
public class TestStoreBaseService {

  @Autowired
  private IStoreBaseService service;

  @Test
  @Rollback(false)
  public void testInsert() {
    Store st = new Store();
    st.setCode("0001");
    st.setName("北京总店");
    st.setTel1("16800");
    st.setAddress("北京中南海");
    st.setIsHeadStore(true);
    st.setCreateTime(DateUtil.getCurrentTimestamp());
    st = service.insert(st);
    System.out.println(st.getId());
  }

  @Test
  @Rollback(false)
  public void testUpdate() {
    Store st = new Store();
    st.setId(new Long(14));
    st.setCode("0002");
    st.setName("北京总店");
    st.setTel1("16800");
    st.setAddress("北京中南海");
    st.setIsHeadStore(true);
    st.setCreateTime(DateUtil.getCurrentTimestamp());
    int sst = service.update(st);
    System.out.println(sst);
  }

  @Test
  @Rollback(false)
  public void testDelete() {
    int sss = service.deleteDocById(new Long(14));
    System.out.println(sss);
  }
}
