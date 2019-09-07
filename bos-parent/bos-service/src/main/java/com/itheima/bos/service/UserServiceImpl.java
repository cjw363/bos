package com.itheima.bos.service;

import com.itheima.bos.dao.IUserDao;
import com.itheima.bos.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements IUserService{
	@Autowired
	private IUserDao userDao;
	/***
	 * 用户登录
	 */
	public User login(User user) {
		return userDao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
	}
}
