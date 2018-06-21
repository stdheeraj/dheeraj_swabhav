let dataSerive = require('./dataService');

let data = dataSerive().getDataSync();
console.log("data sync : "+data);

dataSerive().getData((d) => console.log(d));

console.log('end of data service');