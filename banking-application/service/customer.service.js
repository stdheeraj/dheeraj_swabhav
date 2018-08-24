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

    obj.getCustomerByEmailId = (customerEmailID) => {
        return new Promise((resolve, reject) => {
            Customer.findOne({EmailID : customerEmailID}, (err, result) => {
                //console.log(result);
                if (err)
                    reject(err);
                else
                    resolve(result);
            });
        });
    }

    obj.createCustomer = (customerObj) => {
        return new Promise((resolve, reject) => {
            let newCustomer = new Customer({
                "Login": {
                    "UserName": customerObj.UserName,
                    "Password": customerObj.Password
                },
                "ContactDetail": {
                    "EmailID": customerObj.EmailID
                }
            });
            
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