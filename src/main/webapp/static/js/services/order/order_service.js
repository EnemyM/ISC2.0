'use strict';

App.factory('OrderService',['$http', '$q', function($http,$q){
    /* basic order page url */
    var url = 'http://localhost:8080/order';
    return{
        fetchAllProducts: function(){
            return $http.get(url + '/product/')
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
            return $http.post(url + '/product/',product_order)
                .then(
                function(response){
                    return response.data;
                },
                function(errResponse){
                    console.error('Error with create oder');
                    return $q.reject(errResponse);
                }
            );
        },
        updateProduct: function(product_order,product_name){
            return $http.put(url + '/product/'+ product_name, product_order)
                .then(
                function(response){
                    return response.data;
                },
                function(errResponse){
                    console.error('Error while updating user');
                    return $q.reject(errResponse);
                }
            );
        },
        deleteProduct: function(product_name){
            return $http.delete(url + '/product/' + product_name)
            .then(
                function(response){
                    return response.data;
                },
                function(errResponse){
                    console.error('Error while deleting user');
                    return $q.reject(errResponse);
                }
            );
        },
        createOrderSpot: function(order_spot){
            return $http.post(url + '/order_spot/',order_spot)
                .then(
                function(response){
                    return response.data;
                },
                function(errResponse){
                    console.error('Error with create oder');
                    return $q.reject(errResponse);
                }
            );
        },
        createOrder: function (order) {
            return $http.post(url + '/',order)
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

