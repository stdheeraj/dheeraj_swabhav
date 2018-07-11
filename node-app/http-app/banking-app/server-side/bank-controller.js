require('express-group-routes');
const BankService = require('./bank-service');
let bankService = new BankService();

const bankController = function(app){
    app.group("/api/v1/account", (router) => {
        router.get("/:name/passbook", getPassbook)
                .post("/login", login)
                .post("/register", createAccount)
                .post("/:name/transaction", doTransaction)
    });
}

function login(req, res){
    try {
        bankService.authenticateCustomer(req.body.name)
                    .then((password) => {
                        let isValidCustomer = false;
                        if(password.length!=0 && req.body.password == password)
                            isValidCustomer = true;
                        res.send(isValidCustomer);
                        res.end();
                    })
                    .catch((error) => {
                        res.json(error);
                        res.end();
                    });
    } catch (error) {
        res.json(error);
        res.end();
    }
}

function getPassbook(req, res){
    try {
        bankService.getPassbookData(req.params.name)
                    .then((result) => {
                        res.json(result);
                        res.end();
                    })
                    .catch((error) => {
                        res.json(error);
                        res.end();
                    });
    } catch (error) {
        res.json(error);
        res.end();
    }
}

function createAccount(req, res){
    try {
        bankService.addCustomer(req.body)
                    .then((result) => {
                        if(result.affectedRows == 0)
                            res.send(req.body.name+" is not created.");
                        else
                            res.send('Account created successfully');
                        res.end();
                    })
                    .catch((error) => {
                        res.json(error);
                        res.end();
                    });
    } catch (error) {
        res.send(error);
        res.end();
    }
}

function doTransaction(req, res){
    try {
        bankService.doTransaction(req.params.name, req.body)
                    .then((result) => {
                        res.json(result);
                        res.end();
                    })
                    .catch((error) => {
                        res.json(error);
                        res.end();
                    });
    } catch (error) {
        res.send(error.message);
        res.end();
    }
}

module.exports = bankController;