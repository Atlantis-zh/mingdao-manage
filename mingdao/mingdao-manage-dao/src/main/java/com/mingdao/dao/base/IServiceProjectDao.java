package com.mingdao.dao.base;

import com.mingdao.domain.ServiceProject;

/**
 *
 * <code>IServiceProjectDao<code> <strong></strong>
 * <p>
 * 说明：服务项目的dao
 * <li></li>
 * </p>
 * 
 * @since
 * @version 2017年10月23日 上午12:08:16
 * @author libinf
 */

public interface IServiceProjectDao extends IBaseDao<ServiceProject> {
    public int deleteServiceProduct(int id);

}
