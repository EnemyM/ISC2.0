/*
'use strict';

App.controller('orderController', ['$scope', 'orderService', function($scope, orderService){
    var self = this;
    self.order = {date_order:'',date_delivery:'',time_delivery:'',price_order:''};

    self.createOrder = function(order){
        orderService.create(order)
            .then(
            function(errResponce){
                console.error('Error with create client');
            }
        );
    };

    self.submit = function() {
        console.log('Saving New order', self.order);
        self.createOrder(self.order);
        self.reset();
    };
    self.reset = function(){
        self.order = {date_order:'',date_delivery:'',time_delivery:'',price_order:''};
        $scope.registerForm.$setPristine(); //reset Form
    };
}]);*/
