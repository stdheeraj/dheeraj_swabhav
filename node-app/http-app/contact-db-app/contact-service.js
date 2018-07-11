const uuidv1 = require('uuid/v1');
const Database = require('./repository');
const db = new Database();
const contacts = "contacts";

class ContactService {

    add(contactObj, cb) {
        //console.log('inside add');
        this.validateName(contactObj.name);
        this.validateNumber(contactObj.mobileNumber);
        this.validateEmail(contactObj.email);

        db.fireQuery('INSERT INTO '+contacts+' (ID, NAME, MOBILENUMBER, EMAIL) VALUES("' + uuidv1() + '", "' +
            contactObj.name + '", "' +
            contactObj.mobileNumber + '", "' +
            contactObj.email + '")')
            .then((result) => cb(result))
            .catch((error) => cb(error));
    }

    search(search, cb) {

        db.fireQuery('SELECT * FROM '+contacts+' WHERE NAME = "' + search
            + '" OR MOBILENUMBER = "' + search + '" OR EMAIL = "' + search + '"')
            .then((result) => cb(result))
            .catch((error) => cb(error));

    }

    remove(removeContact, cb) {

        db.fireQuery('DELETE FROM '+contacts+' WHERE NAME = "' + removeContact
            + '" OR MOBILENUMBER = "' + removeContact + '" OR EMAIL = "' + removeContact + '"')
            .then((result) => cb(result))
            .catch((error) => cb(error));

    }

    update(updateContact, contactObj, cb) {

        this.validateName(contactObj.name);
        this.validateNumber(contactObj.mobileNumber);
        this.validateEmail(contactObj.email);

        db.fireQuery('UPDATE '+contacts +
            ' SET NAME = "' + contactObj.name + '", ' +
            'MOBILENUMBER = "' + contactObj.mobileNumber + '", ' +
            'EMAIL = "' + contactObj.email + '" ' +
            ' WHERE NAME = "' + updateContact
            + '" OR MOBILENUMBER = "' + updateContact + '" OR EMAIL = "' + updateContact + '"')
            .then((result) => cb(result))
            .catch((error) => cb(error));
    }

    displayAllContact(cb) {

        //db.fireQuery('SELECT * FROM '+contacts)
        db.demo()
            .then((result) => cb(result))
            .catch((error) => cb(error));

    }

    validateName(name) {
        if (name == '' || name == undefined)
            throw new Error("\nName can't be blank");
    }

    validateNumber(number) {
        if (isNaN(number) || number.toString().length != 10)
            throw { name: Error, message: 'Invalid mobile number' }
    }

    validateEmail(email) {
        if (email == '' || email == undefined)
            throw new Error("\nEmail can't be blank");
    }

}

module.exports = ContactService;