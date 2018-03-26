package com.restraurant.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.restraurant.entity.Comment;
import com.restraurant.entity.Member;
import com.restraurant.entity.Order;
import com.restraurant.entity.Product;
import com.restraurant.entity.User;
import com.restraurant.service.OrderManagerService;
import com.restraurant.util.DateUtil;

public class OrderManagerAction extends ActionSupport{
	private OrderManagerService orderManagerService;
	private String userId;
	private String shopId;
	private List<Order> orders;
	private String orderNum;
	private List<Product> products;
	private Double totalPrice;
	private String core;
	private String content;
	private String productId;
	private String orderId;
	private Boolean isComment;
	
	public String submitComment() throws UnsupportedEncodingException{
		System.out.println("asdasdas");
		ActionContext at  = ActionContext.getContext();
		User user = (User) at.getSession().get("user");
		String newContent = new String(content.getBytes("ISO8859-1"),"utf-8");
		Comment comment = new Comment(newContent, new Float(core), DateUtil.getStringDate(), productId, user);
		orderManagerService.submitComment(comment,orderId);
		return SUCCESS;
			
	}
	
	public String showOrderByOrderNum(){
		totalPrice = new Double(0);
		isComment = false;
		orders = null;
		orders = orderManagerService.showOrdersByOrderNum(orderNum);
		for(int i=0;i<orders.size();i++){
			totalPrice +=orders.get(i).getProductCount()*orders.get(i).getProductPrice();
		}
		isComment = orders.get(0).getOrderIsComment();
		
		return SUCCESS;
	}
	
	public String showShopOrderByOrderNum(){
		return showOrderByOrderNum();
	}
	
	public String showUserOrders(){  
		orders = null;
		ActionContext at  = ActionContext.getContext();
		User user = (User) at.getSession().get("user");
		if(user != null){
			orders = orderManagerService.showOrdersByUser(user.getUserId());
		}else{
			orders = null;
		}
	
		return SUCCESS;
	}
	
	public String showShopOrders(){
		orders = null;
		ActionContext at  = ActionContext.getContext();
		Member member = (Member) at.getSession().get("shop");
		if(member != null){
			orders = orderManagerService.showOrdersByShop(member.getMemberId());
		}else{
			orders = null;
		}
		
		return SUCCESS;
	}

	public OrderManagerService getOrderManagerService() {
		return orderManagerService;
	}

	public void setOrderManagerService(OrderManagerService orderManagerService) {
		this.orderManagerService = orderManagerService;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCore() {
		return core;
	}

	public void setCore(String core) {
		this.core = core;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Boolean getIsComment() {
		return isComment;
	}

	public void setIsComment(Boolean isComment) {
		this.isComment = isComment;
	}
}
