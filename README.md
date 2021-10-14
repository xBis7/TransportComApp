# TransportComApp

This is a template for a mobile app I created for a transportation company, using Android Studio. 

The company collects products from a client and stores them for a certain period of time until the client wants them back.
They keep books containing the info of each client(name, address, city, phone number, pick up date), the product types,
the quantity of each product and the fees charged. The app is meant to replace the books, so the user enters all the info and 
then the app stores them to a database. I created a rest API that connects to a MongoDB. The android app connects to the API and the API handles the database. 

<br>
The user upon opening the app has two options, to make a new entry or search for an old one. 

<img src="https://user-images.githubusercontent.com/74301312/137323465-9d150496-a87e-4ee2-85ef-9cdc3c8643db.jpg" alt="1" height="900" width="430"/>

<br>
After selecting new entry, a screen appears prompting the user to enter a customers info and the quantity and price of the products.

<img src="https://user-images.githubusercontent.com/74301312/137325274-6612f886-476f-41f8-a82d-c424deb03238.jpg" alt="2" height="900" width="430"/>

<img src="https://user-images.githubusercontent.com/74301312/137325072-213cd7c7-6260-4933-b18b-33ab3ba571ab.jpg" alt="3" height="900" width="430"/>

<br>
If date is not filled, current date and time will be used. User can't add info to the database if one or more personal info fields are empty and if
not at least one product is filled.

<img src="https://user-images.githubusercontent.com/74301312/137325440-557e8e37-d7ef-4d57-9b71-4afaf9e0f258.jpg" alt="4" height="900" width="430"/>

<img src="https://user-images.githubusercontent.com/74301312/137325495-e7a9e7c9-4191-4bd7-8052-7901124bac07.jpg" alt="5" height="900" width="430"/>

<br>
After pressing add, there is a confirmation screen where the user can also send a confirmation sms to the customer. 

<img src="https://user-images.githubusercontent.com/74301312/137325523-b7425d2b-967a-4fb7-8af0-ed6e813bc291.jpg" alt="6" height="900" width="430"/>

<br>
Upon successfully saving data to the database a Toast is displayed and the user is moved back to the main screen.

<img src="https://user-images.githubusercontent.com/74301312/137325536-f02a1bee-0955-4b7a-b159-78dfcfba3303.jpg" alt="7" height="900" width="430"/>

<br>
The customer was given serial number 2, so let's search for an entry with that serial number.

<img src="https://user-images.githubusercontent.com/74301312/137325544-71b8d451-60dd-4dbc-a422-db8071300546.jpg" alt="8" height="900" width="430"/>

<br>
If the entry exists, a dialog with the customer's info will be displayed. 

<img src="https://user-images.githubusercontent.com/74301312/137325553-39a6af31-c320-4898-a0e5-0285b70d9cbc.jpg" alt="9" height="900" width="430"/>

<br>
The user can also share the customer's info.

<img src="https://user-images.githubusercontent.com/74301312/137325567-0fc567f8-2aa2-43f4-9d83-169350a3f481.jpg" alt="10" height="900" width="430"/>

<br>
A customer's entry can't be deleted but there is the option to clear the database and delete all entries.

<img src="https://user-images.githubusercontent.com/74301312/137325578-047237fe-b8d8-4d1f-b418-68700bf1aa5c.jpg" alt="11" height="900" width="430"/>

<br>
If the deletion is successful a Toast will be displayed.

<img src="https://user-images.githubusercontent.com/74301312/137325583-6ea015ab-15c5-4df0-829b-a04406b1f9a6.jpg" alt="12" height="900" width="430"/>

<br>
If we search for a customer with serial number 2, we will see that such entry no longer exists.

<img src="https://user-images.githubusercontent.com/74301312/137325593-2e4e4894-2a34-4084-9124-a861b8ba3d3c.jpg" alt="13" height="900" width="430"/>


