class Validation {

    validateName(name) {
        if (name == '' || name == undefined)
            throw new Error("\nName can't be blank");
    }

    validatePassword(password) {
        if (password == '' || password == undefined)
            throw new Error("\nPassword can't be blank");
        
        if (password.length < 8 || password.length > 15)
            throw new Error("\nPassword must be of 8 to 15 character.");
    }

    validateAmount(amount) {
        if (isNaN(amount))
            throw { name: Error, message: '\nInvalid amount' }
        
    }

    validateType(type){
        if (type == '' || type == undefined)
            throw new Error("\nType can't be blank");
        
        if (type.length != 1)
            throw new Error('Invalid type of transaction');

    }

}

module.exports = Validation;