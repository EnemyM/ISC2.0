'use strict';

App.controller('ProductController',['$scope','ProductService',function($scope,ProductService){
    var self = this;
    self.product_order = {amount_product:'',price_amount:'', product:''};
    self.products_order = [];

    self.fetchAllProducts = function(){
      ProductService.fetchAllProducts()
          .then(
          function(d){
              self.products_order = d;
          },
          function(errResponse){
              console.error('Error while fetching Currencies');
          }
      );
    };

    self.createProduct = function(product_order){
      ProductService.createProduct(product_order)
          .then(
          self.fetchAllProducts,
          function(errResponse){
              console.error('Error while creating User.');
          }
      );
    };

    self.fetchAllProducts();

    self.submit = function(){

        self.createProduct(self.product_order);
        self.reset();
    };

    self.reset = function(){
        self.product_order = {amount_product:''};
        $scope.productForm.$setPristine();
    };
}]);
