(function(){

    document.getElementById("slider").addEventListener("input", getSlider);

    function getSlider() {

    var sliderValue = document.getElementById("slider").value;

    document.getElementById("buttons").innerHTML = "";

    for(i=1; i<=sliderValue; i++){
       document.getElementById("buttons").innerHTML += '<button id=' + i +' onclick="console.clear();console.log(this.id)">'+i+'</button>';
    }
    }

}())