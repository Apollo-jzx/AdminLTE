package com.ccc.my.project.web.admin.dao;

import com.ccc.my.project.commons.persistence.BaseDao;
import com.ccc.my.project.domain.TbUser;
import org.springframework.stereotype.Repository;


/**
 * @author ccc
 * @create 2019-10-25 14:15
 */
@Repository
public interface TbUserDao extends BaseDao <TbUser> {

    /*用户登陆1*/
    /* public TbUser login(@Param(value = "email") String email,@Param(value = "password") String password);*/
    /*
     * 用户登陆2
     * */
    TbUser login(String email);

}
