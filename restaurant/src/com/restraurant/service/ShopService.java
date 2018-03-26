package com.restraurant.service;

import com.restraurant.dao.ShopDao;
import com.restraurant.entity.Member;

public class ShopService {
	private ShopDao shopDao;
	
	public Member shopLogin(String userPhone,String userPassword){
		Member m = shopDao.shopLogin(userPhone,userPassword);
		m.setMemberPassword("");
		return m;
	}
	public Member getShopByProduct(Member shop){
		
		return shopDao.getShopByProduct(shop.getMemberId());
	}
	public Member showShop(String shopId){
		return shopDao.showShop(shopId);
	}
	public void shopRegister(Member member){
		shopDao.shopRegister(member);
	}
	public ShopDao getShopDao() {
		return shopDao;
	}

	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}

	
}
