const connection = require('../connection');
const mongoose = connection.getConnection();
const Schema = mongoose.Schema;

let AddressSchema = new Schema({
	AddressLine1: {
		type: String,
		required: [true, 'This Address Line is required.']
	},
	AddressLine2: {
		type: String
	},
	Area: {
		type: String,
		required: [true, 'Area of address field is required.']
	},
	Locality: {
		type: String,
		required: [true, 'Locality of address field is required.']
	},
	City: {
		type: String,
		required: [true, 'City of address field is required.']
	},
	State: {
		type: String,
		required: [true, 'State of address field is required.']
	},
	Country: {
		type: String,
		required: [true, 'Country of address field is required.']
	},
	PostalCode: {
		type: Number,
		match: ['^[0-9]{6}$', "Postal code must be of 6 digit."],
		required: [true, 'Postal Code of address field is required.']
	}
});

let ContactNumberSchema = new Schema({
	CountryCode: {
		type: String,
		default: '+91',
		match: '^[+0-9]{2,4}$'
	},
	PhoneNumber: {
		type: Number,
		match: '^[0-9]{10}$',
		index: {
			unique: true,
			partialFilterExpression: { PhoneNumber: { $type: 'decimal' } }
		},
		required: [true, 'Phone number of customer is required.']
	}
});

let LoginSchema = new Schema({
	UserName: {
		type: String,
		unique: true,
		required: [true, 'User name of customer is required.']
	},
	Password: {
		type: String,
		minlength: [8, 'Password must have minimum 8 characters.'],
		maxlength: [13, 'Password must have maximum 13 characters.'],
		required: [true, 'Password of customer is required.']
	}
});

let ProfileSchema = new Schema({
	Salutation: {
		type: String,
		enum: {
			values: ['Mr.', 'Mrs.', 'Ms.'],
			message: 'Salutation is invalid'
		},
		required: [true, 'Salutation of account holder is required.']
	},
	FirstName: {
		type: String,
		required: [true, 'First name of account holder is required.']
	},
	MiddleName: {
		type: String,
		required: [true, 'Middle name of account holder is required.']
	},
	LastName: {
		type: String,
		required: [true, 'Last name of account holder is required.']
	},
	Gender: {
		type: String,
		enum: {
			values: ['Male', 'Female', 'Other'],
			message: 'Gender is invalid.'
		},
		required: [true, 'Gender of account holder is required.']
	},
	DateOfBirth: {
		type: Date,
		required: [true, 'Date of birth of account holder is required.']
	},
	Address: {
		type: AddressSchema,
		required: [true, 'Address of account holder is required.']
	}
});

let ContactSchema = new Schema({
	ContactNumber: {
		type: ContactNumberSchema,
		required: [true, 'Contact number of account holder is required.']
	},
	EmailID: {
		type: String,
		match: '^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$',
		index: {
			unique: true,
			partialFilterExpression: { EmailID: { $type: 'string' } }
		},
		required: [true, 'Email ID of account holder is required.']
	}
});

let AccountSchema = new Schema({
	Type: {
		type: String,
		enum: {
			values: ['Current', 'Saving'],
			message: 'Account type is invalid'
		},
		required: [true, 'Type of account is required.']
	},
	Balance: {
		type: Schema.Types.Decimal128,
		required: [true, 'Balance is required in account.']
	},
	Recipients: {
		type: Schema.ObjectId,
		ref: 'Customer'
	}
});

let CustomerSchema = new Schema({
	//_id: new mongoose.Types.ObjectId(),
	Login: {
		type: LoginSchema,
		required: [true, 'Login details are required']
	},
	Profile: {
		type: ProfileSchema
	},
	ContactDetail: {
		type: ContactSchema,
		required: [true, 'Contact details are required']
	},
	Account: {
		type: [AccountSchema],
		validate: [(v) => v.length <= 2, 'More than 2 account is not possible.']
	},
});

module.exports = mongoose.model('Customer', CustomerSchema);