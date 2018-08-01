const config = {
 app: {
   port: process.env.PORT || 8080
 },
 db: {
   host: 'ds259711.mlab.com:59711',
   username:'root',
   password: 'root123',
   name: 'bank-db'
 }
};

module.exports = config;