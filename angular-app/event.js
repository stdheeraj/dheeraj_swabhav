/// <reference path="angular-1.6.10/angular.js" />

angular.module("clickEvent", [])
                        .controller("ClickEventController",['$scope', function($scope){  

                            $scope.load = function() {
                                $scope.developer = {
                                    name: 'Dheeraj',
                                    profilePicture: 'dp.png'
                                };
                            };

                        }]);


//angular.module("clickEvent",[]).controller("ClickEventController",["$scope",function(e){e.load=function(){e.developer={name:"Dheeraj",profilePicture:"dp.png"}}}]);