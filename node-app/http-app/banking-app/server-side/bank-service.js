//const uuidv1 = require('uuid/v1');
const Validation = require('./validation');
const Database = require('./repository');

const validation = new Validation();
const db = new Database();
//const contacts = "contacts";

class BankService {

    addCustomer(customerObj, cb) {
        //console.log('inside add');
        validation.validateName(customerObj.name);
        validation.validatePassword(customerObj.password);
        validation.validateAmount(customerObj.balance);

        db.postCustomerData(customerObj)
            .then((result) => cb(null, result))
            .catch((error) => cb(error.sqlMessage));
    }

    authenticateCustomer(customerCredential, cb) {
        //console.log('inside add');
        db.getCustomerPassword(customerCredential.name)
            .then((password) => {
                let isValidCustomer = false;
                if(password.length!=0 && customerCredential.password == password)
                    isValidCustomer = true;
                cb(isValidCustomer);
            })
            .catch((error) => cb(error));
    }

    getPassbookData(customerName) {
        //console.log('inside add');
        validation.validateName(customerName);
        // db.getCustomerTransaction(customerName)
        //     .then((result) => cb(result))
        //     .catch((error) => cb(error));

        return db.getCustomerTransaction(customerName);
    }

    doTransaction(name, transactionObj, cb) {
        //console.log('inside add');
        validation.validateName(name);
        validation.validateAmount(transactionObj.amount);
        validation.validateType(transactionObj.type);

        db.doTransaction(name, transactionObj)
            .then((result) => cb(result))
            .catch((error) => cb(error));
    }

}

module.exports = BankService;