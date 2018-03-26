package com.restraurant.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.restraurant.entity.Area;
import com.restraurant.entity.Category;
import com.restraurant.entity.Comment;
import com.restraurant.entity.Member;
import com.restraurant.entity.Product;
import com.restraurant.service.CommentService;
import com.restraurant.service.ProductService;
import com.restraurant.service.ShopService;

public class ProductAction extends ActionSupport{

	private ProductService productService;
	private ShopService shopService;
	private CommentService commentService;
	private List<Product> products;//获取所有商品
	private List<Category> categorys;//商品种类
	private List<Area> areas;//商品区域
	private String productId;//获取单个商品需要的id
	private String jsonProduct;//获取单个商品的json数据
	private Product productdetail;//单个商品详细信息
	private Member shop;//获取商店信息
	private Integer categoryId;
	private Integer areaId;
	private String searchParam;
	private List<Member> shops=null;
	private String shopId;
	private String orderType;
	private List<Comment> comments;
	private String addProductState;
	private Product product;
	
	
	/*private File upload ;
	private String uploadFileName;
	private String uploadContentType;
	//test======================================
	public String upload(){
		String realPath = ServletActionContext.getServletContext().getRealPath("view11/images/aa");
		File path = new File(realPath);
		if(!path.exists()){
			path.mkdirs();
		}
		try {
			FileInputStream is = new FileInputStream(upload);
			FileOutputStream os = new FileOutputStream(realPath+"/"+uploadFileName);
			byte buffer[] = new byte[1024];
			int count = 0;
			while((count = is.read(buffer))>0){
				os.write(buffer,0,count);
			}
			os.close();is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
	}*/
	public String addProduct(){
		@SuppressWarnings("unused")
		Enumeration<String> o = ServletActionContext.getRequest().getParameterNames();
		addProductState = "";
		System.out.println("asdasd");
		addProductState = "success";
		return SUCCESS;
	}
	
	/** 
	 * 显示所有的商品
	 * @return String
	 */
	public String showAllProducts(){
		products = null;
		products = productService.showAllProducts();
		return SUCCESS;
	}
	public String showAllkind(){
		categorys = productService.getAllCategary();
		areas = productService.getAllArea();
		return SUCCESS;
	}
	
	public String showCategorytoAddProduct(){
		categorys = productService.getAllCategary();
		return SUCCESS;
	}
	public String showProductsByShop(){
		ActionContext at  = ActionContext.getContext();
		Member m = (Member) at.getSession().get("shop");
		products = null;
		if(m!= null){
			products = productService.showAllProducts("shopId",m.getMemberId());
		}
		
		return SUCCESS;
	}
	public String showAProductsBycategory(){
		products = null;
		products = productService.showAllProducts("category",categoryId);
		return SUCCESS;
	}
	public String showAProductsByArea(){
		products = null;
		products = productService.showAllProducts("area",areaId);
		return SUCCESS;
	}
	public String showAProductsByShopId(){
		products = null;
		products = productService.showAProductsByShopId(shopId);
		return SUCCESS;
	}
	public String showAProductsBySearch(){
		products = null;
		try {
		String param = new String(searchParam.getBytes("ISO8859-1"),"utf-8");
		products = productService.showAProductsBySearch(param);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String showAllShop(){
		shops.clear();
		shops = productService.showAllShop();
		return SUCCESS;
	}
	public String showCart(){
		shop = null;
		products = null;
		shop = productService.showShop(shopId);
		products = productService.showProductsByShop(shop.getMemberId());
		shops.clear();
		return SUCCESS;
	}
	public String showProductsByOrder(){
		products = null;
		products = productService.showProductsByOrder(orderType);
		return SUCCESS;
	}
	/**
	 * 获取单个物品
	 * @return String
	 */
	public String showProduct(){
		if(productId != ""){
			productdetail = productService.showProduct(productId);
			if(productdetail != null){/*jsonProduct = new ObjectMapper().wrteValueAsString(product);*/
				shop = shopService.getShopByProduct(productdetail.getMember());
				comments = commentService.showCommentByProductId(productId);
				return SUCCESS;
				}else{
				return ERROR;
			}
		}
		else{
			return ERROR;
		}
	}
/*
 * ===========================Getter  Setter mothod=====================================
 */
	
	public ProductService getProductService() {
		return productService;
	}

	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public List<Member> getShops() {
		return shops;
	}
	public void setShops(List<Member> shops) {
		this.shops = shops;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getJsonProduct() {
		return jsonProduct;
	}

	public void setJsonProduct(String jsonProduct) {
		this.jsonProduct = jsonProduct;
	}

	public Product getProductdetail() {
		return productdetail;
	}

	public void setProductdetail(Product productdetail) {
		this.productdetail = productdetail;
	}

	public Member getShop() {
		return shop;
	}

	public void setShop(Member shop) {
		this.shop = shop;
	}

	public ShopService getShopService() {
		return shopService;
	}

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}

	public List<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}

	public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public String getSearchParam() {
		return searchParam;
	}
	public void setSearchParam(String searchParam) {
		this.searchParam = searchParam;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public CommentService getCommentService() {
		return commentService;
	}
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	public String getAddProductState() {
		return addProductState;
	}
	public void setAddProductState(String addProductState) {
		this.addProductState = addProductState;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
/*	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
*/
}
