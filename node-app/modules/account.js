const Account = function () {

    let _accountNo, _name, _balance;

    this.setAccountNo = (accountNo) => {
        if (isNaN(accountNo))
            throw { name : TypeError , message : 'Invalid account number'} // new TypeError('Invalid account number');

        if (accountNo <= 0)
            throw new RangeError("Account number can't be negative or zero.");

        _accountNo = accountNo;
    }

    this.setName = (name) => {
        if (name == '' || name == undefined)
            throw new Error("Name can't be blank");

        _name = name;
    }

    this.setBalance = (balance) => {

        if (isNaN(balance))
            throw new Error('Invalid balance');

        if (balance <= 0)
            throw new Error("Balance can't be negative or zero.");

        _balance = balance;
    }

    this.getAccountNo = () =>  _accountNo;

    this.getName = () =>  _name;

    this.getBalance = () => _balance;

    this.deposit = (amount) => {

        if (isNaN(amount))
            throw new Error('Invalid amount');

        if (amount <= 0)
            throw new Error("Amount can't be negative or zero.");

        _balance += amount;
        console.log('amount deposited succefully.');
    }

    this.withdraw = (amount) => {

        if (isNaN(amount))
            throw new Error('Invalid amount');

        if (amount <= 0)
            throw new Error("Amount can't be negative or zero.");

        if (_balance - amount < 500)
            throw new Error("Can't withdraw. Insufficient balance.");

        _balance -= amount;

        console.log('Amount withdrawn succefully.')
    }

    this.printDetails = () => {
        console.log('Account No: '+_accountNo);
        console.log('Name: '+_name);
        console.log('Current Balance: '+_balance);
    }
}

module.exports = Account;