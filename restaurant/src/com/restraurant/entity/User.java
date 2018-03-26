package com.restraurant.entity;

public class User {
	private String userId;		 //用户辨识id
	private String userLoginName;//用户登陆名
	private String userNickName; //用户昵称
	private String userTrueName; //用户真实姓名
	private String userPassword; //用户登陆密码
	private String userPhone;    //用户手机
	private String userAddress;  //用户地址
	private String userCreateTime;//用户注册时间
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String userId, String userNickName, String userPassword,
			String userPhone, String userCreateTime) {
		super();
		this.userId = userId;
		this.userNickName = userNickName;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userCreateTime = userCreateTime;
	}

	public User(String userId, String userLoginName, String userNickName,
			String userTrueName, String userPassword, String userPhone,
			String userAddress, String userCreateTime) {
		super();
		this.userId = userId;
		this.userLoginName = userLoginName;
		this.userNickName = userNickName;
		this.userTrueName = userTrueName;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
		this.userCreateTime = userCreateTime;
	}
	
	public User(String userId, String userLoginName, String userNickName,
			String userTrueName, String userPassword, String userPhone,
			String userCreateTime) {
		super();
		this.userId = userId;
		this.userLoginName = userLoginName;
		this.userNickName = userNickName;
		this.userTrueName = userTrueName;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userCreateTime = userCreateTime;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserLoginName() {
		return userLoginName;
	}
	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public String getUserTrueName() {
		return userTrueName;
	}
	public void setUserTrueName(String userTrueName) {
		this.userTrueName = userTrueName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserCreateTime() {
		return userCreateTime;
	}
	public void setUserCreateTime(String userCreateTime) {
		this.userCreateTime = userCreateTime;
	}
	
	
}