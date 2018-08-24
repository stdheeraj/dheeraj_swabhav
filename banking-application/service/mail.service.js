const nodemailer = require('nodemailer');
const config = require('../config/config');
const uuid = require('uuid/v1');

const transporter = nodemailer.createTransport({
    service: config.mail.service,
    auth: {
        user: config.mail.admin,
        pass: config.mail.password
    },
    tls: {
        rejectUnauthorized: false
    }
});

function MailService() {

    let obj = {};

    obj.sendMail = (customer) => {
        return new Promise((resolve, reject) => {
            let mailOptions = {
                from: config.mail.admin,
                to: customer.EmailID,
                subject: 'Email verification',
                html: 'Dear customer,<br><br>' +
                    'Thanks for signing up for bank account. ' +
                    'Verify your email by clicking the link below.<br><br>' +
                    config.domain.name+'/api/v1/bank/customer/verify?'+
                    'emailID=' + customer.EmailID+'&'+
                    'token=' + customer.Token
            };

            transporter.sendMail(mailOptions, function (err, result) {
                if (err)
                    reject(err);
                else
                    resolve(result);
                transporter.close();
            });
        });
    }

    return obj;
}

module.exports = MailService;