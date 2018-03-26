package com.restraurant.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.restraurant.entity.Comment;

public class CommentDao {

	private SessionFactory sessionFactory;
	
	public List<Comment> showCommentByProductId(String productId){
		List<Comment> list=sessionFactory.getCurrentSession().createCriteria(Comment.class)
			    .add(Restrictions.eq("productId",productId)).list();
		return list;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}
