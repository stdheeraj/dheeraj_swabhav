const TempCustomerController = (error) => {
    let err = {};

    if(error.name=='ValidationError'){ 
        err.status = 205;
        err.message = 'Validation Error';
        return err; 
    }

    err.status = error.code;
    err.message = 'Unknown error';
   
    return err;
}

module.exports = TempCustomerController;