const fs = require("fs");
const zlib = require('zlib');

let gzip = zlib.createGzip();

let rStream = fs.createReadStream('world_bank.json');
let wStream = fs.createWriteStream('copy-world_bank.zip');

rStream.pipe(gzip).pipe(wStream);

//rStream.pipe(wStream);
//rStream.pipe(process.stdout);


console.log("End of Program");