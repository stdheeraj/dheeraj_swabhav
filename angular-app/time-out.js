/// <reference path="angular-1.6.10/angular.js" />

var timeOut = angular.module("timeOut", []);

timeOut.controller("TimeOutController", function($scope, $timeout){

    $scope.developer = {
        name: 'Dheeraj',
        company: 'Swabhav Techlabs'
    };    

    $scope.callAtTimeout = function() {
        $scope.developer.company = 'FitFilia Solutions';
    }

    $timeout( function(){ $scope.callAtTimeout(); }, 3000);
});