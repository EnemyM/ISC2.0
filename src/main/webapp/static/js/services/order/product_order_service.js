'use strict';

App.factory('ProductService',['$http', '$q', function($http,$q){
    return{

        fetchAllProducts: function(){
            return $http.get('http://localhost:8080/product/')
                .then(
                function(response){
                    return response.data;
                },
                function(errResponse){
                    console.error('Error while fetching users');
                    return $q.reject(errResponse);
                }
            );
        },

        createProduct: function(product_order){
            return $http.post('http://localhost:8080/product/',product_order)
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

