indexapp.controller('shoppingcart', function($scope,$rootScope){
	$rootScope.cart=[];	
	$rootScope.shopid="";
	$scope.gotoorder=function(){
		 window.location.href ="#/addorder";
	};
	$scope.addtocart=function(good,shopid){		
		check=false;
		check = $scope.addgoodnum(good.pageCartId);
		if(check == false){
			$rootScope.cart.push(good);
			/*$scope.cart.push({id:good.id,name:good.name,count:1,price:good.price});*/
		}
		$rootScope.shopid = shopid;
	};
	$scope.singletotalprice=function(id){
		price=0;
		angular.forEach($rootScope.cart,function(item){
			if(id == item.pageCartId){
				price = item.pageCartCount * item.pageCartPrice;
			}			
		} );		 
		return price;
	};
	$scope.total=function(){
		price=0;
		angular.forEach($rootScope.cart,function(item){
			price += item.pageCartCount * item.pageCartPrice;
		} );
		return price;
	};
	$scope.totalnum=function(){
		num=0;
		angular.forEach($scope.cart,function(item){
			num += item.pageCartCount;
		} );
		return num;
	};
	$scope.up=function(id){
		$scope.addgoodnum(id);
	};
	$scope.down=function(id){

		angular.forEach($rootScope.cart,function(item,index){
			if(id == item.pageCartId){
				if($rootScope.cart[index].pageCartCount == 1){
					$rootScope.cart.splice(index,1);
				}else{
					--$rootScope.cart[index].pageCartCount;
				}
				
			}
		});
	};
	$scope.addgoodnum=function(id){
		check=false;
		angular.forEach($rootScope.cart,function(item,index){
			if(id == item.pageCartId){
				++$rootScope.cart[index].pageCartCount;
				check=true;
			}
		});
		return check;
	};
	$scope.cartcontenthide=false;
	$scope.carthide=function(){
		if($scope.cartcontenthide == false){
			$scope.cartcontenthide = true;
		}else{
			$scope.cartcontenthide = false;
		}
		
	}
})
indexapp.directive("showgood",function(){
	return function(scope,element,attrs){
		element.bind('click',function(){				
			good={};
			good.pageCartId = attrs.showgoodnum;
			good.pageCartName = attrs.showgoodname;
			good.pageCartCount = 1;
			good.pageCartPrice = attrs.showgoodprice;
			scope.$apply( scope.addtocart(good,attrs.shopid));	
			 return false;
		});	
	}
});

indexapp.controller("addorderctrl",function($scope,$rootScope,$http){
	$scope.totalorder=function(){
		price=0;
		angular.forEach($rootScope.cart,function(item){
			price += item.pageCartCount * item.pageCartPrice;
		} );
		return price;
	};
	$scope.payaction=function(){
		var param = angular.toJson($rootScope.cart,true);
		var url="pay?cart="+param+"&shopId="+$rootScope.shopid;
		   $http.post(url).success( function(response) {
				alert("支付成功！")
			    $rootScope.cart=[];	
				window.history.back(-1); 
            });
	};
});
