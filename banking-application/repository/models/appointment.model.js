const connection = require('../connection');
const mongoose = connection.getConnection();
const Schema = mongoose.Schema;

let AppointmentSchema = new Schema({
    _id: new mongoose.Types.ObjectId(),
    Title: {
        type: String,
        required: [true, 'Appointment must have title.']
    },
    Purpose: {
        type: String,
        required: [true, 'Appointment must have purpose.']
    },
    Date: {
        type: String,
        required: [true, 'Appointment must have date.']
    },
    Time: {
        type: String,
        required: [true, 'Appointment must have time.']
    },
    Status: {
        type: String,
        enum: ['Pending', 'Confirmed', 'Cancelled', 'Rescheduled'],
        required: [true, 'Appointment status is required.']
    }
}, {
    timestamps: true
});

let CustomerAppointmentSchema = new Schema({
    _id: {
        type: Schema.ObjectId,
        ref: 'Customer',
        required: [true, 'Customer ID is required.']
    },
    Appointments: {
        type: [AppointmentSchema],
        required: [true, 'Customer must have appointment.']
    }
});

module.exports = mongoose.model('CustomerAppointment', CustomerAppointmentSchema);