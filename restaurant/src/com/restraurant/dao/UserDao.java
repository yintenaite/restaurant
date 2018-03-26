package com.restraurant.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.restraurant.entity.User;

public class UserDao {
	private SessionFactory sessionFactory;
	
	public User showUser(String userId){
		return (User) sessionFactory.getCurrentSession().get(User.class, userId);
	}
	/**
	 * 增加用户
	 * @param user
	 */
	public void addUser(User user){
		sessionFactory.getCurrentSession().save(user);
		sessionFactory.getCurrentSession().flush();
	} 
	
	/**
	 * 登陆时获取用户信息
	 * @param userLoginName
	 * @param userLoginPassword
	 * @return User
	 */
	public User getUser(String userPhone,String userPassword){
		User user = (User) sessionFactory.getCurrentSession().createCriteria(User.class)
					.add(Restrictions.eq("userPhone", userPhone))
					.add(Restrictions.eq("userPassword",userPassword ))
					.uniqueResult();
		return user == null?null:user;
	}
	public void userRegister(User user){
		sessionFactory.getCurrentSession().save(user);
		sessionFactory.getCurrentSession().flush();
	}
		
	
/*
 * ===========================Getter  Setter mothod=====================================
 */
	 
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
