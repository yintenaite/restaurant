<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

	
	<div class="aa"style="margin-bottom:16px;margin-left:20px;margin-right:18px;">
	
	
		<div class="row cannot_select" style=""> <!-- 第三行 -->
			
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
							<button type="button" class="btn btn-info" style="width:75px;height:70px;padding-left:10px;padding-top:10px">收藏</button>
							</div>
						
					</div>
				</div>			
		</div>
		<div class="row cannot_select" > <!-- 标题 -->
			<div class="col-md-12"  style="padding-top:0px;margin-bottom:-15px;">
				<dl class="good-tittle">
					<dt>${productdetail.productName}</dt>
					<dd>${productdetail.productSubtitle}</dd>
				</dl>
			</div>
		</div>

		<div class="row cannot_select"> <!-- 图片 -->
			<div class="col-md-6"  style="width:510px;">
				<img src="${productdetail.productImgUrl}" style="width:460px;height:280px"class="img-thumbnail">
			</div>
			<div class="col-md-6">			
			<div class="good-prize-content">
			<span>仅售&nbsp;&nbsp;&nbsp;&nbsp;<span class="good-prize">&yen;${productdetail.productCurrentPrize}</span><span class="good-describe-font">&nbsp;&nbsp;&nbsp;&nbsp;门店价&nbsp;<del>&yen;${productdetail.productOriginalPrize}</del></span></span>
			</div>
			<div class="good-describe-font">
				<span class="vertical-line text-center count">已售<span><a href="#"  class="font-orange">1700</a></span></span> 
				<span class="vertical-line text-center count"><span><a href="#"  class="font-orange">4.5</a></span>分</span>  
				<span class="text-center count"><span><a href="#"  class="font-orange">100</a></span>人评价</span> 
			</div>
			<div class="good-describe-font buy-num">
				数量：&nbsp;1份
			</div>
			<div class="buy-operation">
				<button type="button" class="btn btn-info" productdetailid="${productdetail.member.memberId}" buytocart style="width:90px;height:40px;">购买</button>
				<button type="button" class="btn btn-info" style="margin-left:350px;width:40px;height:40px;padding-left:5px;">收藏</button>
			</div>			
			</div>
		</div>

		<div class="row cannot_select  comment"> <!-- 评价 -->
		<div class="col-md-12">
			<div class="comment-tittle">
				<h4>用户评价</h4>
			</div>
		</div>
		<div class="col-md-12">
			<ul>
				<s:iterator value="comments" var="comment">
					<li class="comment-content">
					<div class="clearfix" style="color: #898989;height: 15px;line-height: 15px;vertical-align: top;">
					<span class="fr" style="margin-right: 15px;color:#898989;height: 15px;line-height: 15px;vertical-align: top;">评价时间  ${comment.commentDate}</span>
					<span style="color: #898989;;font-size: 14px;margin-right: 15px;padding: 0 15px;">${comment.user.userNickName }</span>
					<span>总体评价：</span>
					<span class="star black-star">
						<span class="star-score" style="width: {{${comment.commentCore}*14.4}}px"></span>
					</span>
					<span style="margin-left: 10px;">${comment.commentCore}分</span>
					</div>
					<div class="user-reply">${comment.commentContent}</div>
					</li>
				</s:iterator>
			</ul>
		</div>
		</div>
		
	</div>
		</div>
	