angular.module('studentAPI', [])
    .controller('studentAPICtrl', function ($scope, dataService) {

        $scope.isFormDisplay=false;
        $scope.isSubmit = true;
        $scope.isError=false;
        $scope.isRollNoError=false;
        $scope.isNameError=false;
        $scope.isAgeError=false;
        $scope.isEMailError=false;
        $scope.isDateError=false;
        $scope.isGenderError=false;
        $scope.isProcessing=false;
        $scope.isLoading=false;

        $scope.isValidData = function(student){

            var errorStatus = 1;

            if (student == undefined) {
                $scope.isRollNoError=true;
                $scope.isNameError=true;
                $scope.isAgeError=true;
                $scope.isEMailError=true;
                $scope.isDateError=true;
                $scope.isGenderError=true;
                errorStatus = 0;
                return errorStatus;
            }
    
            if (student.rollNo == undefined || student.rollNo == "" || isNaN(student.rollNo) || student.rollNo < 1) {
                $scope.isRollNoError=true;
                errorStatus = 0;
            }

            if (student.name == undefined || student.name == "" || !isNaN(student.name)) {
                $scope.isNameError=true;
                errorStatus = 0;
            }
    
            if (student.age == undefined || student.age == "" || isNaN(student.age) || student.age < 1) {
                $scope.isAgeError=true;
                errorStatus = 0;
            }
    
            if (student.email == undefined || student.email == "") {
                $scope.isEMailError=true;
                errorStatus = 0;
            }

            if (!Date.parse(student.date)) {
                $scope.isDateError=true;
                errorStatus = 0;
            }

            if (student.isMale == undefined) {
                $scope.isGenderError=true;
                errorStatus = 0;
            }
            
            return errorStatus;
        }

        $scope.displayError = function(error){
            if(error.config.method == "GET")
                $scope.error = "Error while getting student data";

            if(error.config.method == "POST")
                $scope.error = "Error while submitting student data";

            if(error.config.method == "PUT")
                $scope.error = "Error while updating student data";
            
            if(error.config.method == "DELETE")
                $scope.error = "Error while deleting student data";
            
            $scope.isError=true;
        }

        $scope.getStudents = function () {
            $scope.isLoading=true;
            $scope.isProcessing=true;
            dataService.getData()
            .then(function (students) {
                $scope.students = students.data;
                $scope.isFormDisplay=false;
                $scope.isProcessing=false;
                $scope.isLoading=false;
            })
            .catch(function (students) {
                $scope.displayError(students);
            });
        }

        $scope.displayForm = function (){
            $scope.isSubmit = true;
            $scope.isProcessing=false;
          //  $scope.submitBtn = 'Submit';
            $scope.isFormDisplay=true;
        }

        $scope.createStudent = function (student) {
         //   $scope.submitBtn = '<i class="fa fa-spinner fa-spin"></i>Submitting';
            $scope.isProcessing=true;

            var validationStatus = $scope.isValidData(student);
    
            if (validationStatus == 1) {
                dataService.postData(student)
                .then(function () {
                    $scope.student = {};
                    $scope.getStudents(); 
                })
                .catch(function (student) {
                    $scope.displayError(student);
                });
            }

            if (validationStatus == 0) {
                $scope.isProcessing=false;
                console.log('error on submit')
               // $('#error').html('<p>Invalid Data</p>');
    
            }
        }

        $scope.getStudent = function (rollNo) {
            $scope.isProcessing=true;
            dataService.getSingleData(rollNo)
            .then(function (student) {
                $scope.isSubmit = false;
              //  $scope.updateBtn = 'Update';
                $scope.isProcessing=false;
                $scope.student = student.data;
                $scope.student.date = new Date(student.data.date);
                $scope.isFormDisplay=true;

            })
            .catch(function (student) {
                $scope.displayError(student);
            });

        }

        $scope.updateStudent = function (student) {
          //  $scope.updateBtn = '<i class="fa fa-spinner fa-spin"></i>Updating';
            $scope.isProcessing=true;
            var validationStatus = $scope.isValidData(student);
    
            if (validationStatus == 1) {
                dataService.updateData(student)
                .then(function () {
                    $scope.student = {};
                    $scope.getStudents(); 
                })
                .catch(function (student) {
                    $scope.displayError(student);
                });
            }
            if (validationStatus == 0) {
                $scope.isProcessing=false;
                console.log('error on update')
               // $('#error').html('<p>Invalid Data</p>');
    
            }
        }

        $scope.deleteStudent = function (rollNo) {
            dataService.deleteData(rollNo)
            .then(function () {
                $scope.getStudents(); 
            })
            .catch(function (student) {
                $scope.displayError(student);
            });
        }

        $scope.getStudents();
    });

angular.module('studentAPI')
    .factory('dataService', function ($http) {

        var url = 'http://gsmktg.azurewebsites.net:80/api/v1/techlabs/test/students';

        var obj = {};
        
        obj.getData = function () {
            return $http.get(url);
        }

        obj.getSingleData = function (rollNo) {
            return $http.get(url+'/'+rollNo);
        }

        obj.postData = function (student) {
            return $http.post(url, student);
        }

        obj.updateData = function (student) {
            return $http.put(url+'/'+student.rollNo, student);
        }

        obj.deleteData = function (rollNo) {
            return $http.delete(url+'/'+rollNo);
        }

        return obj;

    });

















