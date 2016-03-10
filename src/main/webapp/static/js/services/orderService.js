/*
/!**
 * Created by Anton on 08.03.2016.
 *!/
'use strict';

App.factory('orderService',['$http', '$q', function($http,$q){
    return{

        create: function(order){
            return $http.post('http://localhost:8080/order/', order)
                .then(
                //function(response){
                //    return response.data;
                //},
                function(errResponse){
                    console.error('Error with create client');
                    return $q.reject(errResponse);
                }
            );
        }

    }
}]);
*/
