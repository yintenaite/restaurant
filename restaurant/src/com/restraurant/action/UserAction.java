package com.restraurant.action;

import java.util.UUID;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.restraurant.entity.User;
import com.restraurant.service.UserService;
import com.restraurant.util.DateUtil;
import com.restraurant.util.UuidUtil;

/**
 * 用户操作
 * @author dell
 *
 */
public class UserAction extends ActionSupport{

	private UserService userService;
	private User user; //添加用户时需要的对象。
	
	public String showUserMessage(){
		user = null;
		ActionContext at  = ActionContext.getContext();
		User u = (User) at.getSession().get("user");
		if(u != null){
			user = userService.showUser(u.getUserId());
		}
		
		return SUCCESS;
	}
	
	/**
	 * 增加会员
	 * @return String
	 */
	public String addUser(){
		//验证数据
		//验证数据
		//将数据封装成user  Start
		String userLoginName = "";
		String userNickName = "";
		String userPassword = "";
		String userPhone = "";
		String userAddress = "";
		user.setUserId(UuidUtil.getUUID());//32位uuid
		user.setUserLoginName(userLoginName);
		user.setUserNickName(userNickName);
		user.setUserPassword(userPassword);
		user.setUserPhone(userPhone);
		user.setUserAddress(userAddress);
		user.setUserCreateTime(DateUtil.getStringDate());
		//将数据封装成user End
		userService.addUser(user);
		return SUCCESS;
	}

	/**
	 * 会员登陆
	 * @return String
	 */
	public String userlogin(){
		ActionContext context = ActionContext.getContext();
		String loginResult = INPUT;//成功返回SUCCESS，失败返回INPUT
		String userLoginName = "admin";
		String userPassword = "admin";
		user = userService.userLogin(userLoginName,userPassword);
		//如果用户为空，返回用户名或密码错误；如果用户存在，注入到session
		if(user != null){
			if(context.getSession().get("user") != null) context.getSession().remove("user");//删除之前session
			context.getSession().put("user", user);
			loginResult = SUCCESS;
		}
		return loginResult;
	}
/* 
 	===============================Getter Setter Constructor=====================================
*/
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
}
