const config = require('./config/config');
const app = require('./config/express');

app.listen(config.app.port, function() {
	console.log('App is running on http://localhost:' + config.app.port);
});