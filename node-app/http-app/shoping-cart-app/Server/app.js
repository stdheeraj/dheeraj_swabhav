const express = require('express');
const bankController = require('./bank-controller');
const bodyParser = require('body-parser');

const app = express();

app.use(bodyParser.json())
app.use(bodyParser.urlencoded({
  extended: true
}));

let port = 8080;
app.listen(port, () => console.log('App is running on port '+port));

bankController(app);