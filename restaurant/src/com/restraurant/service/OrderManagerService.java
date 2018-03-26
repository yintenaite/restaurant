package com.restraurant.service;

import java.util.List;

import com.restraurant.dao.OrderManagerDao;
import com.restraurant.entity.Comment;
import com.restraurant.entity.Order;
import com.restraurant.entity.Product;

public class OrderManagerService {
	private OrderManagerDao orderManagerDao;
	
	public void submitComment(Comment comment,String orderId){
		orderManagerDao.submitComment(comment,orderId);
	}
	public List<Order> showOrdersByUser(String userId){
		return orderManagerDao.showOrdersByUser(userId);
	}
	public List<Order> showOrdersByOrderNum(String orderNum){
		return orderManagerDao.showOrdersByOrderNum(orderNum);
	}
	public List<Order> showOrdersByShop(String shopId){
		return orderManagerDao.showOrdersByShop(shopId);
	}

	public OrderManagerDao getOrderManagerDao() {
		return orderManagerDao;
	}

	public void setOrderManagerDao(OrderManagerDao orderManagerDao) {
		this.orderManagerDao = orderManagerDao;
	}
	
	
}
