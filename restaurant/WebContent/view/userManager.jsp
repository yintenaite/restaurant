<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="aa"style="margin-bottom:16px;margin-left:20px;margin-right:18px;margin-top:40px;">
	 <div class="row cannot_select" style="">
				<div class="col-md-2 navber-default navbar">
					<ul class="nav nav-pills nav-stacked navul">
						<li><a href="#/myMessage/userMessage"><h5>我的信息</h5></a></li>
						<li><a href="#/myMessage/userOrder"><h5>我的订单</h5></a></li>
						<li><a href="#/myMessage/userOrder"><h5>我的评价</h5></a></li>
						<li><a href="#/myMessage/userOrder"><h5>我的收藏</h5></a></li>
					</ul>
				</div>					
				<div class="col-md-10">
					<div ui-view="manager"></div>
				</div>	
	</div>
	</div>