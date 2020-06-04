package com.example.myapplication;

public class VendorRate_Tracker {
    private String vendoremail;
    private int vendorRate;

    public VendorRate_Tracker(String vendoremail, int vendorRate) {
        this.vendoremail = vendoremail;
        this.vendorRate = vendorRate;
    }

    public String getVendoremail() {
        return vendoremail;
    }

    public void setVendoremail(String vendoremail) {
        this.vendoremail = vendoremail;
    }

    public int getVendorRate() {
        return vendorRate;
    }

    public void setVendorRate(int vendorRate) {
        this.vendorRate = vendorRate;
    }
}
