package com.itheima.bos.dao;

import com.itheima.bos.base.IBaseDao;
import com.itheima.bos.domain.User;

/**
 * @Classname IUserDao
 * @Description
 * @Date 2019/9/7 14:21
 * @Created by cjw
 */
public interface IUserDao extends IBaseDao<User> {
    User findUserByUsernameAndPassword(String username, String password);
}
