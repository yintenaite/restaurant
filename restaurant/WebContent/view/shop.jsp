<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

	<div class="aa"style="margin-bottom:16px;margin-left:20px;margin-right:18px;">
	<!-- 下面是商店列表 -->
	
		<div class="row cannot_select" style=""> <!-- 第三行 -->
			
				<div class="col-md-12" style="background-color:#fa9700;margin-bottom:10px;border-radius: 4px;">
					<h3 style="margin-top:2px;margin-bottom:3px;color:#EEE;">卖家列表</h3>
				</div>			
		</div>
		<div class="row cannot_select" style=""> <!-- 第四行 -->
			
				<div class="col-md-10 aa">
					<ul class="list-unstyled list-inline fontsize14">
					<s:iterator value="shops" var="s">
						<li><a href="#/cart/${s.memberId}"><div><img src="${s.shopImgUrl}" style="width:180px;height:130px" class="img-rounded"><span><dl><dt>${s.shopName}</dt><dd>${s.shopAdress}</dd></dl></span></div></a></li>
					</s:iterator>
						<!-- <div class="good-line" style="width:830px;float:left;margin-bottom:20px;"></div> -->
						</ul>	
					</div>	
				<div class="col-md-2 aa" >	
				<h4 style="margin-top:5px;">推荐店铺</h4>
				<div class="tuijian-line"></div>
				<div>
					<ul class="list-unstyled list-inline fontsize14">
						<li class="good-hover"><a href="#"><div><img src="images/shop/12345.jpg" style="width:150px;height:100px"><span><dl style="margin-bottom:5px;"><dt>肯德基</dt><dd>人均消费50元</dd></dl></span><span class="star black-star"><span class="star-score" style="width: 65px"></span></span></a><div class="tuijian-line" style="border-top: 1px solid #dadada;"></div></li>
						<li class="good-hover"><a href="#"><div><img src="images/shop/12346.jpg" style="width:150px;height:100px"><span><dl style="margin-bottom:5px;"><dt>麦当劳</dt><dd>人均消费50元</dd></dl></span><span class="star black-star"><span class="star-score" style="width: 65px"></span></span></a><div class="tuijian-line" style="border-top: 1px solid #dadada;"></div></li>
									
						
						</ul>
				</div>		
					
				</div>
					
		</div>
		
	</div>
		</div>
	