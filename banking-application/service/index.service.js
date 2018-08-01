const AdminService = require('./admin.service');
const CustomerService = require('./customer.service');
const TransactionHistoryService = require('./transaction.history.service');
const AppointmentService = require('./appointment.service');

function Services() {
    let obj = {};

    obj.getAdminService = () => {
        return AdminService();
    }

    obj.getCustomerService = () => {
        return CustomerService();
    }

    obj.getTransactionHistoryService = () => {
        return TransactionHistoryService();
    }

    obj.getAppointmentService = () => {
        return AppointmentService();
    }

    return obj;
}

module.exports = Services();