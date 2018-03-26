<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

          <div ng-controller="addProduct">
            <form name="addProductForm" method="post" ng-submit="addProduct()" enctype="multipart/form-data">
              <div class="form-group">
                <label for="productname">商品名称：</label>
                <input type="input" class="form-control" id="productname" ng-model="product.productName">
              </div>
              <div class="form-group">
                <label for="producttittle">商品副标题</label>
                <input type="text" class="form-control" id="producttittle" ng-model="product.productSubtitle">
              </div>
               <div class="form-group">
                <label for="producttittle">商品类别：</label>
               <select  id="producttittle" ng-model="product.category">
                 <s:iterator value="categorys" var="c">
                 <option value="${c.categoryId}">${c.categoryName}</option>
                 </s:iterator>
               </select>
              </div>
               <div class="form-group" style="display: inline-block; width:120px;">
                <label for="producoldprice">商品原价</label>
                <input type="number" class="form-control" id="producoldprice" ng-model="product.productOriginalPrize">
               </div>
               <div class="form-group" style="display: inline-block;width:120px;">
                <label for="productnewprice">商品现价</label>
                <input type="number" class="form-control" id="productnewprice"  ng-model="product.productCurrentPrize">
              </div>
              <div class="form-group">
                <label for="exampleInputFile">上传商品图片</label>
                <input type="file" id="exampleInputFile"  ng-model="file" name="file" >
                <p class="help-block">支持JPG，JPEG，GIF，PNG, 且小于5M</p>
              </div>
              <button type="submit" class="btn btn-default">发布</button>
            </form>

          </div>
