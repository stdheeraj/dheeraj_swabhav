const mysql = require('mysql');
const async = require('async');
//const uuidv1 = require('uuid/v1');

const fireQuery = (query, value) => {
    const connection = mysql.createConnection({
        host: 'localhost',
        user: 'root',
        password: 'root',
        database: 'bank-db'
    });

    return new Promise((resolve, reject) => {
        async.waterfall([
            (callback) => connection.connect((err) => callback(err)),
            (callback) => connection.query(query, value, (err, status) => callback(err, status))
        ],
            (error, results) => {
                if (error)
                    reject(error.sqlMessage);
                else
                    resolve(results);

                connection.end();
            });
    });
}

class Connection {

    getCustomerPassword(name) {
        return fireQuery('SELECT PASSWORD FROM bank_master WHERE NAME = ?', name);
    }

    getCustomerTransaction(name) {
        return fireQuery('SELECT BM.NAME, BM.BALANCE, BT.AMOUNT, BT.TYPE, BT.DATE ' +
            'FROM bank_master BM LEFT OUTER JOIN bank_transaction BT ' +
            'ON BM.NAME = BT.NAME ' +
            'WHERE BM.NAME = ?', name);
    }

    postCustomerData(data) {
        let bmData = [data.name, data.password, data.balance];
        return fireQuery('INSERT INTO bank_master (NAME, PASSWORD, BALANCE) VALUES (?)', [bmData]);
    }

    doTransaction(name, transactionObj) {
        const connection = mysql.createConnection({
            host: 'localhost',
            user: 'root',
            password: 'root',
            database: 'bank-db'
        });

        return new Promise((resolve, reject) => {

            async.waterfall([
                (callback) => connection.connect((err) => callback(err)),
                (callback) => connection.beginTransaction((err) => callback(err)),
                (callback) => {

                    let sign = "-";

                    if (transactionObj.type == "D")
                        sign = "+";

                    connection.query('UPDATE bank_master SET BALANCE = BALANCE ' + sign + ' ? WHERE NAME = ?', [transactionObj.amount, name],
                        (err, status) => callback(err, status));

                },
                (status, callback) => {
                    let transactionData = [name, transactionObj.amount, transactionObj.type, new Date()];
                    connection.query('INSERT INTO bank_transaction (NAME, AMOUNT, TYPE, DATE) VALUES (?)', [transactionData],
                        (err, status) => callback(err, status));
                },
                (status, callback) => connection.commit((err) => callback(err))
            ],
                (err) => {
                    if (err)
                        connection.rollback(() => reject(err.sqlMessage));
                    else
                        resolve("transaction completed");
                    connection.end();
                });
        });

    }

}

module.exports = Connection;