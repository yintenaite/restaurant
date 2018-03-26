<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <div style="width:400px;" class="center-block" ng-controller="shopLoginCtrl">
  	<form ng-submit="shoplogin(shop)" method="post" name="shoploginform">
    <div class="">
      <div class="modal-header text-center">
        <h4 class="modal-title" id="modal-login-dialog">商店登陆</h4>
      </div>
      <div class="modal-body">
        <!-- 主体 -->
		<div class="row form-group">
			<div class="col-sm-8 col-sm-offset-2">
				<!-- <span class="input-group-addon glyphicon glyphicon-user ico-to-top"></span> -->
				<input type="tel" id="login-phone" class="form-control input-sm" placeholder="用户名/手机号" ng-model="shop.phone" required>
			</div>
		</div>
		<div class="row form-group" >
			<div class="col-sm-8  col-sm-offset-2">
				<!-- <span class="input-group-addon glyphicon glyphicon-user"></span> -->
				<input type="password" id="login-phone" class="form-control input-sm" placeholder="密码" ng-model="shop.password" required>
			</div>
		</div>
        <!-- 主体结束-->
      </div>      
      <div class="modal-footer" style="text-align: center;">
    	<button type="submit" class="btn btn-info" style="width:150px;" ng-disabled="loginform.$invalid">登陆</button>
      </div>
    </div></form>
  </div>