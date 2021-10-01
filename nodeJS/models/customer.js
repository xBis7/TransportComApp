const mongoose = require('mongoose');

const customerSchema = new mongoose.Schema({
    serialNum: {
        type: Number,
        required: true
    },
    name: {
        type: String,
        required: true
    },
    address: {
        type: String,
        required: true
    },
    city: {
        type: String,
        required: true
    },
    phone: {
        type: Number,
        required: true
    },
    date: {
        type: Date,
        required: true,
        default: Date.now
    },
    product1: {
        type: String,
        required: true,
        default: "-"
    },
    product2: {
        type: String,
        required: true,
        default: "-"
    },
    product3: {
        type: String,
        required: true, 
        default: "-"
    },
    product4: {
        type: String,
        required: true,
        default: "-"
    },
    product5: {
        type: String,
        required: true,
        default: "-"
    }

});

module.exports = mongoose.model('Customer', customerSchema);