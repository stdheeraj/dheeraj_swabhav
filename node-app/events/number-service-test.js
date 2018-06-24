const NumberService = require('./number-service.js');

const numberService = new NumberService();

let e = numberService.getEvents();

e.on('success', (n) => console.log("Successful : number = "+n))
.on('failure', (n) => console.log("Failure : number = "+n));

numberService.getNumber();
