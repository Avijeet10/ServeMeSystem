package com.example.myapplication;

public class Vendor_Record {

    private String CompanyName,CompanyAddress,CompanyZip,Phnum,ServiceType,RetailerId,Email,Username,PassWord;

    public Vendor_Record(){}

    public Vendor_Record(String companyName, String companyAddress, String companyZip,String phnum, String serviceType, String retailerId, String email, String username, String passWord) {
        CompanyName = companyName;
        CompanyAddress = companyAddress;
        CompanyZip = companyZip;
        Phnum = phnum;
        ServiceType = serviceType;
        RetailerId = retailerId;
        Email = email;
        Username = username;
        PassWord = passWord;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public String getCompanyAddress() {
        return CompanyAddress;
    }

    public String getCompanyZip() {
        return CompanyZip;
    }

    public String getPhnum() {
        return Phnum;
    }

    public String getServiceType() {
        return ServiceType;
    }

    public String getRetailerId() {
        return RetailerId;
    }

    public String getEmail() {
        return Email;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public void setCompanyAddress(String companyAddress) {
        CompanyAddress = companyAddress;
    }

    public void setCompanyZip(String companyZip) {
        CompanyZip = companyZip;
    }

    public void setPhnum(String phnum) {
        Phnum = phnum;
    }

    public void setServiceType(String serviceType) {
        ServiceType = serviceType;
    }

    public void setRetailerId(String retailerId) {
        RetailerId = retailerId;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }
}
