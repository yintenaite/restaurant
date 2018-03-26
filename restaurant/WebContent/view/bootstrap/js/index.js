var indexapp = angular.module('index', ['ui.router','ngFileUpload']);
indexapp.config(function($stateProvider, $urlRouterProvider){
	 $urlRouterProvider.otherwise("/allgoods");
	 $stateProvider
	 .state('myshop', {
     	 url: "/myshop",
     	 views:{
     		 'content':{
     			templateUrl: "shopManager.jsp"
     		 },
   	 		'shopManager@myshop':{
   	 			templateUrl:"showShopOrders"
   	 		}
     	 }
   	 })
   	 .state('myshop.showShoprOrder', {
     	 url: "/showShopOrder/:ordernum",
     	 views:{
   	 		'shopManager@myshop':{
   	 			templateUrl:function($routeParams) {return "showShopOrderByOrderNum?orderNum="+$routeParams.ordernum}
   	 			/*"showUserOrder.jsp"*/
   	 		}
     	 }
   	 })
   	 .state('myshop.shopMessage', {
   		 url: "/shopMessage",
   		 views:{
   			 'shopManager@myshop':{
   				 templateUrl:"shopMessage.jsp"
   			 }
   		 }
   	 })
   	 .state('myshop.productManager', {
   		 url: "/productManager",
   		 views:{
   			 'shopManager@myshop':{
   				 templateUrl:"showProductsByShop"
   			 }
   		 }
   	 })
   	 .state('myshop.addProduct', {
   		 url: "/addProduct",
   		 views:{
   			 'shopManager@myshop':{
   				 templateUrl:"showCategorytoAddProduct"
   			 }
   		 }
   	 })
	 .state('shopLogin', {
     	 url: "/shopLogin",
     	 views:{
     		 'content':{
     			templateUrl: "shopLogin.jsp"
   	 		}
     	 }
   	 })
   	 .state('allgoods', {
     	 url: "/allgoods",
     	 views:{
     		 'content':{
     			templateUrl: "showAllkind"
     		 },
   	 		'showgoods@allgoods':{
   	 			templateUrl:"showAllProducts"
   	 		}
     	 }
   	 })
   	 .state('addorder', {
     	 url: "/addorder",
     	 views:{
     		 'content':{
     			templateUrl: "addorder.jsp",
     		 }
     	 }
   	 })
   	 .state('allshop', { /*这个就是起的名字 随便起*/
     	 url: "/allshop", /*这个就是那个url*/
     	 views:{
     		 'content':{ /*这个就是指定的view*/
     			templateUrl: "showAllShop" /*这个就是连接的页面*/
     		 }
     	 }
   	 })
   	 .state('cart', {
     	 url: "/cart/:id",
     	 views:{
     		 'content':{
     			templateUrl:function($routeParams) {return "showCart?shopId="+$routeParams.id}
     		 }
     	 }
   	 })
   	  .state('detail', {
     	 url: "/detail/:productid",
     	 views:{
     		 'content':{
     			templateUrl: function($routeParams) {return "showProduct?productId="+$routeParams.productid}
     		 }
     	 }
   	 })
   	 .state('allgoods.categroy', {
     	 url: "/category/:categoryid",
     	 views:{
     		 'showgoods@allgoods':{
     			templateUrl:function($routeParams) {return "showAProductsBycategory?categoryId="+$routeParams.categoryid}
     		 }
     	 }
   	 }) 
   	 .state('allgoods.order', {
     	 url: "/order/:ordertype",
     	 views:{
     		 'showgoods@allgoods':{
     			templateUrl:function($routeParams) {return "showProductsByOrder?orderType="+$routeParams.ordertype}
     		 }
     	 }
   	 }) 
   	.state('allgoods.area', {
    	 url: "/area/:areaid",
    	 views:{
    		 'showgoods@allgoods':{
    			templateUrl:function($routeParams) {return "showAProductsByArea?areaId="+$routeParams.areaid}
    		 }
    	 }
  	 })   
 	.state('search', {
   	 url: "/search/:param",
   	 views:{
   		 'content':{
  			templateUrl: "showAllkind"
  		 },
   		 'showgoods@search':{
   			templateUrl:function($routeParams) {return "showAProductsBySearch?searchParam="+$routeParams.param}
   				/*function($routeParams) {return "showAProductsBySearch?searchParam="+$routeParams.param}*/
   		 }
   	 }
 	 })   
 	  .state('myMessage', {
     	 url: "/myMessage",
     	 views:{
     		 'content':{
     			templateUrl: "userManager.jsp"
     		 },
   	 		'manager@myMessage':{
   	 			templateUrl:"showUserOrders"
   	 		}
     	 }
   	 })
   	  .state('myMessage.userOrder', {
     	 url: "/userOrder",
     	 views:{
     		 
   	 		'manager@myMessage':{
   	 			templateUrl:"showUserOrders"
   	 		}
     	 }
   	 })
   	  .state('myMessage.userMessage', {
     	 url: "/userMessage",
     	 views:{
     		 
   	 		'manager@myMessage':{
   	 			templateUrl:"userMessage.jsp"
   	 		}
     	 }
   	 })
   	  .state('myMessage.showUserOrder', {
     	 url: "/showUserOrder/:ordernum",
     	 views:{
   	 		'manager@myMessage':{
   	 			templateUrl:function($routeParams) {return "showOrderByOrderNum?orderNum="+$routeParams.ordernum}
   	 			/*"showUserOrder.jsp"*/
   	 		}
     	 }
   	 })
   	   .state('myMessage.submitComment', {
     	 url: "/submitComment/:core/:content/:orderId",
     	 views:{
   	 		'manager@myMessage':{
   	 			templateUrl:function($routeParams) {return "submitComment?core="+$routeParams.core+"&content="+$routeParams.content+"&orderId="+$routeParams.orderId}
   		 			
   	 			
   	 		}
     	 }
   	 })
});
indexapp.controller('login',function($scope,$http){
	$scope.user="";
	$scope.loginresule = true; 
	$scope.gotoshop=function(){
		$('#modal-login').modal('hide');
	}
	$scope.userlogin=function(user){
		var url="userLogin?userPhone="+user.phone+"&userPassword="+user.password;
		   $http.post(url).success( function(response) {
			if("success" == response){
				$scope.loginresule = true;
				window.history.go(0);
			}else{
				$scope.loginresule = false;
			}
         }).error(function(response){
        	 alert("登陆出现错误");
         })
	}
})
indexapp.controller('register',function($scope,$http){
	$scope.user="";
	$scope.checkpwd="";
	$scope.checkpassword=function(){
		if($scope.user.password == $scope.checkpwd){
			return false;
		}else{
			return true;
		}
	};
	$scope.userregister=function(user){		
		var url="userRegister?userPhone="+user.phone+"&userPassword="+user.password;
		$http.post(url).success( function(response) {
			if("success" == response){
				alert("注册成功");
				$('#modal-login').modal('hide');
				window.history.go(0);
			}else{
				alert("注册失败")
			}
			
		}).error(function(response){alert("error")});
		
	}
	
})
indexapp.controller('searchform',function($scope){
	$scope.search="";
	$scope.tosearch="#/search/";
})
indexapp.directive("buytocart",function(){
	return function(scope,element,attrs){
		element.bind('click',function(){
			go = "#/cart/"+attrs.productdetailid;
			 window.location.href =go;
			
		});	
	}
});
indexapp.controller("sessionctrl",function($scope,$http){
	$scope.logout=function(){
		$http.get("logout").success( function(response) {
			window.history.go(0);
		});
	};
})
indexapp.controller("commentCtrl",function($scope){
	$scope.comment={
			core:'3',
			content:""
	};
	$scope.addComment=function(comment,orderid){
		go = "#/myMessage/submitComment/"+comment.core+"/"+comment.content+"/"+orderid;
		 window.location.href =go;
	}
})
indexapp.controller("shopLoginCtrl",function($scope,$http){

	$scope.shop="";
	$scope.shoplogin=function(shop){
		var url="shopLogin?shopPhone="+shop.phone+"&shopPassword="+shop.password;
		   $http.post(url).success( function(response) {
			if("success" == response){
				 window.location.href = "#/myshop";
			}else{
				alert("用户名或密码错误");
			}
         }).error(function(response){
        	 alert("登陆超时");
         })
	}

})
indexapp.controller("addProduct",function($scope,Upload){
	$scope.addProduct=function(product){
		var url="addProduct?product="+product;
		/*$http.post("#").success( function(response) {
			alert(response);
		}).error(function(response){alert("添加失败")})*/
	
		
	}
	
})