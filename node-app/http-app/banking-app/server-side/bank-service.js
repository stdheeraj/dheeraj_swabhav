const Validation = require('./validation');
const Database = require('./repository');

const validation = new Validation();
const db = new Database();

class BankService {

    addCustomer(customerObj) {
        validation.validateName(customerObj.name);
        validation.validatePassword(customerObj.password);
        validation.validateAmount(customerObj.balance);

        return db.postCustomerData(customerObj);
    }

    authenticateCustomer(name) {
        return db.getCustomerPassword(name);
    }

    getPassbookData(customerName) {
        validation.validateName(customerName);
        return db.getCustomerTransaction(customerName);
    }

    doTransaction(name, transactionObj, cb) {
        validation.validateName(name);
        validation.validateAmount(transactionObj.amount);
        validation.validateType(transactionObj.type);

        return db.doTransaction(name, transactionObj);
    }

}

module.exports = BankService;