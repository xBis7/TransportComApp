require('dotenv').config();

const express = require('express');
const app = express();
const mongoose = require('mongoose');

mongoose.connect(process.env.DATABASE_URL, { useNewUrlParser: true });
const db = mongoose.connection;
db.on('error', (error) => console.error(error));
db.once('open', () => console.log('Connected to Database'));

app.use(express.json());

const customersRouter = require('./routes/customers');
app.use('/customers', customersRouter);

app.listen(3000, () => console.log('Server Started'));


//'npm run devStart' to run the server with nodemon o restart automatically