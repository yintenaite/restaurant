package com.restraurant.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.restraurant.entity.User;
import com.restraurant.service.UserService;

public class LoginAction extends ActionSupport{
	
	private UserService userService;
	private String userPhone;
	private String userPassword;
	private String loginState;
	
	public String userLogin(){
		User u = userService.userLogin(userPhone,userPassword);
			if(u != null){
				ActionContext at  = ActionContext.getContext();
				at.getSession().put("user", u);
				loginState = "success";
			}else{
				loginState = "error";
			}
			return SUCCESS;
		}
		
	public String logout(){
		ActionContext at  = ActionContext.getContext();
		at.getSession().remove("user");
		return SUCCESS;
	}
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getLoginState() {
		return loginState;
	}

	public void setLoginState(String loginState) {
		this.loginState = loginState;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
