package com.ccc.my.project.web.admin.service;

import com.ccc.my.project.commons.persistence.BaseService;
import com.ccc.my.project.domain.TbUser;



/**
 * @author ccc
 * @create 2019-10-25 14:18
 */
public interface TbUserService extends BaseService <TbUser> {

    /**
     * 用户登陆
     * @param email
     * @param password
     * @return
     */
    TbUser login(String email,String password);


}
