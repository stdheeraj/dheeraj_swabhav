/// <reference path="angular-1.6.10/angular.js" />

angular.module("binding", []).controller("bindingController", function($scope){  
                            $scope.emp = {
                                id: 101,
                                name: 'Dheeraj',
                                role: 'Developer'
                            };

                        });