'use strict';

App.controller('RegistrationController', ['$scope', 'RegisterService','$http', function($scope, RegisterService,$http){
    var self = this;
    self.user = {name_firm:'',first_name:'',last_name:'',email_user:'',address_user:'',user_password:''};
    self.test = {variable:''};

    self.createClient = function(user){

        RegisterService.create(user)
            .then(
            function(errResponce){
                console.error('Error with create user');
            }
        );

    };

    self.submit = function() {
            console.log('Saving New user', self.user);
            self.createClient(self.test);
        self.reset();
    };
    self.reset = function(){
        self.user = {name_firm:'',first_name:'',last_name:'',email_user:'',address_user:'',user_password:''};
        $scope.registerForm.$setPristine(); //reset Form
    };
}]);
