<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div> <s:if test="#session.shop != null">
						<table class="table table-hover">
							<thead>
							<tr>
								<th>订单名称</th>
								<th>购买人</th>
								<th>数量</th>
								<th>总价</th>
								<th>评价</th>
							</tr>
							</thead>
							<tbody>
							<s:iterator value="orders" var="o">
								<tr>
									<td><a href="#/myshop/showShopOrder/${o.orderNum}">${o.productName}等...</a></td>
									<td>${o.user.userNickName}</td>
									<td>1份</td>
									<td>￥${o.orderPrice}</td>
									<td><s:if test="#o.orderIsComment == true">已评价</s:if><s:else>未评价</s:else> </td>
								</tr>
							</s:iterator>
							</tbody>
						</table></s:if>
					</div>