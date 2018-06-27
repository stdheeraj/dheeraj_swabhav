const readlineSync = require('readline-sync');
const ContactService = require('./contact-service');

let contactService = new ContactService();

while (true) {

        console.log('\n1 : Search');
        console.log('2 : Add')
        console.log('3 : Update')
        console.log('4 : Remove')
        console.log('5 : Display All Contacts')
        console.log('6 : Exit')

        let operation = readlineSync.keyIn('Which operation? ', { limit: '$<1-6>' });

        try {
                switch (parseInt(operation)) {
                        case 1: contactService.search();
                                break;
                        case 2: contactService.add();
                                break;
                        case 3: contactService.update();
                                break;
                        case 4: contactService.remove();
                                break;
                        case 5: contactService.display();
                                break;
                        case 6: process.exit();
                                break;
                        default: console.log('invalid opeartion..');
                }
                
        } catch (e) {
                console.error(e.message)
        }
}