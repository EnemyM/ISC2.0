'use strict';

App.controller('OrderController', ['$scope', 'OrderService', function($scope, OrderService){
    var self = this;
    self.order = {date_order:'',date_delivery:'',time_delivery:'',price_order:''};
    self.orders = [];

    self.createOrder = function(order){
        OrderService.create(order)
            .then(
            function(errResponce){
                console.error('Error with create user');
            }
        );

    };

    self.submit = function() {
        console.log('Saving New user', self.order);
        self.createOrder(self.order);
        self.reset();
    };
    self.reset = function(){
        self.order = {date_order:'',date_delivery:'',time_delivery:'',price_order:''};
        $scope.orderForm.$setPristine(); //reset Form
    };
}]);
