package com.restraurant.entity;

import java.io.Serializable;

public class FromPageCart implements Serializable{
	private String pageCartId;
	private String pageCartName;
	private String pageCartCount;
	private String pageCartPrice;
	
	public FromPageCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FromPageCart(String pageCartId, String pageCartName,
			String pageCartCount, String pageCartPrice) {
		super();
		this.pageCartId = pageCartId;
		this.pageCartName = pageCartName;
		this.pageCartCount = pageCartCount;
		this.pageCartPrice = pageCartPrice;
	}
	public String getPageCartId() {
		return pageCartId;
	}
	public void setPageCartId(String pageCartId) {
		this.pageCartId = pageCartId;
	}
	public String getPageCartName() {
		return pageCartName;
	}
	public void setPageCartName(String pageCartName) {
		this.pageCartName = pageCartName;
	}
	public String getPageCartCount() {
		return pageCartCount;
	}
	public void setPageCartCount(String pageCartCount) {
		this.pageCartCount = pageCartCount;
	}
	public String getPageCartPrice() {
		return pageCartPrice;
	}
	public void setPageCartPrice(String pageCartPrice) {
		this.pageCartPrice = pageCartPrice;
	}
	
	
}
