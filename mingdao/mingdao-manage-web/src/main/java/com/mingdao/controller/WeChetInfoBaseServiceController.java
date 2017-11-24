package com.mingdao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mingdao.api.ICustomerBaseService;
import com.mingdao.api.IWeChetInfoBaseService;

/**
 *
 * <code>WeChetInfoBaseServiceController<code> <strong></strong>
 * <p>
 * 说明：
 * <li></li>
 * </p>
 * 
 * @since NC6.5
 * @version 2017年11月25日 上午4:54:19
 * @author libin
 */

@Controller
@RequestMapping("/wechetInfoBaseSer")
public class WeChetInfoBaseServiceController extends BaseController {

  @Autowired
  private IWeChetInfoBaseService wiBaseService;

  private ICustomerBaseService custBaseService;

}
