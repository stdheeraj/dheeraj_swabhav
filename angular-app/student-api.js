angular.module('studentAPI', [])
    .controller('studentAPICtrl', function ($scope, dataService) {

        $scope.createStudent = function (student) {
            dataService.postData(student);
            $scope.student = {};
            $scope.getStudent();
        }

        $scope.updateStudent = function (rollNo) {
            dataService.getSingleData(rollNo)
            .then(function (student) {
                $scope.student = student.data;
                $scope.student.date = new Date(student.data.date);
            });

        }

        $scope.update = function (student) {
            dataService.updateData(student);
        }

        $scope.deleteStudent = function (rollNo) {
            dataService.deleteData(rollNo);
            $scope.getStudent();
        }

        $scope.getStudent = function () {
            dataService.getData()
            .then(function (students) {
                $scope.students = students.data;
            });
        }

        $scope.getStudent();
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