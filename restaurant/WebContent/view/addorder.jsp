<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="aa"style="margin-bottom:16px;margin-left:20px;margin-right:18px;" ng-controller="addorderctrl">
	
		<div class="row cannot_select" style="" > <!-- 第三行 -->
		<table class="order" style="text-align: center;width: 100%;">
			<tr>
			<th style="text-align: left;">项目</th>
			<th class="unit-price">单价</th>
			<th class="amount">数量</th>
			<th class="col-total">总价</th>
			</tr>

			<tr class="trline" ng-repeat="item in cart">
				<td style="text-align: left;padding-left:10px;">
				{{item.pageCartName}}
				</td>
				<td>¥<span>{{item.pageCartPrice}}</span></td>
				<td >{{item.pageCartCount}}份</td>
				<td ><span class="fonttored">¥{{item.pageCartPrice*item.pageCartCount}}</span>	</td>
			</tr>	

			<tr class="trline">
			<td></td>
			<td class="extra-fee total-fee rightpadding" style="text-align: right;padding-right:45px;" colspan="3">
			<strong>应付金额</strong>
			：
			<span class="inline-block money">
			
			<strong  class="fonttored" ng-bind="'￥'+totalorder()"></strong>
			</span>
			</td>
			</tr>

			<tr>
				<td></td>
				<td class="extra-fee total-fee rightpadding" style="text-align: right;padding-right:45px;" colspan="3">
				<button type="submit" class="btn btn-info" style="width:150px;" ng-click="payaction()">支付</button>
    
				</td>
			</tr>
			</table>
		</div>
	</div>