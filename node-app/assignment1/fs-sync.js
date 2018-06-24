let fs = require("fs");

var data = fs.readFileSync('file.txt');
console.log("Synchronous read: " + data.toString());

console.log("End of script...");