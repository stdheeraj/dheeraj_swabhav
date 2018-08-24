const express = require('express');
const tempCustomerController = require('../controllers/temp.customer.controller');
const customerController = require('../controllers/customer.controller');

const router = express.Router();

router.route('/register')
        .get((req, res)=>res.send('hello'))
        .post(tempCustomerController.registerCustomer);

router.route('/verify')
        .get(tempCustomerController.verifyCustomer);
// router.route('/:');
// router.route('/passbook');
// router.route('/appointment');

module.exports = router;