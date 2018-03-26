package com.restraurant.service;

import com.restraurant.dao.UserDao;
import com.restraurant.entity.User;

public class UserService {

	private UserDao userDao;
	
	public User showUser(String userId){
		return userDao.showUser(userId);
	}

	public void addUser(User user){
		userDao.addUser(user);
	}

	public User userLogin(String userPhone,String userPassword){
		User user = userDao.getUser(userPhone, userPassword);
		if(user != null) user.setUserPassword(null);
		return user;
	}
	
	public void userRegister(User user){
		userDao.userRegister(user);
	}
/* 
 	===============================Getter Setter Constructor=====================================
*/
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
