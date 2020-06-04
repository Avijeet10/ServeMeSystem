package com.example.myapplication;
public class RecyclerViewAdapter{

    private String companyAddress;
    private String companyName;
    private String companyZip;
    private String email;
    private String passWord;
    private String phnum;
    private String retailerId;
    private String serviceType;
    private String username;

    public RecyclerViewAdapter(){

    }

    public RecyclerViewAdapter(String companyAddress, String companyName, String companyZip, String email, String passWord, String phnum, String retailerId, String serviceType, String username) {
        this.companyAddress = companyAddress;
        this.companyName = companyName;
        this.companyZip = companyZip;
        this.email = email;
        this.passWord = passWord;
        this.phnum = phnum;
        this.retailerId = retailerId;
        this.serviceType = serviceType;
        this.username = username;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyZip() {
        return companyZip;
    }

    public void setCompanyZip(String companyZip) {
        this.companyZip = companyZip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhnum() {
        return phnum;
    }

    public void setPhnum(String phnum) {
        this.phnum = phnum;
    }

    public String getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(String retailerId) {
        this.retailerId = retailerId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
