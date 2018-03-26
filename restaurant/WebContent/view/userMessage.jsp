<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

					<div> <s:if test="#session.user != null">
						<table class="table" style="margin-top:10px;width:500px;">							
							<tbody>
								<tr>
									<td>用户名：</td>
									<td>${session.user.userNickName}</td>
								</tr>
								<tr>
									<td>真实姓名：</td>
									<td>${session.user.userTrueName}</td>
								</tr>
								<tr>
									<td>手机：</td>
									<td>${session.user.userPhone}</td>
								</tr>
								<tr>
									<td>注册时间：</td>
									<td>${session.user.userCreateTime}</td>
								</tr>
								<tr>
									<td></td>
									<td>
										<button type="button" class="btn btn-info" style="width:150px;float:right;">修改</button>
									</td>
								</tr>
							</tbody>
						</table></s:if>
					</div>