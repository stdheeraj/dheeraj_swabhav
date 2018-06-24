const events = require('events');
const eventEmitter = new events.EventEmitter();

class NumberService {

    getNumber(){
        let number = Math.round(Math.random()*10);

        if(number < 5)
            return eventEmitter.emit('failure', number);

        return eventEmitter.emit('success', number);
    }

    getEvents() {
        return eventEmitter;
    } 
}

module.exports = NumberService;