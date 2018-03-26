package com.restraurant.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.restraurant.entity.Comment;
import com.restraurant.entity.Order;
import com.restraurant.entity.Product;

public class OrderManagerDao {
	private SessionFactory sessionFactory;
	
	public void submitComment(Comment comment,String orderId){
		//sessionFactory.getCurrentSession().save(comment);
		List<Comment> commentList = new ArrayList<Comment>(); 
		List<Order> list = showOrdersByOrderNum(orderId);
		for(int i=0;i<list.size();i++){
			Comment c = new Comment(comment.getCommentContent(),comment.getCommentCore(), comment.getCommentDate(),list.get(i).getProductId(), comment.getUser());
			commentList.add(c);
		}
		for(int i=0;i<commentList.size();i++){
			sessionFactory.getCurrentSession().save(commentList.get(i));
			sessionFactory.getCurrentSession().flush();
			sessionFactory.getCurrentSession().clear();
		}
		for(int i=0;i<list.size();i++){
			String productId = list.get(i).getProductId();
			Product p = (Product) sessionFactory.getCurrentSession().get(Product.class,productId );
			if(p!=null){
				Float core = p.getProductCore();
				Integer count = p.getProductSellNum();
				core = ((core*count)+comment.getCommentCore())/(count+1);
				p.setProductCore(core);
				sessionFactory.getCurrentSession().update(p);
			}
		}
		for(int i=0;i<list.size();i++){
			list.get(i).setOrderIsComment(true);
			sessionFactory.getCurrentSession().update(list.get(i));
			sessionFactory.getCurrentSession().flush();
			sessionFactory.getCurrentSession().clear();
		}
		
	}
	public List<Order> showOrdersByOrderNum(String orderNum){
		List<Order> list = sessionFactory.getCurrentSession().createCriteria(Order.class).add(Restrictions.eq("orderNum", orderNum))
				.list();
		/*for(int i=0; i<list.size();i++){
			String productId = list.get(i).getProductId();
			Product p = (Product) sessionFactory.getCurrentSession().get(Product.class,productId);
			list.get(i).setProductName(p.getProductName());
		}*/
		return list;
	}

	public List<Order> showOrdersByUser(String userId){
		String sql = "SELECT * FROM productorder WHERE `user`="+userId+" GROUP BY ordernum";
		List<Order> list = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(Order.class).list();
		return list;
	}
	
	public List<Order> showOrdersByShop(String shopId){
		String sql = "SELECT * FROM productorder WHERE memberid ="+shopId+" GROUP BY ordernum";
		List<Order> list = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(Order.class).list();
		return list;
		
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}
