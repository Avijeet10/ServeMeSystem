package com.example.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Vendor_Service_History_adapter extends ArrayAdapter<Transaction_Handler> {

    private static final String TAG="Vendor_Service_History_adapter";
    private Context mContext;
    int mResource;
    private TextView name1,name2,name3,name4,name5;

    public Vendor_Service_History_adapter(@NonNull Context context, int resource, @NonNull ArrayList<Transaction_Handler> objects) {
        super(context, resource, objects);
        this.mContext = context;
        mResource=resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        String Status="Status: " + getItem(position).getStatus().toString()+ "  RECEIVED: $"+getItem(position).getPrice();
        String userid=getItem(position).getUserID();
        String Fname=getItem(position).getFirstName();
        String Lname=getItem(position).getLastName();
        String fullname="Name: "+Fname+" "+Lname;
        String add=getItem(position).getAddress();
        String zip=getItem(position).getZipcode();
        String customeraddress="Customer Address: "+add+" "+zip;
        String customerEmail=getItem(position).getCustomerEmail();
        final String Service="Message: "+getItem(position).getServiceDescription().toString();
        String Date=getItem(position).getDate().toString();
        String Time=getItem(position).getTime().toString();
        String Vemail=getItem(position).getVendorEmail().toString();
        String transactionid = getItem(position).getTransID();
        String P=getItem(position).getPrice().toString();
        String dateAndTime ="Date: "+Date+ " at "+Time;
        String Finaladdress=add+" " +zip;
        String contact=getItem(position).getVendorPh();
        String companyName="Company Name: "+getItem(position).getVendorCname();
        String companyandMessage=companyName+" has Accepted your service Request";
        String Vendoraddress="Address: "+getItem(position).getVendorAddress().toString()+"   "+getItem(position).getVendorZip().toString();
        String vendoremailphone="Email: "+getItem(position).getVendorEmail()+" Call: "+contact;

        Transaction_Handler vendor=new Transaction_Handler(Status,userid,Fname,Lname,add,zip,customerEmail,Service,Date,Time,Vemail," "," "," "," ", P,transactionid);
        LayoutInflater inflater=LayoutInflater.from(mContext);
        convertView=inflater.inflate(mResource,parent, false);
        name1=(TextView) convertView.findViewById(R.id.STATUS);
        name2=(TextView) convertView.findViewById(R.id.VNAME);
        name5=(TextView) convertView.findViewById(R.id.VADDRESS);
        name3=(TextView) convertView.findViewById(R.id.DATETIME);
        name4=(TextView) convertView.findViewById(R.id.MESSAGE);


        name1.setText(Status);
        name2.setText(fullname);
        name3.setText(dateAndTime);
        name4.setText(Service);
        name5.setText(customeraddress);




        return convertView ;
    }
}
