package com.itheima.bos.web;

import com.itheima.bos.domain.User;
import com.itheima.bos.service.IUserService;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")//多例
public class UserAction extends BaseAction<User> {
	//属性驱动，接收页面输入的验证码
	private String checkcode;
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	
	@Autowired
	private IUserService userService;
	
	/**
	 * 用户登录
	 */
	public String login(){
			//输入的验证码正确
			User user = userService.login(model);
			if(user != null){
				//登录成功,将user对象放入session，跳转到首页
				ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
				return SUCCESS;
			}else{
				//登录失败，,设置提示信息，跳转到登录页面
				//输入的验证码错误,设置提示信息，跳转到登录页面
				this.addActionError("用户名或者密码输入错误！");
				return LOGIN;
			}
	}
}
