package com.mingdao.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.api.IAttachProjectBaseService;
import com.mingdao.common.pageUtil.PageBoundsUtil;
import com.mingdao.common.pageUtil.Pager;
import com.mingdao.dao.base.IAttachProjectDao;
import com.mingdao.domain.AttachProject;

/**
 *
 * <code>AttachProjectBaseServiceImpl<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月18日 下午4:32:06
 * @author libin
 */

@Service("attachProjectBaseService")
public class AttachProjectBaseServiceImpl implements IAttachProjectBaseService {
  @Autowired
  private IAttachProjectDao attachProjectDao;

  @Override
  public AttachProject insert(AttachProject t) {
    attachProjectDao.insertVO(t);
    return t;
  }

  @Override
  public AttachProject update(AttachProject t) {
    attachProjectDao.updateVO(t);
    return t;
  }

  @Override
  public Pager<AttachProject> pageQueryByCondition(Map<String, Object> param) {
    int count = attachProjectDao.getCountByCondition(param);
    PageBounds pageBounds = PageBoundsUtil.PageBoundsOrderExtend("modifiedtime.desc");
    List<AttachProject> list = attachProjectDao.pageQueryByCondition(param, pageBounds);
    Pager<AttachProject> pages = new Pager<AttachProject>(count, list);
    return pages;
  }

  @Override
  public AttachProject singleQryByCondtion(Map<String, Object> param) {
    return null;
  }

  @Override
  public List<AttachProject> qryAllDoces(Map<String, Object> param) {
    return null;
  }

  @Override
  public void deleteDocById(Long id) {}

  @Override
  public AttachProject queryDocById(Long id) {
    return null;
  }

}
