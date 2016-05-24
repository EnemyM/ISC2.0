'use strict';

App.controller('OrderController',['$scope','OrderService','$http',function($scope,OrderService,$http){
    var self = this;

    self.product_order = {id_product_order:null,amount_product:'',price_amount:'', product_name:''};
    self.products_order = [];
    self.order_spot = {id_order_spot:null, address:'',latitude:'',longitude:'',name_spot_type:''};
    self.order_spots =[];
    self.order = {id_order:null, date_order:'', date_delivery:'', time_delivery:'', price_order:'', name_transport:''};
    self.orders = [];

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
              return $q.reject(errResponse);
          }
      );
    };

    self.updateProduct = function(product_order,product_name){
        OrderService.updateProduct(product_order,product_name)
            .then(
            self.fetchAllProducts,
            function(errResponse){
                console.error('Error while updating Product.');
                return $q.reject(errResponse);
            }
        );

    };

    self.deleteProduct = function(product_name){
        OrderService.deleteProduct(product_name)
            .then(
            self.fetchAllProducts,
            function(errResponse){
                console.error('Error while deleting Product.');
                return $q.reject(errResponse);
            }
        );
    };

    self.fetchAllOrderSpots = function(){
        OrderService.fetchAllOrderSpots()
            .then(
            function(d){
                self.order_spots = d;
            },
            function(errResponse){
                console.error('Error while fetching Currencies');
                return $q.reject(errResponse);
            }
        );
    };

    self.createOrderSpot = function(order_spot){
        OrderService.createOrderSpot(order_spot)
            .then(
            self.fetchAllOrderSpots,
            function(errResponse){
                console.error('Error while creating Product.');
                return $q.reject(errResponse);
            }
        );
    };

    self.updateOrderSpot = function(order_spot,id_order_spot){
        OrderService.updateOrderSpot(order_spot,id_order_spot)
            .then(
            self.fetchAllOrderSpots,
            function(errResponse){
                console.error('Error while updating Product.');
                return $q.reject(errResponse);
            }
        );
    };

    self.deleteOrderSpot = function(id){
        OrderService.deleteOrderSpot(id)
            .then(
            self.fetchAllOrderSpots,
            function(errResponse){
                console.error('Error while deleting Product.');
                return $q.reject(errResponse);
            }
        );
    };

    self.fetchAllOrders = function(){
        OrderService.fetchAllOrders()
            .then(
            function(d){
                self.orders = d;
            },
            function(errResponse){
                console.error('Error while fetching Currencies');
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

    self.updateOrder = function(id){
        OrderService.updateOrder(id)
            .then(
            self.fetchAllOrders,
            function(errResponse){
                console.error('Error while updating Product.');
                return $q.reject(errResponse);
            }
        );
    };

    self.deleteOrder = function(id){
        OrderService.deleteOrder(id)
            .then(
            self.fetchAllOrders,
            function(errResponse){
                console.error('Error while updating Product.');
                return $q.reject(errResponse);
            }
        );
    };

    self.fetchAllProducts();
    self.fetchAllOrderSpots();

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

    /* edit product order  */
    self.edit = function(product_name){
        console.log('id to be edited', product_name);
        for(var i = 0; i < self.products_order.length; i++){
            if(self.products_order[i].product_name === product_name) {
                self.product_order = angular.copy(self.products_order[i]);
                break;
            }
        }
    };
    /* remove product order*/
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

        if(self.order_spot.id_order_spot === null){
            self.createOrderSpot(self.order_spot);
            console.log('Saving New order spot', self.order_spot);

        }else{
            self.updateOrderSpot(self.order_spot);
            console.log('Updated order spot', self.order_spot);
        }
        /* clean order spot input fields*/
        self.order_spot = {id_order_spot:null, address:'',latitude:'',longitude:'',name_spot_type:''};

    };

    self.deleteAllSpot = function(){
        self.order_spots = [];
    };
    /* reset product add form*/
    self.reset = function(){
        self.product_order = {id_product_order:null,amount_product:'',price_amount:'', product_name:''};
        $scope.productForm.$setPristine();
    };
}]);
