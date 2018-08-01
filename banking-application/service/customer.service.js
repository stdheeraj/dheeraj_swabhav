const Customer = require('../repository/models/customer.model');

function CustomerService() {
    let obj = {};

    obj.getAllCustomer = () => {
        Customer.find({}, (err, result) => {
            if (err)
                console.log(err);
            if (result)
                console.log(result);
        })
    }

    obj.createCustomer = (customerObj) => {
        return new Promise((resolve, reject) => {
            let newCustomer = new Customer({
                "Login": customerObj.Login,
                "ContactDetail": customerObj.ContactDetail
            });
            //newCustomer.Login = customerObj.Login;
            newCustomer.save((err, result) => {
                if (err)
                    reject(err);
                else
                    resolve(result);
            });
        });
    }

    return obj;
}

module.exports = CustomerService;