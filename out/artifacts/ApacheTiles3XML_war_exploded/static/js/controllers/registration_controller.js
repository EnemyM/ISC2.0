'use strict';

App.controller('RegistrationController', ['$scope', 'RegisterService', function($scope, RegisterService){
    var self = this;
    self.user = {name_firm:'',first_name:'',last_name:'',email_user:'',address_user:'',user_password:''};

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
            self.createClient(self.user);
        self.reset();
    };
    self.reset = function(){
        self.user = {name_firm:'',first_name:'',last_name:'',email_user:'',address_user:'',user_password:''};
        $scope.registerForm.$setPristine(); //reset Form
    };
}]);
