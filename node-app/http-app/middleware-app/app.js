const filters = require('./filters');
const express = require('express');
const app = express();


filters(app);

const port  = 8080;
app.listen(port, ()=> console.log('App listening on port '+port));
app.get('/', (req, res) => {
    res.send('This is middleware');
    res.end();
});