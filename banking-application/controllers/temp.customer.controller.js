const Services = require('../service/index.service');
const ErrorHandler = require('./error.handler');
const TempCustomerService = Services.getTempCustomerService();
const CustomerService = Services.getCustomerService();
const MailService = Services.getMailService();

const TempCustomerController = () => {

    let obj = {};

    obj.registerCustomer = (req, res, next) => {
        TempCustomerService.createTempCustomer(req.body)
            .then(customerInfo => MailService.sendMail(customerInfo))
            .then(result => {
                req.status = 201;
                req.message = 'Verification link is sent to your email. Click on that link to verify your email id.';
                next();
            })
            .catch(error => {
                //console.log('error');
                let errorResponse = ErrorHandler(error);
                req.status = errorResponse.status;
                req.message = errorResponse.message;
                next();
            });
    }

    obj.verifyCustomer = (req, res, next) => {
        //console.log(req.query);
        TempCustomerService.verifyCustomer(req.query.emailID)
            .then(customerObj => {
                //console.log("verify:"+customerObj);
                if (customerObj && customerObj.Token === req.query.token) {
                    CustomerService.createCustomer(customerObj)
                        .then(customer => TempCustomerService.deleteTempCustomer(customer.UserName))
                        .then(result => {
                            //console.log("after deleting : "+result)
                            req.status = 201;
                            req.message = 'Congratulation! You have successfully registered.'+
                                            ' Now login to your account to fill your profile details.';
                            next();
                        })
                        .catch(error => {
                            let errorResponse = ErrorHandler(error);
                            if(errorResponse.status === 11000){
                                TempCustomerService.deleteTempCustomer(customerObj.UserName)
                                    .then(result => {
                                        req.status = 200;
                                        req.message = 'You are already verified. Now logon to bank app using your account credential.';
                                        next();
                                    })
                                    .catch(error => {
                                        let errorResponse = ErrorHandler(error);
                                        req.status = errorResponse.status;
                                        req.message = errorResponse.message;
                                        next();
                                    });

                            } else {
                                req.status = errorResponse.status;
                                req.message = errorResponse.message;
                                next();
                            }
                        });
                } else if(!customerObj) {
                    CustomerService.getCustomerByEmailId(req.query.emailID)
                        .then(result =>{
                            req.status = 200;
                            req.message = 'You are already verified. Now logon to bank app using your account credential.';

                            if(!result)
                                req.message = 'You are not valid user. Please register yourself from our bank app.';

                            next();
                        })
                        .catch(error => {
                            let errorResponse = ErrorHandler(error);
                            req.status = errorResponse.status;
                            req.message = errorResponse.message;
                            next();
                        });
                }
                else {
                    req.status = 200;
                    req.message = 'You are not valid user. Please register yourself from our bank app.';
                    next();
                }
            })
            .catch(error => {
                let errorResponse = ErrorHandler(error);
                req.status = errorResponse.status;
                req.message = errorResponse.message;
                next();
            });
    }

    return obj;

}

module.exports = TempCustomerController();