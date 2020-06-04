package com.example.myapplication;

public class VendorReview_Tracker {

    private String vendoremail,vendorreview;

    public VendorReview_Tracker(String vendoremail, String vendorreview) {
        this.vendoremail = vendoremail;
        this.vendorreview = vendorreview;
    }

    public String getVendoremail() {
        return vendoremail;
    }

    public void setVendoremail(String vendoremail) {
        this.vendoremail = vendoremail;
    }

    public String getVendorreview() {
        return vendorreview;
    }

    public void setVendorreview(String vendorreview) {
        this.vendorreview = vendorreview;
    }
}
