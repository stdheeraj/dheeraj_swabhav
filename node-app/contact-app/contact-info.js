const ContactInfo = function () {

    let _name, _mobileNumber, _email;

    this.setName = (name) => {
        if (name == '' || name == undefined)
            throw new Error("Name can't be blank");

        _name = name;
    }

    this.setMobileNumber = (mobileNumber) => {
        if (isNaN(mobileNumber))
            throw { name : TypeError , message : 'Invalid mobile number'} // new TypeError('Invalid account number');

        if (mobileNumber <= 0)
            throw new RangeError("Mobile number can't be negative or zero.");

        _mobileNumber = mobileNumber;
    }

    this.setEmail = (email) => {
        if (email == '' || email == undefined)
            throw new Error("email can't be blank");

        _email = email;
    }

    this.getName = () =>  _name;

    this.getMobileNumber = () => _mobileNumber;

    this.getEmail = () => _email;

    this.getJSONObject = () => {
        return {
            name : _name, 
            mobileNumber :[_mobileNumber], 
            email : [_email]
        }
    }

    this.printDetails = () => {
        console.log('\n'+_name+'\t'+_mobileNumber+'\t'+_email);
    }
}

module.exports = ContactInfo;