package com.restraurant.service;

import java.util.List;

import com.restraurant.dao.ProductDao;
import com.restraurant.entity.Area;
import com.restraurant.entity.Category;
import com.restraurant.entity.Member;
import com.restraurant.entity.Product;

public class ProductService {

	private ProductDao productDao;

	public List<Product> showAllProducts(){
		return productDao.getAllProducts();
	}
	public Product showProduct(String productId){
		return productDao.getProduct(productId);
	}
	public List<Category> getAllCategary(){
		return productDao.getAllcategary();
	}
	public List<Area> getAllArea(){
		return productDao.getAllArea();
	}
	public List<Product> showAllProducts(String type,Integer id){
		return productDao.showAllProductsByKind(type,id);
	}
	public List<Product> showAllProducts(String type,String id){
		return productDao.showAllProductsByKind(type,id);
	}
	public List<Product> showAProductsBySearch(String param){
		return productDao.showAProductsBySearch(param);
	}
	public List<Member> showAllShop(){
		return productDao.showAllShop();
	}
	public Member showShop (String shopId){
		return productDao.showShop(shopId);
	}
	public List<Product> showProductsByShop(String shopId){
		return productDao.showProductsByShop(shopId);
	}
	public List<Product> showAProductsByShopId(String shopId){
		return productDao.showAProductsByShopId(shopId);
	}
	public List<Product> showProductsByOrder(String orderType){
		return productDao.showProductsByOrder(orderType);
	}
/*
 * ===========================Getter  Setter mothod=====================================
 */
	public ProductDao getProductDao() {
		return productDao;
	}



	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
}
