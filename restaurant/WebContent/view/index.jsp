<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@ page contentType="text/html;charset=UTF-8" %> 
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Examples</title>
<meta name="description" content="">
<meta name="keywords" content="">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="bootstrap/jquery.min.js"></script>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/good.css">
<link rel="stylesheet" href="css/user.css">
<style>
	body {
    font: 12px/1.4 Microsoft Yahei,Arial,Helvetica,sans-serif;
    background-image: url("images/bg_5.png");    
}
.aa{
		background-color: white;
}
</style>
</head>
<body ng-app="index"> 
<div class="container" style="padding:0px 27px 0px 27px">
	
	<div class="row" ng-controller="sessionctrl"> <!-- 第一行 -->
		<div class="col-md-2 col-md-offset-10"><h5>
		 <s:if test=" #session.user==null">
		 <a href="#"data-toggle="modal" data-target="#modal-register">注册</a> <a>|</a> <a href="#" data-toggle="modal" data-target="#modal-login">登陆</a>
		 </s:if>  
		 <s:else>
		 <a href="#/myMessage">${session.user.userPhone } </a> <a>|</a> <a href="#" ng-click="logout()">注销</a>
		 </s:else>
			</h5></div>
	</div>
	<div class="row  navber-default navbar aa" style="margin-top:0px;margin-bottom:16px"><!-- 第二行 -->
		<div class="col-md-3 navbar-header "><h2 style="margin-bottom:15px;margin-top: 15px;margin-left:15px;"><a href="#" class="nav-brand">想吃</a></h2></div>
		<div class="col-md-5" style="margin-top:0.9%">
			<ul class="nav nav-pills" style="margin-top:4px">			
				<li><a href="#/"><h4>首页</h4></a></li>
				<li><a href="#/allgoods"><h4>全部商品</h4></a></li>
				<li><a href="#/allshop"><h4>所有卖家</h4></a></li>
				<li><a href="#"><h4>积分兑换</h4></a></li>
			</ul>
		</div>
		<div class="col-md-3" style="margin-top:1.5%;padding-right:0%">
		<form action="{{tosearch+search}}" method="get" ng-controller="searchform">
			<div class="input-group" style="center-block">
                        <input type="text" ng-model="search" class="form-control" placeholder="搜你想要的">
                        <span class="input-group-btn">
                            <button class="btn btn-info" type="submit"><span class="glyphicon glyphicon-search">&nbsp;搜索</span></button>
                        </span>
            </div>
            </form>
		</div>
		<div class="col-md-1 collapse navbar-collapse" style="width:95px"><a href="#">
			<div class="thumbnail qrshow" style="margin-top:20%;margin-bottom:-20%;position:relative">
				<img src="images/small-qr.png" style="width: 30px; height: 30px;">
				<div class="qrhidden" id="qrimage" style="position:absolute;top:165%;right:-6%;z-index:1">
					<img src="images/qr.png" alt="" style="width:96px;height:96px">
				</div>
			</div></a>
		</div>		
	</div>	
	<div ui-view="content"></div>
</div>

<div class="footer">
	<div class="copyright">
	©2016 google.cn<a href="#" target="_blank">京ICP证20160828号</a>京公网安备201602281708号
	</div>
