'use strict';

App.controller('ProductController',['$scope','ProductService','$http',function($scope,ProductService,$http){
    var self = this;

    self.product_order = {id_product_order:null,amount_product:'',price_amount:'', product_name:''};
    self.products_order = [];
    self.order = {id_order:null,transport:'',date_delivery:'',time_delivery:''};
    self.order_spot = {id_order_spot:null, address:'',latitude:'',longitude:'',name_spot_type:''};

    self.fetchAllProducts = function(){
      ProductService.fetchAllProducts()
          .then(
              function(d){
                  self.products_order = d;
              },
              function(errResponse){
                  console.error('Error while fetching Currencies');
                  return $q.reject(errResponse);
              }
      );
    };

    self.createProduct = function(product_order){
      ProductService.createProduct(product_order)
          .then(
          self.fetchAllProducts,
          function(errResponse){
              console.error('Error while creating Product.');
              return $q.reject(errResponse);
          }
      );
    };

    self.createOrderSpot = function(order_spot){
        ProductService.createOrderSpot(order_spot)
            .then(
            function(errResponse){
                console.error('Error while creating Product.');
                return $q.reject(errResponse);
            }
        );
    };

    self.createOrder = function(order){
        ProductService.createOrder(order)
            .then(
            function(errResponse){
                console.error('Error while creating Product.');
                return $q.reject(errResponse);
            }
        );
    };

    self.fetchAllProducts();

    /* add order into the list */
    self.submit = function(){
        self.createProduct(self.product_order);
        self.reset();
    };

    /* create order with defined scope order*/
    self.create = function(){
        self.createOrder(self.order);
        self.order = {id_order:null,transport:'',date_delivery:'',time_delivery:''};
    };
    /* create order spot*/
    self.addSpot = function(){
        self.createOrderSpot(self.order_spot);
        self.order_spot = {id_order_spot:null, address:'',latitude:'',longitude:'',name_spot_type:''};
    };

    /* reset product add form*/
    self.reset = function(){
        self.product_order = {id_product_order:null,amount_product:'',price_amount:'', product_name:''};
        $scope.productForm.$setPristine();
    };
}]);
