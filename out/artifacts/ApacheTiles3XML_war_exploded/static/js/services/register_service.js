'use strict';

App.factory('RegisterService',['$http', '$q', function($http,$q){
    return{

        create: function(user){
            return $http.post('http://localhost:8080/registration/', user)
                .then(
                function(response){
                    return response.data;
                },
                function(errResponse){
                    console.error('Error with create user');
                    return $q.reject(errResponse);
                }
            );
        }
    };
}]);
