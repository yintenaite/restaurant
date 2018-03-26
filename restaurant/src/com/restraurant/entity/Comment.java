package com.restraurant.entity;

public class Comment {
	private Integer commentId;
	private String commentContent;
	private float commentCore;
	private String commentDate;
	private String productId;
	private User user;
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Comment(String commentContent, String commentDate, String productId,
			User user) {
		super();
		this.commentContent = commentContent;
		this.commentDate = commentDate;
		this.productId = productId;
		this.user = user;
	}

	public Comment(String commentContent, float commentCore,
			String commentDate, String productId, User user) {
		super();
		this.commentContent = commentContent;
		this.commentCore = commentCore;
		this.commentDate = commentDate;
		this.productId = productId;
		this.user = user;
	}
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public float getCommentCore() {
		return commentCore;
	}
	public void setCommentCore(float commentCore) {
		this.commentCore = commentCore;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
}
