package com.ccc.my.project.web.api.dao;

import com.ccc.my.project.commons.dto.BaseResult;
import com.ccc.my.project.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <a>Author<a>
 * <a>Description<a>
 *
 * @Author ccc
 * @Date 2019/12/10 18:41
 * @Version 1.0.0
 */
@Repository
public interface TbUserDao {
    TbUser login(TbUser tbUser);
}
