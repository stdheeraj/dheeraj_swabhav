let fs = require('fs');




  fs.writeFile('file.txt', 'This is Node File System', (err) => {
    if (err) throw err;
    console.log('Replaced!');
    fs.readFile('file.txt', (err, data) => {
  if (err) {
     return console.error(err);
  }
  console.log("Asynchronous read: " + data.toString());
});
  });

/*
fs.readFile('file.txt', (err, data) => {
  if (err) {
     return console.error(err);
  }
  console.log("Data: " + data.toString());
});
*/


console.log("file info!");
fs.stat('file.txt', (err, stats) => {
  if (err) {
    return console.error(err);
  }
  console.log(stats);
  console.log("Got file info successfully!");

  console.log("isFile ? " + stats.isFile());
  console.log("isDirectory ? " + stats.isDirectory());
  console.log("isBlockDevice ? " + stats.isBlockDevice());
  console.log("isCharacterDevice ? " + stats.isCharacterDevice());
  console.log("isSymbolicLink ? " + stats.isSymbolicLink());
  console.log("isFIFO ? " + stats.isFIFO());
  console.log("isSocket ? " + stats.isSocket());

});

fs.open('file.txt', 'r+', function (err, fd) {

  if (err) {
    return console.error(err);
  }
  console.log("File opened successfully!");

  fs.truncate(fd, 14, function(err){
    if (err){
       console.log(err);
    }
  });

  console.log("Reading file");
  let buf = new Buffer(1024);
  fs.read(fd, buf, 0, buf.length, 0, function (err, bytes) {
    if (err) {
      console.log(err);
    }
    console.log(bytes + " bytes read");

    if (bytes > 0) {
      console.log(buf.slice(0, bytes).toString());
    }
  });


  fs.close(fd, function (err) {
    if (err) {
      console.log(err);
    }
    console.log("File closed successfully.");
  });
});

/*
console.log('append to file')
fs.appendFile('file.txt', 'Hello Dheeraj!', (err) => {
  if (err) throw err;
  console.log(' file updated!');
});
*/
