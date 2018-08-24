const config = {
 app: {
   port: process.env.PORT || 8080
 },
 db: {
   host: 'ds259711.mlab.com:59711',
   username:'root',
   password: 'root123',
   name: 'bank-db'
 },
 mail: {
  service: 'gmail',
  admin: 'cdheeraj76@gmail.com',
  password: 'password'
 },
 domain:{
   name: 'http://localhost:8080'
 }
};

module.exports = config;