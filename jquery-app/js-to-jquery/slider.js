$('document').ready(function () {

    $('#slider').slider({
        range: "max",
        min: 0,
        max: 100,
        value: 0,
        slide: getSlider
    });

    function getSlider(event, ui) {
        var sliderValue = ui.value;
        $('#buttons').html('');
        for (i = 1; i <= sliderValue; i++)
            $('#buttons').html($('#buttons').html() + '<button id=' + i + ' onclick="console.clear();console.log(this.id)">' + i + '</button>');
    }

});