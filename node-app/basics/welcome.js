console.log('Hello node');
//console.log(process);
//console.log(process.argv);

process.argv.forEach(function (val, index, array) {
    if(index>1)
        console.log('Hello ' + val);
  });

  var dateTime = new Date(Date.now());
  var hour = dateTime.getHours();

 // console.log(hour);
  if(hour>=4 && hour <12)
    console.log("hello morning");

  if(hour>=12 && hour<=18)
    console.log("hello afternoon");

    if(hour>=18 && hour<=24 || hour <4)
    console.log("hello night");

