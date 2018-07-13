/// <reference path="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.1/angular.js" />

angular.module('student-spa-app', ['ngRoute', 'studentController'])
        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/', {
                        templateUrl: 'views/students.html',
                        controller: "studentCtrl"
                })
                        .when('/add', {
                                templateUrl: 'views/add.html',
                                controller: "addCtrl"
                        })
                        .when('/edit/:rollNo', {
                                templateUrl: 'views/edit.html',
                                controller: "editCtrl"
                        })
                        .when('/delete/:rollNo', {
                                template: '<br><br><br><br><br><br><br><br><br><br><br>'+
                                '<div align="center"><img src="../resource/SkinnySeveralAsianlion.gif" width="100" height="100">'+
                                '<br><strong> Loading...</strong></div>',
                                controller: "deleteCtrl"
                        })
                        .when('/students', {
                                templateUrl: 'views/students.html',
                                controller: "studentCtrl"
                        })
                        .when('/login', {
                                templateUrl: 'views/login.html',
                                controller: "loginCtrl"
                        });
        }]);