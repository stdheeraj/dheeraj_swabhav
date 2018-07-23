const mongoose = require('mongoose');
const Department = require('./department.model');

let db = 'mongodb://root:root123@ds233551.mlab.com:33551/shopping-cart-db'

mongoose.connect(db,{ useNewUrlParser: true }, (err, result) => {
	if(err)
		console.log('Database is not running.\n Start database !!!');	
	if(result)
		console.log('Database running...');
});

const newDepartment = new Department();

let emp1 = {
    Name : "Dheeraj",
    Position : "Developer"
}

let emp2 = {
    Name : "Santosh",
    Position : "Developer"
}

newDepartment.Name = "Sales";
newDepartment.Employees = [emp1, emp2];

newDepartment.save((err, result) => {

    if(err)
        console.log(err)
    
    if(result)
        console.log(result);

});