/// <reference path="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.1/angular.js" />

angular.module('studentController', [])
    .controller('studentCtrl', ['$rootScope', '$scope', '$log', '$location', 'dataService', 'loginService', 
    function ($rootScope, $scope, $log, $location, dataService, loginService) {

        $scope.spinner = '../resource/SkinnySeveralAsianlion.gif';
        $scope.isError = false;
        $scope.isLoading = false;
        $scope.isProcessing = false;
        var userData = JSON.parse(localStorage.getItem('user')) || [];
        if(JSON.parse(localStorage.getItem('user')))
            $rootScope.user = JSON.parse(localStorage.getItem('user')).name; //loginService.getCurrentUser();
        //console.log(JSON.parse(localStorage.getItem('user')));

        $log.info('Inside students');

        $rootScope.logon = function (){
            $scope.isLoading = true;
            $scope.isProcessing = true;

            $location.url('/login');
            
            $scope.isLoading = false;
            $scope.isProcessing = false;
        }



        $rootScope.logout = function(){
            $scope.isLoading = true;
            $scope.isProcessing = true;
            var isLogOut = confirm('Do you really want to logout?');
            if(isLogOut){
                loginService.logout();
                $scope.isLoading = false;
                $scope.isProcessing = false;
                $rootScope.user = '';
                $location.url('/');
                console.log('logout successfully');
            }
        }

        $scope.getStudents = function () {
            $scope.isLoading = true;
            $scope.isProcessing = true;
            dataService.getData()
                .then(function (students) {
                    $scope.students = students.data;
                    $scope.isLoading = false;
                    $scope.isProcessing = false;
                })
                .catch(function (students) {
                    $scope.isError = true;
                    $scope.error = "Error while getting student data";
                });
        }();

        $scope.editStudent = function (rollNo) {
            $scope.isProcessing = true;
            $scope.isProcessing = true;

            $location.url(loginService.authenticate('/edit/' + rollNo));

            /*if(loginService.getCurrentUser())
                $location.url('/edit/' + rollNo);
            else
                $location.url('/login');*/

        }

        $rootScope.displayForm = function (){
            $scope.isLoading = true;
            $scope.isProcessing = true;

            $location.url(loginService.authenticate('/add'));
            
            $scope.isLoading = false;
            $scope.isProcessing = false;
        }

        $scope.deleteStudent = function (rollNo) {
            $scope.isProcessing = true;

            var isDelete = confirm("Are really want to delete student data having Roll No " + rollNo + "?");
            if (isDelete){
                $location.url(loginService.authenticate('/delete/' + rollNo));
            }
            if(!isDelete)
                $scope.isProcessing = false;

            //$location.url(loginService.authenticate('/delete/' + rollNo));

            /*if(loginService.getCurrentUser()){

                var isDelete = confirm("Are really want to delete student data having Roll No " + rollNo + "?");
                if (isDelete){
                    $location.url('/delete/' + rollNo);
                }
                if(!isDelete)
                    $scope.isProcessing = false;

            }
            else
                $location.url('/login');*/
            
            
        }
    }])
    .controller('loginCtrl', ['$scope', '$log', '$location', 'loginService', 
    function ($scope, $log, $location, loginService) {
        $log.info('Inside Login');
        $scope.spinner = '../resource/SkinnySeveralAsianlion.gif';
        $scope.isProcessing = false;

        $scope.login = function (user) {
            $scope.isProcessing = true;
            if(loginService.logon(user)){
                $log.info(loginService.getRequestedURL());
                $location.url(loginService.getRequestedURL());
                $scope.isProcessing = false;
            } else {
                console.log('not authorized');
            }
        }

    }])
    .controller('addCtrl', ['$scope', '$log', '$location', 'dataService', 
    function ($scope, $log, $location, dataService) {
        $log.info('Inside Add');
        $scope.spinner = '../resource/SkinnySeveralAsianlion.gif';
        $scope.isProcessing = false;

        $scope.createStudent = function (student) {
            $scope.isProcessing = true;
            dataService.postData(student)
                .then(function () {
                    $scope.student = {};
                    $location.url('/');
                })
                .catch(function (student) {
                    $scope.isError = true;
                    $scope.error = "Error while adding student data";
                });
        }

    }])
    .controller('editCtrl', ['$scope', '$log', '$location', '$routeParams', 'dataService',  
    function ($scope, $log, $location, $routeParams, dataService) {
        $log.info('Inside Edit');
        $scope.spinner = '../resource/SkinnySeveralAsianlion.gif';
        $scope.isProcessing = false;

        dataService.getSingleData($routeParams.rollNo)
            .then(function (student) {
               // $log.info('inside single data' + student.data.rollNo);
                $scope.student = student.data;
                $scope.student.date = new Date(student.data.date);
            })
            .catch(function (student) {
                $scope.isError = true;
                $scope.error = "Error while getting student data";
            });

        $scope.updateStudent = function (student) {
           // $log.info('Inside update');
            $scope.isProcessing = true;
                dataService.updateData(student)
                    .then(function () {
                        $scope.student = {};
                        $location.url('/');
                    })
                    .catch(function (student) {
                        $scope.isError = true;
                        $scope.error = "Error while updating student data";
                    });
        }
    }])
    .controller('deleteCtrl', ['$scope', '$log', '$location', '$routeParams', 'dataService', 
    function ($scope, $log, $location, $routeParams, dataService) {
        $log.info('Inside Delete');
        dataService.deleteData($routeParams.rollNo)
            .then(function () {
                $scope.isProcessing = false;
                $location.url('/');
            })
            .catch(function (student) {
                $scope.isError = true;
                $scope.error = "Error while deleting student data";
            });
    }]);

angular.module('studentController')
    .service('dataService', ['$http', function ($http) {

        var url = 'http://gsmktg.azurewebsites.net:80/api/v1/techlabs/test/students';

        this.getData = function () {
            return $http.get(url);
        }

        this.getSingleData = function (rollNo) {
            return $http.get(url + '/' + rollNo);
        }

        this.postData = function (student) {
            return $http.post(url, student);
        }

        this.updateData = function (student) {
            return $http.put(url + '/' + student.rollNo, student);
        }

        this.deleteData = function (rollNo) {
            return $http.delete(url + '/' + rollNo);
        }

    }])
    .service('loginService', [function () {

        var users = {
            'dheeraj' : '12345',
            'abc' : '123',
            'admin' : 'admin'
        }

        var currentUser = '';
        var requestedURL = '/';

        this.getCurrentUser = function(){
            return currentUser;
        }

        this.getRequestedURL = function(){
            return requestedURL;
        }

        this.authenticate = function(url){
            if(localStorage.getItem("user")){
                //requestedURL = url;
                return url;
            }
            requestedURL = url;
            return '/login';
        }

        this.logon = function(user){

            if(users[user.name] == user.password){
               // console.log(user.remember);
                if(user.remember){
                    localStorage.setItem("user", JSON.stringify(user));
                    currentUser = user.name;
                }
                return true;
            }

            return false;
        }

        this.logout = function(){
            localStorage.removeItem("user");
            currentUser = '';
        }

    }])
 
    .filter('gender',function(){
        return function(isMale)
        {
            return isMale ? 'Male' : 'Female';
        }
    });