const readlineSync = require('readline-sync');
const ContactService = require('./contact-service');

let contactService = new ContactService();

do {
    console.log('1 : Search');
    console.log('2 : Add')
    console.log('3 : Remove')
    console.log('4 : Update')
    let choice = readlineSync.question('Enter your choice : ');
    switch (parseInt(choice)) {
        case 1: console.log('hello1');
                break;
        case 2: contactService.add();
                break;
        case 3: console.log('hello3');
                break;
        case 4: console.log('hello4');
                break;
        default: console.log('Invalid Choice')
    }

    let c = readlineSync.question('Do you want to continue? (y/n) ');
    if(c === "n")
        break;
} while (true);


/*
let name = readlineSync.question('Enter your name : ');
let contact = readlineSync.question('Enter your contact number : ');


console.log('Hi ' + userName + '!');
 
// Handle the secret text (e.g. password).
var favFood = readlineSync.question('What is your favorite food? ', {
  hideEchoBack: true // The typed text on screen is hidden by `*` (default).
});
console.log('Oh, ' + userName + ' loves ' + favFood + '!');
*/