const connection = require('../connection');
const mongoose = connection.getConnection();
const Schema = mongoose.Schema;

let TransactionDetailSchema = new Schema({
    _id: new mongoose.Types.ObjectId(),
    Type: {
        type: String,
        enum: {
            values: ['Deposit', 'Withdraw', 'Credit', 'Debit'],
            message: 'Invalid type of transaction.'
        },
        required: [true, 'Type of transaction is required.']
    },
    Party : {
        type: Schema.ObjectId,
        ref: 'Customer',
        required: [true, 'Customer ID of party is required.']
    },
    Amount: {
        type: Schema.Types.Decimal128,
        required: [true, 'Transaction must have amount.']
    },
    Date: {
        type:Date,
        default: Date.now,
        required: [true, 'Date of transaction is required.']
    }
});

let TransactionHistorySchema = new Schema({
    _id: {
        type: Schema.ObjectId,
        ref: 'Customer',
        required: [true, 'Customer ID is required.']
    },
    TransactionDetails: {
        type: [TransactionDetailSchema],
        required: [true, 'Transaction detail is required.']
    }
});

module.exports = mongoose.model('TransactionHistory', TransactionHistorySchema);