package com.restraurant.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.restraurant.entity.Area;
import com.restraurant.entity.Category;
import com.restraurant.entity.Member;
import com.restraurant.entity.Product;
import com.restraurant.entity.User;

public class ProductDao {

	private SessionFactory sessionFactory;

	/**
	 * 获取全部物品
	 * @return List<Product>
	 */
	public List<Product> getAllProducts(){
		List<Product> list = sessionFactory.getCurrentSession().createCriteria(Product.class).list();
		return list;
	}
	
	public Product getProduct(String productId){
		Product product = (Product) sessionFactory.getCurrentSession().get(Product.class, productId);
		return product;
	}
	public List<Product> showAProductsByShopId(String shopId){
		List<Product> list = sessionFactory.getCurrentSession().createCriteria(Product.class)
				.add(Restrictions.eq("member", shopId)).list();
		return list;
	}
	public List<Category> getAllcategary(){
		List<Category> list = sessionFactory.getCurrentSession().createCriteria(Category.class).list();
		return list; 
	}
	public List<Area> getAllArea(){
		List<Area> list = sessionFactory.getCurrentSession().createCriteria(Area.class).list();
		return list; 
	}
	public List<Product> showAllProductsByKind(String type,Integer id){
		List<Product> p =new ArrayList<Product>();
		if("category".equals(type)){
			String sql = "select * from product where category="+id;
			p = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(Product.class).list();
		}else if ("area".equals(type)) {
			String sql = "SELECT * FROM product WHERE member = (SELECT member.memberid FROM member WHERE area='"+id+"')";
			p = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(Product.class).list();
		}else{
			return null;
		}
		return p;
	}
	public List<Product> showAllProductsByKind(String type,String id){
		List<Product> p =new ArrayList<Product>();
			String sql = "select * from product where member="+id;
			p = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(Product.class).list();
		return p;
	}
	public List<Product> showAProductsBySearch(String param){
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Product.class);
		if(param !=null){
			List<Product> l = criteria.add(Restrictions.or(Restrictions.like("productName","%"+param+"%"))).list();
			return l;
		}else{
			return null;
		}
	}
	public List<Member> showAllShop(){
		List<Member> list = sessionFactory.getCurrentSession().createCriteria(Member.class).list();
		sessionFactory.getCurrentSession().flush();
		return list;
	}
	public Member showShop (String shopId){
		Member shop = (Member) sessionFactory.getCurrentSession().get(Member.class, shopId);
		return shop;
	}
	
	public List<Product> showProductsByShop(String shopId){
		String sql = "select * from product where member="+shopId;
		List<Product> list = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(Product.class).list();
		return list;
	}
	public List<Product> showProductsByOrder(String orderType){
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Product.class);
		if("sell".equals(orderType)){
			criteria.addOrder(Order.desc("productSellNum"));
		}else if ("price".equals(orderType)) {
			criteria.addOrder(Order.asc("productCurrentPrize"));
		}
		return criteria.list();
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
