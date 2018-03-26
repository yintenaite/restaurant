package com.restraurant.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.restraurant.entity.Member;
import com.restraurant.service.ShopService;

public class ShopAction extends ActionSupport{
	
	private ShopService shopService;
	private Member shop;
	private String shopPhone;
	private String shopPassword;
	private String shopLoginState;
	
	public String shopLogin(){
		shopLoginState="";
		Member m = shopService.shopLogin(shopPhone,shopPassword);
		if(m != null){
			ActionContext at  = ActionContext.getContext();
			at.getSession().put("shop", m);
			shopLoginState = "success";
		}else{
			shopLoginState = "error";
		}
		return SUCCESS;
	}
	public String showShop(){
		shop = null;
		ActionContext at  = ActionContext.getContext();
		Member m = (Member) at.getSession().get("shop");
		if(m!= null){
			shop = shopService.showShop(m.getMemberId());
		}
		
		return SUCCESS;
	}

	public ShopService getShopService() {
		return shopService;
	}

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}

	public Member getShop() {
		return shop;
	}

	public void setShop(Member shop) {
		this.shop = shop;
	}

	public String getShopPhone() {
		return shopPhone;
	}
	public void setShopPhone(String shopPhone) {
		this.shopPhone = shopPhone;
	}
	public String getShopPassword() {
		return shopPassword;
	}
	public void setShopPassword(String shopPassword) {
		this.shopPassword = shopPassword;
	}
	public String getShopLoginState() {
		return shopLoginState;
	}
	public void setShopLoginState(String shopLoginState) {
		this.shopLoginState = shopLoginState;
	}
	
}
