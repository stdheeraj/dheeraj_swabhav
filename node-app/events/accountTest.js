const Account = require('./account');

const acc1 = new Account();
try {

    let e = acc1.getEvents();
    e.on('deposit', (b) => console.log("balance after deposit "+ b))
    .on('withdraw', (b) => console.log("balance after withdraw "+ b))

    acc1.setAccountNo(1001);
    acc1.setName('Dheeraj');
    acc1.setBalance(1000);

    acc1.deposit(500);

    acc1.deposit(100);

    acc1.withdraw(500);

    //acc1.printDetails();

} catch (e) {
    console.error(e.message);
}