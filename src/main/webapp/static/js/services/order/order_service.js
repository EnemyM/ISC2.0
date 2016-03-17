App.factory('OrderService',['$http', '$q', function($http,$q){
    return{

        create: function(order){
            return $http.post('http://localhost:8080/order/', order)
                .then(
                function(response){
                    return response.data;
                },
                function(errResponse){
                    console.error('Error with create oder');
                    return $q.reject(errResponse);
                }
            );
        }
    };
}]);
