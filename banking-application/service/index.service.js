const AdminService = require('./admin.service');
const TempCustomerService = require('./temp.customer.service');
const CustomerService = require('./customer.service');
const TransactionHistoryService = require('./transaction.history.service');
const AppointmentService = require('./appointment.service');
const MailService = require('./mail.service');

function Services() {
    let obj = {};

    obj.getAdminService = () => {
        return AdminService();
    }

    obj.getCustomerService = () => {
        return CustomerService();
    }

    obj.getTempCustomerService = () => {
        return TempCustomerService();
    }

    obj.getTransactionHistoryService = () => {
        return TransactionHistoryService();
    }

    obj.getAppointmentService = () => {
        return AppointmentService();
    }

    obj.getMailService = () => {
        return MailService();
    }

    return obj;
}

module.exports = Services();