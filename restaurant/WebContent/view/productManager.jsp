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
								<th>商品名称</th>
								<th>现价</th>
								<th>原价</th>
								<th>销售量</th>
								<th>操作</th>
							</tr>
							</thead>
							<tbody>
							<s:iterator value="products" var="p">
								<tr>
									<td>${p.productName}</td>
									<td>￥${p.productCurrentPrize}</td>
									<td>￥${p.productOriginalPrize}</td>
									<td>${p.productSellNum}</td>
									<td>修改</td>
								</tr>
							</s:iterator>
							</tbody>
						</table></s:if>
					</div>