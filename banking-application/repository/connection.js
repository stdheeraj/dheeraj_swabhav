const mongoose = require('mongoose');
const config = require('../config/config');

function MongooseConnection() {
    let db = 'mongodb://' + config.db.username + ':' + config.db.password + '@' + config.db.host + '/' + config.db.name;

    mongoose.connect(db, { useNewUrlParser: true }, (err, result) => {
        if (err)
            console.log('Database is not running.\n Start database !!!');
        if (result)
            console.log('Database running...');
    });

    return mongoose;
}

const Connection = function () {
    console.log('inside connection');
    var con = null;
    
    var obj = {};
    obj.getConnection = function () {
        if (con == null || con.connection.readyState===0)
            con = new MongooseConnection();
        return con;
    }
    return obj;
}

module.exports = Connection();