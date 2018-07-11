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
        bankService.authenticateCustomer(req.body ,(result)=>{
            res.send(result);
            res.end();
        });
    } catch (error) {
        res.send(error);
        res.end();
    }
}

function getPassbook(req, res){
    try {
        bankService.getPassbookData(req.params.name)
                    .then((result) => {
                        if(result.length == 0)
                            res.send('No transaction found.')
                        else
                            res.json(result);
                        res.end();
                    })
                    .catch((error) => {throw error});
    } catch (error) {
        res.send(error.message);
        res.end();
    }
}

// function getPassbook(req, res){
//     try {
//         bankService.getPassbookData(req.params.name, (result)=>{
//             if(result.length == 0)
//                 res.send('No transaction found.')
//             else
//                 res.json(result);
//             res.end();
//         });
//     } catch (error) {
//         res.send(error.message);
//         res.end();
//     }
// }

function createAccount(req, res){
    try {
        //bankService.add(req.body);
        bankService.addCustomer(req.body, (error, result)=>{
            if(error)
                throw new Error(error);
            
            if(result.affectedRows == 0)
                res.send(req.body.name+" is not created.");
            else
                res.send('Account created successfully');
            
            res.end();
        });
    } catch (error) {
        res.send(error.message);
        res.end();
    }
}

function doTransaction(req, res){
    try {
        //bankService.add(req.body);
        bankService.doTransaction(req.params.name, req.body, (result)=>{
            //console.log(result)
            res.send(result);
            res.end();
        });
    } catch (error) {
        res.send(error.message);
        res.end();
    }
}

module.exports = bankController;