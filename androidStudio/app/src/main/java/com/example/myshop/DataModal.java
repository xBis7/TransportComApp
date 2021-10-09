package com.example.myshop;

public class DataModal {
    private String name;
    private String serialNum;
    private String address;
    private String city;
    private String phone;
    private String date;
    private String product1;
    private String product2;
    private String product3;
    private String product4;
    private String product5;

    public DataModal(String name, String serialNum, String address, String city, String phone, String date,
                     String product1, String product2, String product3, String product4, String product5){
        this.name = name;
        this.serialNum = serialNum;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.date = date;
        this.product1 = product1;
        this.product2 = product2;
        this.product3 = product3;
        this.product4 = product4;
        this.product5 = product5;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getSerialNum() {

        return serialNum;
    }

    public void setSerialNum(String serialNum) {

        this.serialNum = serialNum;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getCity() {

        return city;
    }

    public void setCity(String city) {

        this.city = city;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    public String getDate() {

        return date;
    }

    public void setDate(String date) {

        this.date = date;
    }

    public String getProduct1() {

        return product1;
    }

    public void setProduct1(String product1) {

        this.product1 = product1;
    }

    public String getProduct2() {

        return product2;
    }

    public void setProduct2(String product2) {

        this.product2 = product2;
    }

    public String getProduct3() {

        return product3;
    }

    public void setProduct3(String product3) {

        this.product3 = product3;
    }

    public String getProduct4() {

        return product4;
    }

    public void setProduct4(String product4) {

        this.product4 = product4;
    }

    public String getProduct5() {

        return product5;
    }

    public void setProduct5(String product5) {

        this.product5 = product5;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "\nname=" + name +
                ", \nserialNum=" + serialNum +
                ", \naddress=" + address +
                ", \ncity=" + city +
                ", \nphone=" + phone +
                ", \ndate=" + date +
                ", \nproduct1=" + product1 +
                ", \nproduct2=" + product2 +
                ", \nproduct3=" + product3 +
                ", \nproduct4=" + product4 +
                ", \nproduct5=" + product5 +
                "\n}";
    }
}