/*
$('#studentList').hide();
$('#fillForm').hide();
$('#error').hide();
$('#spinner').hide();

$(document).ready(function() {

    var serverUrl = 'http://gsmktg.azurewebsites.net:80/api/v1/techlabs/test/students';

    function takeData(){
        var student = {};

        student.rollNo = $('#rollNo').val();
        student.name = $('#name').val();
        student.age = $('#age').val();
        student.email = $('#email').val();
        student.date = $('#date').val();
        student.isMale = document.getElementById('male').checked;

        return student;
    }

    function getSingleData(currentStudent){
        
        $.ajax({
            method:'GET',
            url: serverUrl+'/'+$(currentStudent).val(),
            beforeSend: startSpinner(),
            success:function(studentData) {
                stopSpinner();

                if (studentData.isMale)
                    $('#male').prop("checked", true);
                else
                    $('#female').prop("checked", true);
                
                $('#rollNo').val(studentData.rollNo);
                $('#rollNo').attr('disabled', 'disabled');
                $('#name').val(studentData.name);
                $('#age').val(studentData.age);
                $('#email').val(studentData.email);
                $('#date').val(studentData.date);
                $('#fillForm').show();
                $('#error').hide();
                $('#studentList').hide();
                $("#postData").hide();
                $("#submitData").text("Update");
            },
            error: function(){
                showError();
            }
        });
    }

    function getData(){
        $.ajax({
            method:'GET',
            url: serverUrl,
            beforeSend: startSpinner(),
            success:function(studentData) {
                stopSpinner();
                displayStudentDetails(studentData);
            },
            error: function(){
                showError();
            }
        });
    }

    function postData(){

        $.ajax({
            type:'POST',
            data: takeData(),
            beforeSend: startSpinner(),
            url: serverUrl,
            error: function(){
                showError();
            },
            complete: getData()
        });
    }

    function updateData(){
        var data = takeData();

        $.ajax({
            method:'PUT',
            data: data,
            beforeSend: startSpinner(),
            complete: getData(),
            url: serverUrl+'/'+data.rollNo,
            success:function(studentData) {
                clearFormData();
                getData();
            },
            error: function(){
                showError();
            }
        });
    }

    function deleteData(current){

        $.ajax({
            type:'DELETE',
            url: serverUrl+'/'+$(current).val(),
            beforeSend: startSpinner(),
            success:function(studentData) {
                getData();
            },
            error: function(){
                showError();
            }
        });
    }

    function displayStudentDetails(studentData){
        
        $('#studentList').show();
        $('#fillForm').hide();
        $('#student').html('');

        $.each(studentData, function(i,student){
            var gender = "Female";
            if(student.isMale)
                gender = "Male";

            $('#student').html(
                $('#student').html()+
                '<tr class="info">'+
                '<td>'+student.rollNo+'</td>'+
                '<td>'+student.name+'</td>'+
                '<td>'+student.age+'</td>'+
                '<td>'+student.email+'</td>'+
                '<td>'+student.date+'</td>'+
                '<td>'+gender+'</td>'+
                '<td>'+
                    '<button class="delete" value="'+student.rollNo+'">Delete</button>'+
                    '<button class="update" value="'+student.rollNo+'">Update</button>'+
                '</td>'+
                '</tr>'
            );
        });

        $(".delete").click(function(){
            deleteData(this);
        });

        $(".update").click(function(){
            getSingleData(this);
        });
    }

    function clearFormData(buttonText) {
        var text = 'Submit';
        if (buttonText == 'Update') {
            text = "Update";
        }

        $('#rollNo').removeAttr("disabled");
        $('#rollNo').val("");
        $('#name').val("");
        $('#age').val("");
        $('#email').val("");
        $('#date').val("");
        $('#male').prop("checked", false);
        $('#female').prop("checked", false);
        $("#submitData").text(text);
        $('.form-element').removeClass('highlight-error');
    }

    function isValidData(student) {
        var errorStatus = 1;

        $('.form-element').removeClass('highlight-error');

        if (student.rollNo == "" || isNaN(student.rollNo) || student.rollNo < 1) {
            $('#rollNo').addClass('highlight-error');
            errorStatus = 0;
        }

        if (student.age == "" || isNaN(student.age) || student.age < 1) {
            $('#age').addClass('highlight-error');
            errorStatus = 0;
        }

        if (student.name == "" || !isNaN(student.name)) {
            $('#name').addClass('highlight-error');
            errorStatus = 0;
        }
        if (student.email == "") {
            $('#email').addClass('highlight-error');
            errorStatus = 0;
        }
        if (student.isMale == undefined) {
            $('.gender').addClass('highlight-error');
            errorStatus = 0;
        }
        if (!Date.parse($("#date").val())) {
            $('#date').addClass('highlight-error');
            errorStatus = 0;
        }
        return errorStatus;
    }

    $("#postData").click(function(){
        $('#error').hide();
        $("#postData").hide();
        $('#studentList').hide();
        $('#fillForm').show();
    });

    $("#submitData").click(function(){

        var validationStatus = isValidData(new takeData());

        if (validationStatus == 1 && $(this).text() == 'Update') {
            updateData();
            $('#fillForm').hide();
            getData();
        }
        if (validationStatus == 1 && $(this).text() == 'Submit') {
            postData();
            $('#fillForm').hide();
            getData();
        }
        if (validationStatus == 0 && $(this).text() == 'Update') {
            $('#error').html('<p>Invalid Data</p>');

        }
        if (validationStatus == 0 && $(this).text() == 'Submit') {
            $('#error').html('<p>Invalid Data</p>');
        }
    });

    function showError(){
        $('#error').show();
        $('#studentList').hide();
        $('#fillForm').hide();
        $('#error').html('<p>An error has occurred</p>');
    }

    function startSpinner(){
        $('#spinner').show();
        $("#postData").hide();
    }

    function stopSpinner(){
        $('#spinner').hide();
        $("#postData").show();
    }

    getData();

    //setTimeout(getData, 5000);

});
*/