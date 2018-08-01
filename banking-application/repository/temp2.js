var con = require('./connection')
con.getConnection();

module.exports = {

  sayHello:function() {
     console.log('sayhello');
  }

}
