package com.restraurant.service;

import java.util.List;

import com.restraurant.dao.PayDao;
import com.restraurant.entity.Order;

public class PayService {
	private PayDao payDao;

	public void pay(List<Order> orders){
		payDao.pay(orders);
	}
	public PayDao getPayDao() {
		return payDao;
	}

	public void setPayDao(PayDao payDao) {
		this.payDao = payDao;
	}
	
	
}
