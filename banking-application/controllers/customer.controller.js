const Services = require('../service/index.service');

const CustomerService = Services.getCustomerService();

const CustomerController = () => {

    let obj = {};

    obj.registerCustomer = (req, res) => {
        CustomerService.createCustomer(req.body)
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