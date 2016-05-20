'use strict';

App.controller('OrderController',['$scope','OrderService','$http',function($scope,OrderService,$http){
    var self = this;

    self.product_order = {id_product_order:null,amount_product:'',price_amount:'', product_name:''};

    self.products_order = [];
    self.order = {id_order:null, date_order:'', date_delivery:'', time_delivery:'', price_order:'', name_transport:''};
    self.order_spot = {id_order_spot:null, address:'',latitude:'',longitude:'',name_spot_type:''};

    self.fetchAllProducts = function(){
      OrderService.fetchAllProducts()
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
      OrderService.createProduct(product_order)
          .then(
          self.fetchAllProducts,
          function(errResponse){
              console.error('Error while creating Product.');
          }
      );
    };

    self.updateProduct = function(product_order,product_name){
        OrderService.updateProduct(product_order,product_name)
            .then(
            self.fetchAllProducts,
            function(errResponse){
                console.error('Error while updating Product.');
            }
        );

    };
    self.deleteProduct = function(product_name){
        OrderService.deleteProduct(product_name)
            .then(
            self.fetchAllProducts,
            function(errResponse){
                console.error('Error while deleting Product.');
            }
        );

    };

    self.createOrderSpot = function(order_spot){
        OrderService.createOrderSpot(order_spot)
            .then(
            function(errResponse){
                console.error('Error while creating Product.');
                return $q.reject(errResponse);
            }
        );
    };

    self.createOrder = function(order){
        OrderService.createOrder(order)
            .then(
            function(errResponse){
                console.error('Error while creating Product.');
                return $q.reject(errResponse);
            }
        );
    };
    self.fetchAllProducts();
    /* add or update product order from the list */
    self.submit = function(){
        if(self.product_order.price_amount === ''){
           console.log('Saving New Product', self.product_order);
            self.createProduct(self.product_order);
         } else{
           self.updateProduct(self.product_order,self.product_order.product_name);
           console.log('Product updated with id ', self.product_order.product_name);
        }
        self.reset();
    };

    self.edit = function(product_name){
        console.log('id to be edited', product_name);
        for(var i = 0; i < self.products_order.length; i++){
            if(self.products_order[i].product_name === product_name) {
                self.product_order = angular.copy(self.products_order[i]);
                break;
            }
        }
    };
    self.remove = function(product_name){
        console.log('id to be deleted', product_name);
        if(self.product_order.product_name === product_name) {//clean form if the user to be deleted is shown there.
            self.reset();
        }
        self.deleteProduct(product_name);
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
