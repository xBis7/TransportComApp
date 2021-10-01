# TransportComApp

This is a template for a mobile app I created for a transportation company, using Android Studio. 

The company collects products from a client and stores them for a certain period of time until the client wants them back.
They keep books containing the info of each client(name, address, city, phone number, pick up date), the product types,
the quantity of each product and the fees charged. The app is meant to replace the books, so the user enters all the info and 
then the app stores them to a local database. I used SQLite for the local database but for this template I created a rest api to connect the app to a mongoDB. 

The user upon opening the app has two options, to make a new entry or search for an old one. Before adding the data to the database the user can send 
a confirmation sms to the client with all the saved info  
