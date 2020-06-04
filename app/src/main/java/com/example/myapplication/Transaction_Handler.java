package com.example.myapplication;

public class Transaction_Handler {
    private String Status,UserID,FirstName,LastName,Address,Zipcode,CustomerEmail,ServiceDescription,Date,Time,VendorEmail,VendorCname,VendorAddress,VendorZip,VendorPh,Price,TransID;

    public Transaction_Handler(){
    }

    public Transaction_Handler(String status, String userID, String firstName, String lastName, String address, String zipcode, String customerEmail, String serviceDescription, String date, String time, String vendorEmail, String vendorCname, String vendorAddress, String vendorZip, String vendorPh, String price, String transID) {
        Status = status;
        UserID = userID;
        FirstName = firstName;
        LastName = lastName;
        Address = address;
        Zipcode = zipcode;
        CustomerEmail = customerEmail;
        ServiceDescription = serviceDescription;
        Date = date;
        Time = time;
        VendorEmail = vendorEmail;
        VendorCname = vendorCname;
        VendorAddress = vendorAddress;
        VendorZip = vendorZip;
        VendorPh = vendorPh;
        Price = price;
        TransID = transID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getZipcode() {
        return Zipcode;
    }

    public void setZipcode(String zipcode) {
        Zipcode = zipcode;
    }

    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        CustomerEmail = customerEmail;
    }

    public String getServiceDescription() {
        return ServiceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        ServiceDescription = serviceDescription;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getVendorEmail() {
        return VendorEmail;
    }

    public void setVendorEmail(String vendorEmail) {
        VendorEmail = vendorEmail;
    }

    public String getVendorCname() {
        return VendorCname;
    }

    public void setVendorCname(String vendorCname) {
        VendorCname = vendorCname;
    }

    public String getVendorAddress() {
        return VendorAddress;
    }

    public void setVendorAddress(String vendorAddress) {
        VendorAddress = vendorAddress;
    }

    public String getVendorZip() {
        return VendorZip;
    }

    public void setVendorZip(String vendorZip) {
        VendorZip = vendorZip;
    }

    public String getVendorPh() {
        return VendorPh;
    }

    public void setVendorPh(String vendorPh) {
        VendorPh = vendorPh;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getTransID() {
        return TransID;
    }

    public void setTransID(String transID) {
        TransID = transID;
    }
}
