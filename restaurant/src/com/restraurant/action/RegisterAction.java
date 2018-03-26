package com.restraurant.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.restraurant.entity.Area;
import com.restraurant.entity.Member;
import com.restraurant.entity.User;
import com.restraurant.service.ShopService;
import com.restraurant.service.UserService;
import com.restraurant.util.DateUtil;
import com.restraurant.util.UuidUtil;

public class RegisterAction extends ActionSupport{
	private UserService userService;
	private ShopService shopService;
	private String userPhone;
	private String userPassword;
	private String registerState;
	
	public String userRegister(){
		User user= new User(UuidUtil.getUUID(), userPhone, userPassword, userPhone, DateUtil.getStringDate());
		userService.userRegister(user);
		registerState = "success";
		ActionContext at  = ActionContext.getContext();
		at.getSession().put("user", user);
		return SUCCESS;
	}
	
	public String shopRegister(){
		 String memberName=null;
		 String memberPhone=null;
		 String shopName=null;
		 String shopAdress=null;
		 String shopImgUrl=null;
		 String shopMessage=null;
		 Area area=new Area(1);
		 Member member = new Member(UuidUtil.getUUID(), memberName, memberPhone, shopName, shopAdress, shopImgUrl, shopMessage, area);
		 shopService.shopRegister(member);
		 return SUCCESS;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
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

	public String getRegisterState() {
		return registerState;
	}

	public void setRegisterState(String registerState) {
		this.registerState = registerState;
	}

	public ShopService getShopService() {
		return shopService;
	}

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}

}
