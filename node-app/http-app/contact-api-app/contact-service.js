const fs = require('fs');
const uuidv1 = require('uuid/v1');
let contactStore = 'contact-store.json';

class ContactService {

    add(contactObj) {
        this.validateName(contactObj.name);
        this.validateNumber(contactObj.mobileNumber);
        this.validateEmail(contactObj.email);
        
        let data = fs.readFileSync(contactStore);

        let contacts = [];
        if (data.length != 0){
            contacts = JSON.parse(data);
            contacts.forEach(contact => {
                if (contact.name == contactObj.name || 
                    contact.mobileNumber.toString() == contactObj.mobileNumber || 
                    contact.email == contactObj.email)
                            throw new Error('This contact already exist.');
            });
        }

        contacts.push({
            id : uuidv1(),
            name : contactObj.name, 
            mobileNumber : contactObj.mobileNumber, 
            email : contactObj.email
        });
        
        fs.writeFileSync(contactStore, JSON.stringify(contacts));
    }

    search(search) {
        let contactData = fs.readFileSync(contactStore);

        if (contactData.length == 0)
            throw new Error('Nothing to search ')

        if (!search)
            throw new Error('Please, Enter name or mobile number or email to search...')

        let result = [];

        JSON.parse(contactData).forEach(contact => {
            if (contact.name.includes(search) || contact.mobileNumber.toString().includes(search)
                || contact.email.includes(search))
                        result.push(contact);
        });

        if (result.length == 0)
            throw new Error('No Contact Available.');

        return result;
    }

    remove(removeContact) {
        let contactData = fs.readFileSync(contactStore);

        if (contactData.length == 0)
            throw new Error('Nothing to remove.')

        let contacts = JSON.parse(contactData);

        if (!removeContact)
            throw new Error('Enter name or mobile number or email to remove...')

        let deletedContact = [];
        for (let i in contacts) {
            if (contacts[i].name == removeContact ||
                contacts[i].mobileNumber.toString() == removeContact ||
                contacts[i].email == removeContact)
                    deletedContact.push(contacts.splice(i, 1));
        }

        if (deletedContact.length == 0)
            throw new Error('No Contact Available.');

        fs.writeFileSync(contactStore, JSON.stringify(contacts));
    }

    update(updateContact, contactObj) {
        let contactData = fs.readFileSync(contactStore);

        if (contactData.length == 0)
            throw new Error('Nothing to update.')

        let contacts = JSON.parse(contactData);

        if (!updateContact)
            throw new Error('Enter name or mobile number or email to update...')

        for (let i in contacts) {
            if (contacts[i].name == updateContact ||
                contacts[i].mobileNumber.toString() == updateContact ||
                contacts[i].email == updateContact) {
                    this.validateName(contactObj.name);
                    this.validateNumber(contactObj.mobileNumber);
                    this.validateEmail(contactObj.email);
                    
                    contacts[i].name = contactObj.name;
                    contacts[i].mobileNumber = contactObj.mobileNumber;
                    contacts[i].email = contactObj.email;
            }
        }

        fs.writeFileSync(contactStore, JSON.stringify(contacts));
    }

    displayAllContact(){
        return fs.createReadStream(contactStore);
    }

    validateName(name){
        if (name == '' || name == undefined)
            throw new Error("\nName can't be blank");
    }

    validateNumber(number){
        if (isNaN(number) || number.toString().length!=10)
            throw { name : Error , message : 'Invalid mobile number'}
    }

    validateEmail(email){
        if (email == '' || email == undefined)
            throw new Error("\nEmail can't be blank");
    }

}

module.exports = ContactService;