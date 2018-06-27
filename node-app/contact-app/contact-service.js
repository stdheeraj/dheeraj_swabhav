const fs = require('fs');
const uuidv1 = require('uuid/v1');
const readlineSync = require('readline-sync');

class ContactService {

    add() {
        //console.log('inside add')
        let name = readlineSync.question('Enter your name : ');
        this.validateName(name);
        
        let mobileNumber = readlineSync.questionInt('Enter your phone number : ', {
                                limitMessage: 'Sorry, $<lastInput> is incorrect mobile number.'});
        this.validateNumber(mobileNumber);
        
        let email = readlineSync.questionEMail('Enter your email : ', {
                                limitMessage: 'Sorry, $<lastInput> is incorrect email.'});
        this.validateEmail(email);
        
        let data = fs.readFileSync('contacts.json');

        let contacts = [];
        if (data.length != 0){
            contacts = JSON.parse(data);
            contacts.forEach(contact => {
                if (contact.name.includes(name) || contact.mobileNumber.toString().includes(mobileNumber)
                    || contact.email.toString().includes(email))
                            throw new Error('This contact already exist.');
            });
        }

        contacts.push({
            id : uuidv1(),
            name : name, 
            mobileNumber :mobileNumber, 
            email : email
        });
        
        fs.writeFileSync('contacts.json', JSON.stringify(contacts));
        console.log('\nContact added successfully');
    }

    search() {
        //console.log('inside search')
        let contactData = fs.readFileSync('contacts.json');

        if (contactData.length == 0)
            throw new Error('Nothing to search ')

        let search = readlineSync.question('Enter name/contact/email : ');

        if (!search)
            throw new Error('Please, Enter name or mobile number or email to search...')

        let result = [];

        JSON.parse(contactData).forEach(contact => {
            if (contact.name.includes(search) || contact.mobileNumber.toString().includes(search)
                || contact.email.toString().includes(search))
                        result.push(contact);
        });

        if (result.length == 0)
            throw new Error('No Contact Available.');

        result.forEach(contact => {
            console.log('\nName          : ' + contact.name);
            console.log('Mobile Number : ' + contact.mobileNumber);
            console.log('Email         : ' + contact.email);
        });
        console.log("\nTotal contact found : " + result.length);
    }

    remove() {
        //console.log('inside remove')
        let contactData = fs.readFileSync('contacts.json');

        if (contactData.length == 0)
            throw new Error('Nothing to remove.')

        let contacts = JSON.parse(contactData);

        let removeContact = readlineSync.question('Enter name/contact/email : ');
        if (!removeContact)
            throw new Error('Enter name or mobile number or email to remove...')

        let deletedContact = [];
        for (let i in contacts) {
            if (contacts[i].name.includes(removeContact) ||
                contacts[i].mobileNumber.toString().includes(removeContact) ||
                contacts[i].email.toString().includes(removeContact))
                    deletedContact.push(contacts.splice(i, 1));
        }

        if (deletedContact.length == 0)
            throw new Error('No Contact Available.');

        fs.writeFileSync('contacts.json', JSON.stringify(contacts));

        console.log("\nTotal contact deleted : " + deletedContact.length);
    }

    update() {
        //console.log('inside update')
        let contactData = fs.readFileSync('contacts.json');

        if (contactData.length == 0)
            throw new Error('Nothing to update.')

        let contacts = JSON.parse(contactData);

        let updateContact = readlineSync.question('Enter name/contact/email : ');
        if (!updateContact)
            throw new Error('Enter name or mobile number or email to update...')

        for (let i in contacts) {
            if (contacts[i].name.includes(updateContact) ||
                contacts[i].mobileNumber.toString().includes(updateContact) ||
                contacts[i].email.toString().includes(updateContact)) {
                    console.log('\nName          : ' + contacts[i].name);
                    console.log('Mobile Number : ' + contacts[i].mobileNumber);
                    console.log('Email         : ' + contacts[i].email);

                    console.log('1 : Name');
                    console.log('2 : Mobile Number')
                    console.log('3 : Email')
                    console.log('4 : Cancel')

                    let c = readlineSync.keyIn('Which field you want to update? ', { limit: '$<1-4>' });

                    switch (parseInt(c)) {
                        case 1: let newName = readlineSync.question('Enter new name : ');
                                                this.validateName(newName);
                                                contacts[i].name = newName;
                                                break;
                        case 2: let newNumber = readlineSync.questionInt('Enter new mobile number : ', {
                                                    limitMessage: 'Sorry, $<lastInput> is incorrect mobile number.'
                                                    });
                                                this.validateNumber(newNumber);
                                                contacts[i].mobileNumber = newNumber;
                                                break;
                        case 3: let newEmail = readlineSync.questionEMail('Enter new email : ', {
                                                    limitMessage: 'Sorry, $<lastInput> is incorrect email.'
                                                    });
                                                this.validateEmail(newEmail);
                                                contacts[i].email = newEmail;
                                                break;
                        case 4: break;
                        default: console.log('invalid choosen field.');
                    }
            }
        }

        fs.writeFileSync('contacts.json', JSON.stringify(contacts));
        console.log('\nContact updated successfully');
    }

    display() {
        let contactData = fs.readFileSync('contacts.json');

        if (contactData.length == 0)
            throw new Error('Nothing to display ')

        JSON.parse(contactData).forEach(contact => {
            console.log('\nName          : ' + contact.name);
            console.log('Mobile Number : ' + contact.mobileNumber);
            console.log('Email         : ' + contact.email);
        });

        console.log("\nTotal contact found : " + JSON.parse(contactData).length);
    }

    validateName(name){
        if (name == '' || name == undefined)
            throw new Error("\nName can't be blank");
    }

    validateNumber(number){
        //if (isNaN(number))
        //    throw { name : TypeError , message : 'Invalid mobile number'} // new TypeError('Invalid account number');
        //console.log(number.toString().length)
        if (number.toString().length!=10)
            throw new RangeError("\nInvalid mobile number.");
        //console.log(number.toString().length)

    }

    validateEmail(email){
        if (email == '' || email == undefined)
            throw new Error("\nEmail can't be blank");
    }

}

module.exports = ContactService;