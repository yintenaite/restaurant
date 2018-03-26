package com.restraurant.entity;

public class Product {
	private String productId;//商品id
	private String productName;//商品名字
	private String productSubtitle;//商品的副标题
	private float productOriginalPrize;//商品原价
	private float productCurrentPrize;//商品现价
	private int productSellNum;//销售量
	private float productCore;//评分
	private String productImgUrl;//商品主图片
	private Category category;//种类外键
	private Member member;//商家外键
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(String productId, String productName,
			String productSubtitle, float productOriginalPrize,
			float productCurrentPrize, int productSellNum,
			float productCore, String productImgUrl, Category category,
			Member member) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productSubtitle = productSubtitle;
		this.productOriginalPrize = productOriginalPrize;
		this.productCurrentPrize = productCurrentPrize;
		this.productSellNum = productSellNum;
		this.productCore = productCore;
		this.productImgUrl = productImgUrl;
		this.category = category;
		this.member = member;
	}

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductSubtitle() {
		return productSubtitle;
	}
	public void setProductSubtitle(String productSubtitle) {
		this.productSubtitle = productSubtitle;
	}
	public float getProductOriginalPrize() {
		return productOriginalPrize;
	}
	public void setProductOriginalPrize(float productOriginalPrize) {
		this.productOriginalPrize = productOriginalPrize;
	}
	public float getProductCurrentPrize() {
		return productCurrentPrize;
	}
	public void setProductCurrentPrize(float productCurrentPrize) {
		this.productCurrentPrize = productCurrentPrize;
	}
	public String getProductImgUrl() {
		return productImgUrl;
	}
	public void setProductImgUrl(String productImgUrl) {
		this.productImgUrl = productImgUrl;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}

	public int getProductSellNum() {
		return productSellNum;
	}

	public void setProductSellNum(int productSellNum) {
		this.productSellNum = productSellNum;
	}

	public float getProductCore() {
		return productCore;
	}

	public void setProductCore(float productCore) {
		this.productCore = productCore;
	}
	
	
}
