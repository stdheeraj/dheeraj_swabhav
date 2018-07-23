const mongoose = require('mongoose');
const Student = require('./student.model');

let db = 'mongodb://root:root123@ds233551.mlab.com:33551/shopping-cart-db'

mongoose.connect(db,{ useNewUrlParser: true }, (err, result) => {
	if(err)
		console.log('Database is not running.\n Start database !!!');	
	if(result)
		console.log('Database running...');
});

const cb = (err, result) => {
    if(err) console.log(err);
    if(result) console.log(result);
}

const createStudent = (fname, lname, stream) => {
    const newStudent = new Student();
    newStudent.fname = fname;
    newStudent.lname = lname;
    newStudent.stream = stream;
    newStudent.save(cb);
}

const getStudent = (name)=> {
    Student.findOne({fname:name}, cb)
}

const getAllStudent = () => {
    Student.find(cb)
}

const updateStudent = (name, newStream) => {
    Student.findOne({fname:name}, (err, result) => {
        if(err) console.log(err);
        if(result) Student.findByIdAndUpdate({ _id : result._id }, { stream : newStream }, { new : true }, cb)

    });
}

const deleteStudent = (name) => {
    Student.findOneAndRemove({ fname : name}, cb);
}


//createStudent("Dheeraj", "Chaurasia", "CS");
//getStudent("Dheeraj");
//getAllStudent();
//updateStudent("Dheeraj", "CS");
//deleteStudent("Dheeraj");

