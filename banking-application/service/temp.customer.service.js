const TempCustomer = require('../repository/models/temp.customer.model');
const uuid = require('uuid/v1');

function TempCustomerService() {
    let obj = {};

    obj.getAllCustomer = () => {
        TempCustomer.find({}, (err, result) => {
            if (err)
                console.log(err);
            if (result)
                console.log(result);
        });
    }

    obj.createTempCustomer = (customerObj) => {
        return new Promise((resolve, reject) => {
            let newTempCustomer = new TempCustomer({
                "UserName": customerObj.UserName,
                "Password": customerObj.Password,
                "EmailID": customerObj.EmailID,
                "Token": uuid()
            });
            newTempCustomer.save((err, result) => {
                if (err)
                    reject(err);
                else
                    resolve(result);
            });
        });
    }

    obj.verifyCustomer = (customerEmailID) => {
        //console.log(customerEmailID);
        return new Promise((resolve, reject) => {
            TempCustomer.findOne({EmailID : customerEmailID}, (err, result) => {
                //console.log(result);
                if (err)
                    reject(err);
                else
                    resolve(result);
            });
        });
    }

    obj.deleteTempCustomer = (customerName) => {
        return new Promise((resolve, reject) => {
            TempCustomer.findOneAndRemove({UserName:customerName}, (err, result) => {
                //console.log(result+' Error:'+err);
                if (err)
                    reject(err);
                else
                    resolve(result);
            });
        });
    }

    return obj;
}

module.exports = TempCustomerService;