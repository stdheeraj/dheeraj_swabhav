const fs = require('fs');
const readlineSync = require('readline-sync');
const ContactInfo = require('./contact-info');

//const users = JSON.parse(fs.readFile('contacts.json'));
const contactInfo = new ContactInfo();

class ContactService {

    add(){
        
        let name = readlineSync.question('Enter your name : ');
        contactInfo.setName(name);

        let mobileNumber = readlineSync.question('Enter your phone number : ');
        contactInfo.setMobileNumber(mobileNumber);

        let email = readlineSync.question('Enter your email : ');
        contactInfo.setEmail(email);        

        fs.readFile('contacts.json', (err, data) => {
            console.log('inside')
            if (err)
                throw new Error(err);
            
            let contacts = [];
            if(data.length != 0)
                contacts = JSON.parse(data);
            
            contacts.push(contactInfo.getJSONObject());
            let json = JSON.stringify(contacts);
            fs.writeFile('contacts.json', json, (err) => {if(err) console.log(err)}); 
        });

    }

    search(){

        let email = readlineSync.question('Enter name : ');
        contactInfo.setEmail(email);        

        fs.readFile('contacts.json', (err, data) => {
            console.log('inside')
            if (err)
                throw new Error(err);
            
            let contacts = [];
            if(data.length != 0)
                contacts = JSON.parse(data);
            
            contacts.push(contactInfo.getJSONObject());
            let json = JSON.stringify(contacts);
            fs.writeFile('contacts.json', json, (err) => {if(err) console.log(err)});
        });


    }

    remove(){

        

    }

    update(){

    }


    getUser(id){
        return new Promise((resolve,reject) => {
            //console.log(users.map((d)=>d.repository));

            users.forEach((user) => {
                if(user.id == id)
                    resolve(user);
                else
                    reject(new Error("\nNot Authenticated User"));
            });
        });
    }

}

module.exports = ContactService;