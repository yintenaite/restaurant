<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	<s:iterator value="products" var="product">
			<div class="col-md-3 aa ">
					
						<div class="good-hover"style="padding-top:20px;margin-top:10px;margin-bottom:10px"> 
							<a href="#/detail/${product.productId}">
							<div class="preview center-block"> <!-- 图片 208 156-->
								<img src="${product.productImgUrl}" style="width: 228px; height: 171px;" class="img-rounded">
							</div>
							<div class="content center-block">
								<dl style="margin-bottom:10px">
								<div class="name">
									<span> <dt class="good-tittle"><s:property value="#product.productName"/></dt></span>
								</div>
								<div class="describe">
									<dd class="describe-font"><s:property value="#product.productSubtitle"/></dd>
								</div>
								</dl>
								<div class="rank">
									<span class="star black-star">
										<span class="star-score" style="width: {{${product.productCore}*14.4}}px"></span>
									</span>
									<span class="describe-font">${product.productCore}分</span>
									<span class="fr" style="color: #fa9700;">已售${product.productSellNum}单</span>
								</div>
								<div class="prize">
									<span><span class="sell-prize" style="color: #f76120;">&yen;<s:property value="#product.productCurrentPrize"/></span><span class="describe-font">&nbsp;门店价&nbsp;<del>&yen;<s:property value="#product.productOriginalPrize"/></del></span></span>
								</div>
							</div>
							</a>
						</div>
						
			</div>
			</s:iterator>
			
			