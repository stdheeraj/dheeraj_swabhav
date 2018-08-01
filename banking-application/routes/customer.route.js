const express = require('express');
const customerController = require('../controllers/customer.controller');

const router = express.Router();

router.route('/register')
        .get((req, res)=>res.send('hello'))
        .post(customerController.registerCustomer);

// router.route('/:');
// router.route('/passbook');
// router.route('/appointment');

module.exports = router;