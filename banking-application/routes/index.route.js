const express = require('express');
const adminRoutes = require('./admin.route');
const customerRoutes = require('./customer.route');
const transactionHistoryRoutes = require('./transaction.history.route');
const appointmentRoutes = require('./appointment.route');

const router = express.Router();

//router.route('/customer').get((req, res)=>res.send('hello'))
// router.use('/admin', adminRoutes);
// //console.log(customerRoutes);
router.use('/customer', customerRoutes);

// router.use('/passbook', transactionHistoryRoutes);
// router.use('/appointment', appointmentRoutes);

router.use(function(req, res){
    console.log(req.status +' : '+req.message);
    res.status(req.status).json(req.message);
    res.end();
});
module.exports = router;