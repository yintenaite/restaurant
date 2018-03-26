<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@ page contentType="text/html;charset=UTF-8" %> 
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

	<div class="aa"style="margin-bottom:16px;margin-left:20px;margin-right:18px;"   ng-controller="shoppingcart">
	
	
		<div class="row cannot_select" style="" > <!-- 第三行 -->
			
				<div class="col-md-12" style="background-color:#f5f5f5;margin-bottom:10px;border-radius: 4px;">
					<div class="col-md-6">
						<div>
							<div class="col-md-5" style="margin-right:0px;"><img src="${shop.shopImgUrl}" style="width:180px;height:130px"class="img-thumbnail"></div>
							<div  class="col-md-7" >
								<span><h3>${shop.shopName}</h3></span>
								<span class="star black-star" style="margin-bottom:10px;">
										<span class="star-score" style="width: 65px"></span>
								</span><br>
								<span>${shop.shopAdress}</span>
							</div>
						</div>
					</div>
					<div class="col-md-2" style="padding-left:0px;">
						<div style="margin-top:24px;">
							<span style="color: #f76120;font-size: 34px;font-weight: 900;">4.6</span>分<br>
							<span style="font-size:16px;font-weight: 550;">平均分</span>
						</div>
					</div>
					<div class="col-md-2">
						<div style="margin-top:24px;">
							<span style="color: #f76120;font-size: 34px;font-weight: 900;">700</span>份<br>
							<span style="font-size:16px;font-weight: 550;">已卖出</span>
						</div>
					</div>
					<div class="col-md-2" style="margin-top:22px;padding-left:30px;">
						<a href="#">
							<div style="background-color:#fa9700;border-radius: 4px; width:75px;height:70px;padding-left:10px;padding-top:10px">
							<h3 style="color:white;margin-top:8px">收藏</h3>
							</div>
						</a>
					</div>
				</div>			
		</div>
		<div class="row cannot_select" style=""> <!-- 第四行 -->
			<div class="col-md-10" style="padding-left:0px;background-color:#f5f5f5;width:880px;">
				<div style="width:880px;float:left;padding-left:45px;border-bottom: 2px solid #ebebeb">
				<h3 style="margin-bottom:10px;margin-top:10px;">菜单</h3>
				</div>
				<div style="padding-left:35px;">
					<ul class="list-unstyled list-inline fontsize14">
					<s:iterator value="products" var="product">
						<li><a href="#/detail/${product.productId}"><div style="padding:10px 10px 2px 10px;border: 2px solid #ebebeb;" class="good-hover-white"><img src="${product.productImgUrl}" style="width:150px;height:100px;margin-bottom:2px;"><dl><dt style="font-weight:500;font-size:17px;">${product.productName}</dt><dd style="margin-bottom:-5px;"><span style="color: #f76120;font-size:22px">&yen;${product.productCurrentPrize}<span style="float:right;margin-top:-4px;"><img src="images/addcart.png" style="wdith:24px;height:24px;" showgoodnum="${product.productId}" showgoodname="${product.productName}" showgoodprice="${product.productCurrentPrize}" shopid="${shop.memberId}" showgood></span></span></dd></dl></div></a></li>
					</s:iterator>
					</ul>
				</div>
			</div>
			<div class="col-md-2">
				<div style="">
					<div style="background-color:#fa9700;width:208px;height:29px;padding-left:10px;padding-top:3px;border-radius: 4px;"><h4 style="color:white;">店铺公告</h4></div>
					<div style="boder-left:4px;boder-right:4px;border-bottom:4px;border-top:none;border:solid #ebebeb;border-radius: 4px;width:208px;padding:4px 6px 4px 6px;">${shop.shopMessage}</div>
				</div>
				
			</div>
		</div>
		
	
		

<!-- 购物车 -->
<div class="cart"  style="background-color:#fafafa;border-left: 2px solid #fa9700;border-top: 2px solid #fa9700;border-right: 2px solid #fa9700;border-radius:4px;" ng-hide="cart.length == 0">  <!-- style="background-color:black; -->
	<div class="cart-top"><a href="" ng-click="carthide()">
		<h5 style="margin-top:1px;margin-left:3px;color:white;font-size:14px;"><img class="" style="margin-top:-30px;margin-left:5px;margin-right:10px;" src="images/cart_logo.png">购物车 <span style="float:right;padding-right:15px;font-size:12px;" ng-show="cartcontenthide">共<span style="margin: 0 3px;" ng-bind="totalnum()"></span>份，总计
			<span style="font-size:14px;font-weight: 700;" ng-bind="'¥'+total()"></span></span></h5></a>
	</div>
	<div style="padding-left:5px;" id="cart-content"  ng-hide="cartcontenthide">
	<div class="cart-tittle" style="background-color:#fafafa;">		
		<span class="fl dishes" style="width:164px;">菜品<a class="clear-cart" href="javascript:;" ng-click="cart=[]">[清空]</a>
		</span>
		<span>份数</span>
		<span style=" margin-left: 47px;white-space: nowrap;">价格</span>
	</div>
	<div class="cart-content">
		<ul style="height: auto; overflow: visible;padding-left:0px;">

			<li class="clearfix" style="padding-left:0px;" ng-repeat="item in cart">
			<div class="fl na clearfix" style="width:152px;">
			<div ng-bind="item.pageCartName"></div>
			</div>
			<div class="fl modify clearfix">
			<a class="fl minus" href="javascript:;" ng-click="down(item.pageCartId)">-</a>
			<input class="fl txt-count text-center" type="text" maxlength="2" ng-model="item.pageCartCount">
			<a class="fl plus" href="javascript:;" ng-click="up(item.pageCartId)">+</a>
			</div>
			<div class="fl pri">
			<span ng-bind="'￥'+singletotalprice(item.pageCartId)"></span>
			</div>
			</li>

			<!-- <li class="clearfix" style="padding-left:0px;">
			<div class="fl na clearfix" style="width:152px;">
			<div class="">排骨米饭双人套餐</div>
			</div>
			<div class="fl modify clearfix">
			<a class="fl minus" href="javascript:;">-</a>
			<input class="fl txt-count" type="text" maxlength="2" value="1 ">
			<a class="fl plus" href="javascript:;">+</a>
			</div>
			<div class="fl pri">
			<span>¥54</span>
			</div>
			</li>
			
			<li class="clearfix" style="padding-left:0px;">
			<div class="fl na clearfix" style="width:152px;">
			<div class="">排骨米饭双人套餐</div>
			</div>
			<div class="fl modify clearfix">
			<a class="fl" href="javascript:;">-</a>
			<input class="fl" type="text" maxlength="2" value="1 ">
			<a class="fl" href="javascript:;">+</a>
			</div>
			<div class="fl pri">
			<span>¥54</span>
			</div>
			</li> -->
		</ul>
		<div class="total">共<span style="color: #fe4d3d;margin: 0 3px;" ng-bind="totalnum()"></span>份，总计
			<span style="color: #fe4d3d;font-size:28px;font-weight: 700;" ng-bind="'¥'+total()"></span>
			<span style="float:right;margin-right:10px;margin-top:3px;"><button type="button" class="btn btn-info" style="width:70px;height:30px;" ng-click="gotoorder()">下单</button></span>
			</div>
		</div>
	</div>	
	<div class="cart-footer">
		
	</div>
	</div>
	</div>