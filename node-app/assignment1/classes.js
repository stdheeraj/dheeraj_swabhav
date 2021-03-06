class Person {
    constructor(name) {
        this.name = name;
    }

    getName() {
        console.log('Person Name is ' + this.name);
    }
}

class Employee extends Person {
    constructor(name, position) {
        super(name);
        this.position = position;
    }

    getPosition() {
        console.log("Position of " + this.name + " is " + this.position)
    }
}

var emp = new Employee('Dheeraj', "Developer");
emp.getName();
emp.getPosition();