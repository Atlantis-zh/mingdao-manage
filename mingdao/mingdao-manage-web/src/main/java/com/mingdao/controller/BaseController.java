package com.mingdao.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import com.mingdao.common.utils.DateUtil;
import com.mingdao.domain.SuperVO;

/**
 * Created by ambitious on 2017/9/28.
 */
public class BaseController {

  private static final String USERID = "userId";

  /**
   * 
   * <p>
   * 说明：暂时不处理新增人和修改人 后续再考虑如何设计
   * <li></li>
   * </p>
   * 
   * @param vo
   * @param request
   * @date 2017年11月19日 下午4:05:11
   * @since NC6.5
   */
  public void setTimeStampWithInsert(SuperVO vo, HttpServletRequest request) {
    // HttpSession session = request.getSession();
    // Long userId = (Long) session.getAttribute(USERID);
    Timestamp date = DateUtil.getCurrentTimestamp();
    vo.setCreateTime(date);
  }

  public void setTimeStampWithUpdate(SuperVO vo, HttpServletRequest request) {
    // HttpSession session = request.getSession();
    // long userId = (long) session.getAttribute(USERID);
    Timestamp date = DateUtil.getCurrentTimestamp();
    vo.setModifiedTime(date);
  }

}
