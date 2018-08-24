const connection = require('../connection');
const mongoose = connection.getConnection();
const Schema = mongoose.Schema;

let TempCustomerSchema = new Schema({
	UserName: {
		type: String,
		index: {
			unique: true,
			partialFilterExpression: { UserName: { $type: 'string' } }
		},
		required: [true, 'User name of customer is required.']
	},
	Password: {
		type: String,
		minlength: [8, 'Password must have minimum 8 characters.'],
		maxlength: [13, 'Password must have maximum 13 characters.'],
		required: [true, 'Password of customer is required.']
	},
	EmailID: {
		type: String,
		//match: '/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/',
		index: {
			unique: true,
			partialFilterExpression: { EmailID: { $type: 'string' } }
		},
		required: [true, 'Email ID of customer is required.']
	},
	Token: {
		type: String,
		required: [true, 'Token is required.']
	}

});

module.exports = mongoose.model('TempCustomer', TempCustomerSchema);