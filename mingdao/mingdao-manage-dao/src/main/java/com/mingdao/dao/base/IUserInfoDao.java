package com.mingdao.dao.base;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mingdao.domain.UserInfo;

import java.util.List;
import java.util.Map;

public interface IUserInfoDao extends IBaseDao<UserInfo>{

    /***
     *
     * @param param
     * @param pageBounds
     * @return
     */
    public List<UserInfo> getUserInfo(Map<String,Object> param,PageBounds pageBounds);

    public int getCountUser(Map<String,Object> param);

}
