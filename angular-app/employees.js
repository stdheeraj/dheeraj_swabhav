var app = angular.module('employeeApp', []);
        app.controller('employeeCtrl', function ($scope) {

            $scope.employees = [];

            $scope.addEmployee = function (emp) {
                $scope.employees.push(emp);
                $scope.emp = {};
            }
            
        });