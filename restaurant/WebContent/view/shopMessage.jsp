<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

					<div> <s:if test="#session.shop != null">
					<div class="col-md-6">
						<table class="table" style="margin-top:10px;width:500px;">							
							<tbody>
								<tr>
									<td>商店名：</td>
									<td>${session.shop.shopName}</td>
								</tr>
								<tr>
									<td>地址：</td>
									<td>${session.shop.shopAdress}</td>
								</tr>
								<tr>
									<td>公告：</td>
									<td>${session.shop.shopMessage}</td>
								</tr>
								<tr>
									<td>负责人：</td>
									<td>${session.shop.memberName}</td>
								</tr>
								<tr>
									<td>负责人电话：</td>
									<td>${session.shop.memberPhone}</td>
								</tr>
								<tr>
									<td></td>
									<td>
									</td>
								</tr>
							</tbody>
						</table>
						</div>
						<div class="col-md-6"><img  src="${session.shop.shopImgUrl}" style="width:180px;height:130px;margin-left:70px;margin-top:10px;"class="img-thumbnail">
						<br><button type="button" class="btn btn-info" style="width:180px;margin-left:70px;margin-top:7px;">修改</button>
						</div>
						</s:if>
					</div>