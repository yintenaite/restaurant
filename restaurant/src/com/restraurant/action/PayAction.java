package com.restraurant.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.restraurant.entity.FromPageCart;
import com.restraurant.entity.Order;
import com.restraurant.entity.User;
import com.restraurant.service.PayService;
import com.restraurant.util.DateUtil;
import com.restraurant.util.UuidUtil;

public class PayAction extends ActionSupport{
	
	private PayService payService;
	private String cart;
	private String shopId;
	
	public String pay() throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();  
			String cartparam = new String(cart.getBytes("ISO8859-1"),"utf-8");
			FromPageCart[] cart = mapper.readValue(cartparam, FromPageCart[].class);
			List<Order> orders = new ArrayList<Order>();
			String uuid = UuidUtil.getUUID();
			ActionContext at  = ActionContext.getContext();
			User u = (User) at.getSession().get("user");
			Float price = new Float(0);
			if(u != null){
				for(int i=0;i<cart.length;i++){
					orders.add(new Order(uuid, new Float(0), false, DateUtil.getStringDate(), cart[i].getPageCartId(), cart[i].getPageCartName(),shopId,u));
					orders.get(i).setProductCount(Integer.parseInt(cart[i].getPageCartCount()));
					orders.get(i).setProductName(cart[i].getPageCartName());
					orders.get(i).setProductPrice(Float.parseFloat(cart[i].getPageCartPrice()));
					price += Integer.parseInt(cart[i].getPageCartCount())*Float.parseFloat(cart[i].getPageCartPrice());
				}
			}else{
				for(int i=0;i<cart.length;i++){
					orders.add(new Order(uuid, new Float(0), false, DateUtil.getStringDate(), cart[i].getPageCartId(),cart[i].getPageCartName(),shopId));
					orders.get(i).setProductCount(Integer.parseInt(cart[i].getPageCartCount()));
					orders.get(i).setProductName(cart[i].getPageCartName());
					orders.get(i).setProductPrice(Float.parseFloat(cart[i].getPageCartPrice()));
					price += Integer.parseInt(cart[i].getPageCartCount())*Float.parseFloat(cart[i].getPageCartPrice());
				}
			}
			for(int i=0;i<orders.size();i++){
				orders.get(i).setOrderPrice(price);
			}
			payService.pay(orders);
		
		return SUCCESS;
	}
	
	public PayService getPayService() {
		return payService;
	}

	public void setPayService(PayService payService) {
		this.payService = payService;
	}

	public String getCart() {
		return cart;
	}

	public void setCart(String cart) {
		this.cart = cart;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

}