</div>
<!-- 注册框 开始-->
<div class="modal " id="modal-register" tabindex="-1" role="dialog" aria-labelledby="modal-register-dialog" ng-controller="register">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="modal-register-dialog">注册</h4>
      </div>
      <form method="post" class="form-horizonal"  name="registerform" ng-submit="userregister(user)">
      <div class="modal-body">
        <!-- 注册主体 -->		
			<div class="form-group row">
				<label for="register-phone" class="col-sm-2 text-right" style="margin-top:1%;">注册手机</label>
				<div class="col-sm-5">
					<input type="tel"  required ng-pattern="/^1[3|4|5|7|8]\d{9}$/" name="registerphone" id="register-phone" ng-model="user.phone" class="form-control input-sm">
				</div>
				<div class="col-sm-5 input-tip font-red" ng-show="registerform.registerphone.$dirty && registerform.registerphone.$invalid
				"><label class="control-label">*请输入11位手机号</label></div>
			</div>
			<div class="form-group row">
				<label for="register-password" class="text-right col-sm-2" style="margin-top:1%;" >创建密码</label>
				<div class="col-sm-5">
					<input type="password" required id="register-password" ng-pattern="/^[^\s]{6,16}$/" ng-minlength="6" ng-maxlength="16" name="registerpassword"  ng-model="user.password" class="form-control  input-sm">
				</div>
				<div class="col-sm-5 font-red input-tip"ng-show="registerform.registerpassword.$dirty&&registerform.registerpassword.$invalid"><label class="control-label"><label  class="control-label">*至少6位并不包含空格</label></div>
			</div>
			<div class="form-group  row">
				<label for="check-password" class="text-right col-sm-2" ng-model="checkpassword"  style="margin-top:1%;">确认密码</label>
				<div class="col-sm-5">
					<input type="password" required class="form-control  input-sm" name="checkpassword" id="check-password" ng-model="checkpwd">
				</div>
				<div class="col-sm-5 font-red input-tip" ng-show="registerform.checkpassword.$dirty&&checkpassword()"><label  class="control-label">*与第一次密码输入一致</label></div>
			</div>
		
        <!-- 注册主体结束-->
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="submit" ng-disabled="registerform.$invalid || checkpassword()" class="btn btn-info">注册</button>
      </div>
      </form>
    </div>
  </div>
</div>
<!-- 注册框 结束-->
<!-- 登录框 开始 -->
<div class="modal " id="modal-login" tabindex="-1" role="dialog" aria-labelledby="modal-login-dialog" ng-controller="login">
  <div class="modal-dialog" role="document" style="width:400px">
  	<form ng-submit="userlogin(user)" method="post" name="loginform">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="modal-login-dialog">用户登陆</h4>
      </div>
      <div class="modal-body">
        <!-- 主体 -->
        <div class="row" style="margin-bottom:5px;">
			<div class="col-sm-8 col-sm-offset-2" ng-hide="loginresule">
			<span style="color:#a94442;font-size:10px;">*用户名或密码错误</span>
			</div>
		</div>

		<div class="row form-group">
			<div class="col-sm-8 col-sm-offset-2">
				<!-- <span class="input-group-addon glyphicon glyphicon-user ico-to-top"></span> -->
				<input type="tel" id="login-phone" class="form-control input-sm" placeholder="用户名/手机号" ng-model="user.phone" required>
			</div>
		</div>
		<div class="row form-group" >
			<div class="col-sm-8  col-sm-offset-2">
				<!-- <span class="input-group-addon glyphicon glyphicon-user"></span> -->
				<input type="password" id="login-phone" class="form-control input-sm" placeholder="密码" ng-model="user.password" required>
			</div>
		</div>
        <!-- 主体结束-->
      </div>      
      <div class="modal-footer" style="text-align: center;">
    	<button type="submit" class="btn btn-info" style="width:150px;" ng-disabled="loginform.$invalid">登陆</button> <div style="display:inline-block;margin-left:10px;"><a href="#/shopLogin" ng-click="gotoshop()">  商家入口  </a></div>
      </div>
    </div></form>
  </div>
</div>

<!-- 登录框 结束 -->
</body>
<script src="bootstrap/js/angular.min.js"></script>
<script src="bootstrap/js/angular-ui-router.js"></script>
<script src="bootstrap/js/ng-file-upload.min.js"></script>
<script src="bootstrap/js/ng-file-upload-shim.min.js"></script>
<script src="bootstrap/js/index.js"></script>
<script src="bootstrap/js/cart.js"></script>
</html>