/// <reference path="angular-1.6.10/angular.js" />

angular.module('modA', ['modB','modC']);
angular.module('modA')
                    .controller('InvoiceController', function($rootScope, $scope){
                        console.log("inside invoice controller");
                        $rootScope.developer = 'Dheeraj';
                        $scope.invoice = {
                            date: '10/10/2010',
                            cost: 100000
                        };
                    });

angular.module('modB',[])
                    .controller('AddressController', function($scope, $rootScope){
                        console.log("inside address controller"+$rootScope.developer);
                        $scope.address = {
                            city: 'mumbai',
                            state: 'maharashtra',
                            pincode: 400055
                        };
                    });

angular.module('modC',[])
                    .controller('OrderController', function($scope){
                        console.log("inside order controller");
                        $scope.order = {
                            product:'IPhone',
                            quantity: 2,
                            cost: 50000
                        };
                    });