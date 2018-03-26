package com.restraurant.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.restraurant.entity.Member;
import com.restraurant.entity.User;

public class ShopDao {

	private SessionFactory sessionFactory;
	
	public Member shopLogin(String shopPhone,String shopPassword){
		Member m = (Member) sessionFactory.getCurrentSession().createCriteria(Member.class)
				.add(Restrictions.eq("memberPhone", shopPhone))
				.add(Restrictions.eq("memberPassword",shopPassword ))
				.uniqueResult();
	return m;
	}
	
	public Member showShop(String shopId){
		return (Member) sessionFactory.getCurrentSession().get(Member.class, shopId);
	}
	
	public Member getShopByProduct(String shopId){
		Member shop = (Member) sessionFactory.getCurrentSession().createCriteria(Member.class)
				.add(Restrictions.eq("memberId", shopId))
				.uniqueResult();
	return shop == null?null:shop;
	}
	public void shopRegister(Member member){
		sessionFactory.getCurrentSession().save(member);
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}
