/// <reference path="angular-1.6.10/angular.js" />

angular.module("clickEvent", [])
                        .controller("ClickEventController", function($scope){  

                            $scope.load = function() {
                                $scope.developer = {
                                    name: 'Dheeraj',
                                    profilePicture: 'dp.png'
                                };
                            };

                        });