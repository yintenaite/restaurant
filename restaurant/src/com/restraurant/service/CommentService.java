package com.restraurant.service;

import java.util.List;

import com.restraurant.dao.CommentDao;
import com.restraurant.entity.Comment;

public class CommentService {
	private CommentDao commentDao;
	
	public List<Comment> showCommentByProductId(String productId){
		return commentDao.showCommentByProductId(productId);
	}

	public CommentDao getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}
	
	

}
