'use strict';

App.factory('OrderService',['$http', '$q', function($http,$q){
    /* basic order page url */
    var baseUrl = 'http://localhost:8080/order';
    return{
        createProduct: function(){
            return $http.post(baseUrl + '/product/')
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

        fetchAllOrderProducts: function(){
            return $http.get(baseUrl + '/product_order/')
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
        createOrderProduct: function(product_order){
            return $http.post(baseUrl + '/product_order/',product_order)
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
        updateOrderProduct: function(product_order,product_name){
            return $http.put(baseUrl + '/product_order/'+ product_name, product_order)
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
        deleteOrderProduct: function(product_name){
            return $http.delete(baseUrl + '/product_order/' + product_name)
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
        updateOrderSpot: function(order_spot,hashCode){
            return $http.put(baseUrl +'/order_spot/' + hashCode, order_spot)
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
        deleteOrderSpot: function(address){
            return $http.delete(baseUrl + '/order_spot/' + address)
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
        deleteAllOrderSpots: function(){
          return $http.delete(baseUrl + '/order_spot/delete_all')
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

        createOrderRoute: function(order_route){
            return $http.post(baseUrl + '/order_route/', order_route)
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
        fetchAllOrders: function(){
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

