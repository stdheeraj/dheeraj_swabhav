var con = require('./connection')
var mongoose = con.getConnection();

mongoose.then(r=>console.log()).catch();
console.log(mongoose.Schema);


var obj = require('./temp2');

console.log(obj);
