'use strict';

App.controller('OrderController', ['$scope', 'OrderService','$http', function($scope, OrderService,$http){
    var self = this;
    self.order = {id_order:'',date_delivery:'',time_delivery:''};
    self.orders = [];

    self.createOrder = function(order){
        $http.post('http://localhost:8080/order/',order);
       /* OrderService.create(order)
            .then(
            function(errResponce){
                console.error('Error with create user');
            }
        );*/
    };

    self.submit = function() {
        console.log('Saving New order', self.order);
        self.createOrder(self.order);
        self.reset();
    };
    self.reset = function(){
        self.order = {id_order:'',date_delivery:'',time_delivery:''};
        $scope.orderForm.$setPristine(); //reset Form
    };
}]);
