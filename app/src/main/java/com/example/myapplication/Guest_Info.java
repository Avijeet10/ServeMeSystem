package com.example.myapplication;

public class Guest_Info {
    private String Guest_FN, Guest_LN,Guest_Add,Guest_Zip;

    public Guest_Info(){}

    public Guest_Info(String guest_FN, String guest_LN, String guest_Add, String guest_Zip) {
        Guest_FN = guest_FN;
        Guest_LN = guest_LN;
        Guest_Add = guest_Add;
        Guest_Zip = guest_Zip;
    }

    public String getGuest_FN() {
        return Guest_FN;
    }

    public String getGuest_LN() {
        return Guest_LN;
    }

    public String getGuest_Add() {
        return Guest_Add;
    }

    public String getGuest_Zip() {
        return Guest_Zip;
    }
}
