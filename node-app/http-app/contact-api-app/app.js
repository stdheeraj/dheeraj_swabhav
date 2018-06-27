const express = require('express');
require('express-group-routes');
const contactController = require('./contact-controller');
const app = express();
const bodyParser = require('body-parser');

app.use(bodyParser.json())
app.use(bodyParser.urlencoded({
  extended: true
}));

let port = 8080;
app.listen(port, () => console.log('App is running on port '+port));

contactController(app);