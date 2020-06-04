package com.example.myapplication;

public class User_Record {

    private String FirstName,LastName,StAddress,Zipcode,PhNum,Email,UserName,Password;

    public User_Record(){}

    public User_Record(String firstName, String lastName, String stAddress, String zipcode, String phNum, String email, String userName, String password) {
        FirstName = firstName;
        LastName = lastName;
        StAddress = stAddress;
        Zipcode = zipcode;
        PhNum = phNum;
        Email = email;
        UserName = userName;
        Password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getStAddress() {
        return StAddress;
    }

    public String getZipcode() {
        return Zipcode;
    }

    public String getPhNum() {
        return PhNum;
    }

    public String getEmail() {
        return Email;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setStAddress(String stAddress) {
        StAddress = stAddress;
    }

    public void setZipcode(String zipcode) {
        Zipcode = zipcode;
    }

    public void setPhNum(String phNum) {
        PhNum = phNum;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setPassword(String password) {
        Password = password;
    }
}

