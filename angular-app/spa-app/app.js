/// <reference path="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.1/angular.js" />

angular.module('spa-app', ['ngRoute', 'swabhav.controller'])
        .config(['$routeProvider', function ($routeProvider) {
            $routeProvider.when('/',{
                                    templateUrl: 'partials/home.html',
                                    controller : "HomeCtrl"
                            })
                            .when('/about',{
                                    templateUrl: 'partials/about.html',
                                    controller : "AboutCtrl"
                            })
                            .when('/career',{
                                    templateUrl: 'partials/career.html',
                                    controller : "CareerCtrl"
                            })
                            .when('/home',{
                                    templateUrl: 'partials/home.html',
                                    controller : "HomeCtrl"
                            });
        }]);