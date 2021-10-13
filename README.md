# TransportComApp

This is a template for a mobile app I created for a transportation company, using Android Studio. 

The company collects products from a client and stores them for a certain period of time until the client wants them back.
They keep books containing the info of each client(name, address, city, phone number, pick up date), the product types,
the quantity of each product and the fees charged. The app is meant to replace the books, so the user enters all the info and 
then the app stores them to a database. I created a rest API that connects to a MongoDB. The android app connects to the API and the API handles the database. 

The user upon opening the app has two options, to make a new entry or search for an old one. Before adding the data to the database the user can send 
a confirmation sms to the client with all the saved info. Every new entry automatically gets a unique serial number that the user can then use to search for the customer's info.  
