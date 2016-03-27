<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 30.01.2016
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv = "Content-Type" content="text/html; charset = UTF-8">
    <title>Clint registration form</title>
    <style>

        .user_password.ng-valid {
            background-color: lightgreen;
        }
        .user_password.ng-dirty.ng-invalid-required {
            background-color: red;
        }
        .user_password.ng-dirty.ng-invalid-minlength {
            background-color: yellow;
        }
        .email.ng-valid {
            background-color: lightgreen;
        }
        .email.ng-dirty.ng-invalid-required {
            background-color: red;
        }
        .email.ng-dirty.ng-invalid-email {
            background-color: yellow;
        }

    </style>
    <link href="<c:url value='/static/css/registration' />" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
    <link href="<c:url value='/static/css/bootstrap.main.css' />" rel="stylesheet"/>

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-resource.js"></script>
    <script src="<c:url value='/static/js/app.js' />"></script>
    <script src="<c:url value='/static/js/services/register_service.js' />"></script>
    <script src="<c:url value='/static/js/controllers/registration_controller.js' />"></script>

</head>
<body ng-app ="myApp" class="ng-cloak">
<div class="generic-container" ng-controller="RegistrationController as ctrl">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">Registration form </span></div>
        <div class="formcontainer">
            <form ng-submit="ctrl.submit()" name="registerForm" class="form-horizontal">
                <input type="hidden" ng-model="ctrl.user.id_user" />

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="name_firm"> Company Name </label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.user.name_firm" id="name_firm" class="name_firm form-control input-sm" placeholder="Enter name your firm" required ng-minlength="2"/>
                            <div class="has-error" ng-show="registerForm.$dirty">
                                <span ng-show="registerForm.nameFirm.$error.required">This is a required field</span>
                                <span ng-show="registerForm.nameFirm.$error.minlength">Minimum length required is 3</span>
                                <span ng-show="registerForm.nameFirm.$invalid">This field is invalid </span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="first_name">First Name</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.user.first_name" id="first_name" class="first_name form-control input-sm" placeholder="Enter your name" required ng-minlength="3"/>
                            <div class="has-error" ng-show="registerForm.$dirty">
                                <span ng-show="registerForm.firstName.$error.required">This is a required field</span>
                                <span ng-show="registerForm.firstName.$error.minlength">Minimum length required is 3</span>
                                <span ng-show="registerForm.firstName.$invalid">This field is invalid </span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="last_name">Last Name</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.user.last_name" id="last_name" class="last_name form-control input-sm" placeholder="Enter your last name" required ng-minlength="3"/>
                            <div class="has-error" ng-show="registerForm.$dirty">
                                <span ng-show="registerForm.firstName.$error.required">This is a required field</span>
                                <span ng-show="registerForm.firstName.$error.minlength">Minimum length required is 3</span>
                                <span ng-show="registerForm.firstName.$invalid">This field is invalid </span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="email_user">Email</label>
                        <div class="col-md-7">
                            <input type="email" ng-model="ctrl.user.email_user" id="email_user" class="email_user form-control input-sm" placeholder="Enter your Email" required/>
                            <div class="has-error" ng-show="registerForm.$dirty">
                                <span ng-show="registerForm.email.$error.required">This is a required field</span>
                                <span ng-show="registerForm.email.$invalid">This field is invalid </span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="address_user">Address</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.user.address_user" id="address_user" class="form-control input-sm" placeholder="Enter your Address. [This field is validation free]"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="user_password"> Password </label>
                        <div class="col-md-7">
                            <input path="password" ng-model="ctrl.user.user_password" id="user_password" type="password" class="form-control input-sm" placeholder="More than 8 characters " required ng-minlength="8"/>
                            <div class="has-error" ng-show="registerForm.$dirty">
                                <span ng-show="registerForm.password.$error.required">This is a required field</span>
                                <span ng-show="registerForm.password.$error.minlength">Minimum length required is 3</span>
                                <span ng-show="registerForm.password.$invalid">This field is invalid </span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-actions floatRight">
                        <input type="submit"  value="Add" class="btn btn-primary btn-sm" ng-disabled="registerForm.$invalid"/>
                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="registerForm.$pristine">Reset Form</button>

                    </div>
                </div>

            </form>
        </div>
    </div>
</div>
<%--</div>--%>
</body>
</html>
