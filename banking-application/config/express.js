const express = require('express');
const bodyParser = require('body-parser');
const routes = require('../routes/index.route');

const app = express();

app.use(bodyParser.json())

app.use(bodyParser.urlencoded({
  extended: true
}));

app.use(function(req, res, next){
  res.header("Access-Control-Allow-Origin", "*");
  res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
  next();
});

app.use('/api/v1/bank', routes);

// app.get('/',(req, res)=>{
//   res.send('hello');
// })

module.exports = app;