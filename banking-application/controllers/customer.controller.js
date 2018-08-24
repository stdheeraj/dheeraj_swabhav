const Services = require('../service/index.service');
const CustomerService = Services.getCustomerService();
const MailService = Services.getMailService();

const CustomerController = () => {

    let obj = {};

    obj.createCustomer = (req, res) => {
        CustomerService.createCustomer(req.body)
            .then(customerInfo => MailService.sendMail(customerInfo))
            .then(result => {
                res.json(result);
                res.end();
            })
            .catch(error => {
                res.json(error);
                res.end();
            });
    }

    obj.verifyCustomer = (req, res) => {
        CustomerService.verifyCustomer(req.query)
            .then(customerInfo => MailService.sendMail(customerInfo))
            .then(result => {
                res.json(result);
                res.end();
            })
            .catch(error => {
                res.json(error);
                res.end();
            });
    }

    return obj;

}

module.exports = CustomerController();