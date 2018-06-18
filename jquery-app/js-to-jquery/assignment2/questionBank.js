$('#submit').hide();
$(document).ready(function () {
    'use strict'

    var questionList = $('#question-list');
    var start = $('#start');
    var submit = $('#submit');
    var result = $('#result');
    var questions = {};
    var questionSequence;
    var score = 0;

    start.click(startTest);
    submit.click(submitTest);

    function startTest() {
        start.hide();
        submit.hide();
        result.hide();

        score = 0;

        $.ajax({
            method: 'GET',
            url: "question-list.json",
            success: function (data) {
                questions = data;
                questionSequence = [];
                getRandomQuestion();
                getQuestionList();
            },
            error: function () {
                result.show();
                $('#result').html('Error while loading questions.');
            }
        });

    }

    function getRandomQuestion() {
        var random = Math.round(Math.random() * 9);
        if (questionSequence.length != 5) {
            if (!questionSequence.includes(random)) {
                questionSequence.push(random);
            }
            getRandomQuestion();
        }
    }

    function getQuestionList() {

        questionList.html('');

        for (var i in questionSequence) {
            var icopy = parseInt(i) + 1;
            questionList.html(questionList.html() +
                '<br>(' + icopy + ')<label>' + questions[questionSequence[i]].question +
                '</label><br>');

            for (var key in questions[questionSequence[i]].options) {
                questionList.html(questionList.html() +
                    '<input ' + 'type="radio" ' +
                    'name="question' + i + '"' +
                    'value="' + key + '" >' +
                    '(' + key + ') ' + questions[questionSequence[i]].options[key] +
                    '<br>');
            }

            questionList.show();
            submit.show();
        }
    }

    function submitTest() {

        submit.hide();
        questionList.hide();
        start.show();
        result.show();

        result.html('<h3 align="center">Your score: ' + percentageCalculator() + '%</h3>');
        start.html("Restart Test");

    }

    function percentageCalculator() {
        for (var i in questionSequence) {
            var selectedAnswer = $('input[name=question' + i + ']:checked').val();
            if (selectedAnswer != undefined && questions[questionSequence[i]].answer == selectedAnswer) {
                score++;
            }
        }

        return (score * 100) / questionSequence.length;
    }
});