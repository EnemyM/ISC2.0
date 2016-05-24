'use strict';

App.factory('OrderService',['$http', '$q', function($http,$q){
    /* basic order page url */
    var baseUrl = 'http://localhost:8080/order';
    return{
        fetchAllProducts: function(){
            return $http.get(baseUrl + '/product/')
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
            return $http.post(baseUrl + '/product/',product_order)
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
            return $http.put(baseUrl + '/product/'+ product_name, product_order)
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
            return $http.delete(baseUrl + '/product/' + product_name)
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
        fetchAllOrderSpots : function(){
            return $http.get(baseUrl + '/order_spot/')
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
        createOrderSpot: function(order_spot){
            return $http.post(baseUrl + '/order_spot/',order_spot)
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
        updateOrderSpot: function(order_spot,id_order_spot){
            return $http.put(baseUrl +'/order_spot/' + id_order_spot, order_spot)
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
        deleteOrderSpot: function(id_order_spot){
            return $http.delete(baseUrl + 'order_spot' + id_order_spot)
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
        fetchAllOrders: function () {
            return $http.get(baseUrl + '/')
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
        createOrder: function (order) {
            return $http.post(baseUrl + '/',order)
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
        updateOrder: function(order,id_order){
            return $http.put(baseUrl + '/' + id_order,order)
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
        deleteOrder: function(id_order){
            return $http.delete(baseUrl + '/' +id_order)
                .then(
                function(response){
                    return response.data;
                },
                function(errResponse){
                    console.error('Error while updating user');
                    return $q.reject(errResponse);
                }
            );
        }
    };
}]);

