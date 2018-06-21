/// <reference path="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.1/angular.js" />

angular.module('swabhav.controller', [])
                .controller('HomeCtrl', ['$scope', '$log', function($scope, $log){
                    $log.info('Inside Home');
                    $scope.homeData = 'Inside HOME';
                }])
                .controller('AboutCtrl', ['$scope', '$log', function($scope, $log){
                    $log.info('Inside About');
                    $scope.aboutData = 'Inside ABOUT';
                }])
                .controller('CareerCtrl', ['$scope', '$log', function($scope, $log){
                    $log.info('Inside Career');
                    $scope.careerData = 'Inside CAREER';
                }]);