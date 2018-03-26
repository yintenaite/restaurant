package com.restraurant.entity;

public class Order {
	private Integer orderId;
	private String orderNum;
	private Float orderPrice;
	private Boolean orderIsComment;
	private String orderDate;
	private String productId;
	private String productName;
	private Float productPrice;
	private Integer productCount;
	private String memberId;
	private User user;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Order(String orderNum, Float orderPrice, Boolean orderIsComment,
			String orderDate, String productId, String productName,
			String memberId) {
		super();
		this.orderNum = orderNum;
		this.orderPrice = orderPrice;
		this.orderIsComment = orderIsComment;
		this.orderDate = orderDate;
		this.productId = productId;
		this.productName = productName;
		this.memberId = memberId;
	}




	public Order(String orderNum, Float orderPrice, Boolean orderIsComment,
			String orderDate, String productId, String productName,
			String memberId, User user) {
		super();
		this.orderNum = orderNum;
		this.orderPrice = orderPrice;
		this.orderIsComment = orderIsComment;
		this.orderDate = orderDate;
		this.productId = productId;
		this.productName = productName;
		this.memberId = memberId;
		this.user = user;
	}




	public Order(String orderNum, Float orderPrice, Boolean orderIsComment,
			String orderDate, String productId, String memberId) {
		super();
		this.orderNum = orderNum;
		this.orderPrice = orderPrice;
		this.orderIsComment = orderIsComment;
		this.orderDate = orderDate;
		this.productId = productId;
		this.memberId = memberId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public Float getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(Float orderPrice) {
		this.orderPrice = orderPrice;
	}
	public Boolean getOrderIsComment() {
		return orderIsComment;
	}
	public void setOrderIsComment(Boolean orderIsComment) {
		this.orderIsComment = orderIsComment;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}

	
	public Integer getProductCount() {
		return productCount;
	}

	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}

	public Float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}
	
	
}
