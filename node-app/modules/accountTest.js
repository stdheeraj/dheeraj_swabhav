const Account = require('./account');

const acc1 = new Account();
try {

    acc1.setAccountNo(1001);
    acc1.setName('Dheeraj');
    acc1.setBalance(500);

    acc1.deposit(500);
    acc1.withdraw(500);

    acc1.printDetails();

} catch (e) {
    console.error(e.message);
}