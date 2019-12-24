package com.ccc.my.project.web.api.service.impl;

import com.ccc.my.project.commons.dto.BaseResult;
import com.ccc.my.project.domain.TbUser;
import com.ccc.my.project.web.api.dao.TbUserDao;
import com.ccc.my.project.web.api.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a>Author<a>
 * <a>Description<a>
 *
 * @Author ccc
 * @Date 2019/12/10 18:41
 * @Version 1.0.0
 */
@Service
public class TbUserSeerviceImpl implements TbUserService {

    @Autowired
    private TbUserDao tbUserDao;

    @Override
    public TbUser login(TbUser tbUser) {
        TbUser user = tbUserDao.login(tbUser);

        if (user != null) {
            //明文密码加密之后进行对比
            String pwd = DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes());
            if (pwd.equals(user.getPassword())) {
                return  user;
            }
        }
        return null;
    }
}
