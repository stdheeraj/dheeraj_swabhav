const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const EmployeeSchema = new Schema({
    Name: String,
    Position: String
});

const DepartmentSchema = new Schema({
    Name: String,
    Employees: [EmployeeSchema]
})

module.exports = mongoose.model('Department', DepartmentSchema);