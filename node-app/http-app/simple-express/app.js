const express = require('express');
const app = express();

const port  = 8080;

app.listen(port, ()=> console.log('App listening on port '+port));

app.use(express.static(__dirname+'/public'));

app.get('/:file', (req, res) => res.sendFile(__dirname+ '/public/'+req.param.file));