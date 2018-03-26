package com.restraurant.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.restraurant.entity.Order;
import com.restraurant.entity.Product;

public class PayDao {

	private SessionFactory sessionFactory;
	
	public void pay(List<Order> orders){
		Session session = sessionFactory.getCurrentSession();
		Session sess = sessionFactory.getCurrentSession();
		for(int i=0;i<orders.size();i++){
			session.save(orders.get(i));
			session.flush();
			Product p =(Product) sess.get(Product.class, orders.get(i).getProductId());
			sess.flush();
			p.setProductSellNum( p.getProductSellNum()+orders.get(i).getProductCount());
			sess.update(p);
		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	

}
