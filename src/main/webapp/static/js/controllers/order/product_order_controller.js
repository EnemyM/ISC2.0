'use strict';

App.controller('ProductController',['$scope','ProductService','$http',function($scope,ProductService,$http){
    var self = this;

    self.product_order = {id_product_order:null,amount_product:'',price_amount:'', product_name:''};
    self.products_order = [];
    self.order = {id_order:null,transport:'',date_delivery:'',time_delivery:''};

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
              console.error('Error while creating Product.');
          }
      );
    };
    self.createOrder = function(order){
        $http.post('http://localhost:8080/order/',order);
    };

    self.fetchAllProducts();

    /* add order into the list */
    self.submit = function(){
        self.createProduct(self.product_order);
        self.reset();
    };


    /* create order with defined scope order*/
    $scope.create = function(){
        self.createOrder(self.order);
        /*self.resetOrder();*/
    };

    /* reset product add form*/
    self.reset = function(){
        self.product_order = {id_product_order:null,amount_product:'',price_amount:'', product_name:''};
        $scope.productForm.$setPristine();
    };

}]);
