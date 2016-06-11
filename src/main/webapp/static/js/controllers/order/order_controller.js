'use strict';

App.controller('OrderController',['$scope','OrderService','$http',function($scope,OrderService,$http){
    var self = this;

    self.product = {id_product:null, product_name:'', product_cost:'',product_amount:'', product_date_storage:''};
    self.product_order = {id_product_order:null,amount_product:'',price_amount:'', product_name:''};
    self.products_order = [];
    self.order_spot = {id_order_spot:null, address:'',latitude:'',longitude:'',name_spot_type:'',hashCode:null};
    self.order_spots =[];
    self.order_route = {id_order_route:null, start_route:'', end_route:''};
    self.order = {id_order:null, date_order:'', date_delivery:'', time_delivery:'', price_order:'', name_transport:''};
    self.orders = [];

    self.fetchAllOrderProducts = function(){
      OrderService.fetchAllOrderProducts()
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

    self.createOrderProduct = function(product_order){
      OrderService.createOrderProduct(product_order)
          .then(
          self.fetchAllOrderProducts,
          function(errResponse){
              console.error('Error while creating Product.');
              return $q.reject(errResponse);
          }
      );
    };

    self.updateOrderProduct = function(product_order,product_name){
        OrderService.updateOrderProduct(product_order,product_name)
            .then(
            self.fetchAllOrderProducts,
            function(errResponse){
                console.error('Error while updating Product.');
                return $q.reject(errResponse);
            }
        );

    };

    self.deleteOrderProduct = function(product_name){
        OrderService.deleteOrderProduct(product_name)
            .then(
            self.fetchAllOrderProducts,
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
                console.error('Error while fetching order spots');
                return $q.reject(errResponse);
            }
        );
    };

    self.createOrderSpot = function(order_spot){
        OrderService.createOrderSpot(order_spot)
            .then(
            self.fetchAllOrderSpots,
            function(errResponse){
                console.error('Error while creating order spot.');
                return $q.reject(errResponse);
            }
        );
    };

    self.updateOrderSpot = function(order_spot,hashCode){
        OrderService.updateOrderSpot(order_spot,hashCode)
            .then(
            self.fetchAllOrderSpots,
            function(errResponse){
                console.error('Error while updating order spot.');
                return $q.reject(errResponse);
            }
        );
    };

    self.deleteOrderSpot = function(address){
        OrderService.deleteOrderSpot(address)
            .then(
            self.fetchAllOrderSpots,
            function(errResponse){
                console.error('Error while delete order spot.');
                return $q.reject(errResponse);
            }
        );
    };
    self.deleteAllOrderSpot = function(){
        OrderService.deleteAllOrderSpots()
            .then(
            self.fetchAllOrderSpots,
            function(errResponse){
                console.error('Error while delete all order spots.');
                return $q.reject(errResponse);
            }
        );
    };

    self.createOrderRoute = function(order_route){
        OrderService.createOrderRoute(order_route)
            .then(
            function(errResponse){
                console.error('Error with creating order route.');
                return $q.reject(errResponse);
            }
        );
    };
    self.fetchAllOrders = function(){
        OrderService.fetchAllOrders()
            .then(
            function(d){
                alert("fetch all orders");
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
            self.fetchAllOrders,
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

    self.fetchAllOrderProducts();
    self.fetchAllOrderSpots();
    self.fetchAllOrders();

    /* add or update product order from the list */
    self.submit = function(){
        if(self.product_order.price_amount === ''){
           console.log('Saving New Product', self.product_order);
            self.createOrderProduct(self.product_order);
         } else{
           self.updateOrderProduct(self.product_order,self.product_order.product_name);
           console.log('Product updated with id ', self.product_order.product_name);
        }
        self.reset();
    };

    /* edit product order  */
    self.edit = function(product_name){
        console.log('product to be edited', product_name);
        for(var i = 0; i < self.products_order.length; i++){
            if(self.products_order[i].product_name === product_name) {
                self.product_order = angular.copy(self.products_order[i]);
                break;
            }
        }
    };
    /* remove product order*/
    self.remove = function(product_name){
        console.log('product to be deleted', product_name);
        if(self.product_order.product_name === product_name) {//clean form if the user to be deleted is shown there.
            self.reset();
        }
        self.deleteOrderProduct(product_name);
    };

    /* create order with defined scope order*/
    self.create = function(){
        self.createOrder(self.order);
        self.order = {id_order:null,transport:'',date_delivery:'',time_delivery:''};
        self.order_spots = {};
        self.products_order = {};
    };

    /* create order spot*/
    self.addSpot = function(){

        if(self.order_spot.hashCode === null){
            self.createOrderSpot(self.order_spot);
            console.log('Saving New order spot', self.order_spot);

        }else{
            self.updateOrderSpot(self.order_spot, self.order_spot.hashCode);
            console.log('Updated order spot', self.order_spot);
        }
        /* clean order spot input fields*/
        self.order_spot = {id_order_spot:null, address:'',latitude:'',longitude:'',name_spot_type:'',hashCode:null};
    };

    /* edit order spot*/
    self.editOrderSpot = function(address){
        console.log('order spot to be edited with address', address);
        for(var i = 0; i < self.order_spots.length; i++){
            if(self.order_spots[i].address === address){
                self.order_spot = angular.copy(self.order_spots[i]);
                break;
            }
        }
    };

    /* remove order spot */
    self.removeOrderSpot = function(address){
        console.log('Order spot to be deleted with address ', address);
        if(self.order_spot.address === address){
            self.deleteOrderSpot(address);
        }
        /* clean order spot input fields*/
        self.order_spot = {id_order_spot:null, address:'',latitude:'',longitude:'',name_spot_type:'',hashCode:null};
    };

    /* remove all order spots */
    self.deleteAllSpots = function(){
        self.deleteAllOrderSpot();

    };
    /* save route start and end*/
    self.saveRoute = function(){
        for(var i = 0; i < self.order_spots.length; i++){
            if(self.order_spots[i].name_spot_type === 'Store'){
                self.order_route.start_route = self.order_spots[i].address;
            }else{
                self.order_route.end_route = self.order_spots[i].address;
            }
        }
        self.createOrderRoute(self.order_route);
    };
    /* reset product add form*/
    self.reset = function(){
        self.product_order = {id_product_order:null,amount_product:'',price_amount:'', product_name:''};
        $scope.productForm.$setPristine();
    };
}]);
