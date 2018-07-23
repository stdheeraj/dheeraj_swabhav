const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const StudentSchema = new Schema({
    fname: String,
    lname: String,
    stream: String
})

module.exports = mongoose.model('Student', StudentSchema);