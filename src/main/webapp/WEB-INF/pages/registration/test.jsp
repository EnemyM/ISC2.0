<!DOCTYPE html>
<html data-ng-app="formSubmit">
<head>
  <meta charset="ISO-8859-1">
  <title>AngularJS Post Form Spring MVC example</title>
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.min.js"></script>
  <script type="text/javascript">
    var app = angular.module('formSubmit', []);

    app.controller('FormSubmitController',[ '$scope', '$http', function($scope, $http) {

      $scope.list = [];
      $scope.headerText = 'AngularJS Post Form Spring MVC example: Submit below form';
      $scope.submit = function() {

        var formData = {
          "name" : $scope.name,
          "location" : $scope.location,
          "phone" : $scope.phone
        };

        var response = $http.post('/home', formData);
        response.success(function(data, status, headers, config) {
          $scope.list.push(data);
        });
        response.error(function(data, status, headers, config) {
          alert( "Exception details: " + JSON.stringify({data: data}));
        });

        //Empty list data after process
        $scope.list = [];

      };
    }]);
  </script>
</head>
<body>
<form data-ng-submit="submit()" ng-controller="FormSubmitController as ctr">
  <h3>{{headerText}}</h3>
  <p>Name: <input type="text" ng-model="name"></p>
  <p>Location: <input type="text" ng-model="location"></p>
  <p>Phone: <input type="text" ng-model="phone"></p>
  <input type="submit" id="submit" value="Submit" ng-click="ctr.submit"/><br>

  <h4>You submitted below data through post:</h4>
  <pre>Form data ={{list}}</pre>
</form>
</body>
</html>