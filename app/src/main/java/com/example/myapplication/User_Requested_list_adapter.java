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

public class User_Requested_list_adapter extends ArrayAdapter<Transaction_Handler> {

    private static final String TAG="User_Requested_list_adapter";
    private Context mContext;
    int mResource;
    private TextView name1,name2,name3,name4,name5;

    public User_Requested_list_adapter(@NonNull Context context, int resource, @NonNull ArrayList<Transaction_Handler> objects) {
        super(context, resource, objects);
        this.mContext = context;
        mResource=resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        String Status="Status: " + getItem(position).getStatus().toString();
        String userid=getItem(position).getUserID();
        String Fname=getItem(position).getFirstName();
        String Lname=getItem(position).getLastName();
        String add=getItem(position).getAddress();
        String zip=getItem(position).getZipcode();
        String customerEmail=getItem(position).getCustomerEmail();
        final String Service=getItem(position).getServiceDescription().toString();
        String Date=getItem(position).getDate().toString();
        String Time=getItem(position).getTime().toString();
        String Vemail=getItem(position).getVendorEmail().toString();
        String transactionid = getItem(position).getTransID();
        String P=getItem(position).getPrice().toString();
        String dateAndTime =Date+ " at "+Time;
        String Finaladdress=add+" " +zip;
        String companyName=getItem(position).getVendorCname();
        String companyandMessage=companyName+" has Accepted your service Request";
        String Vendoraddress=getItem(position).getVendorAddress().toString()+"   "+getItem(position).getVendorZip().toString();
        String vendoremailphone=getItem(position).getVendorEmail()+getItem(position).getVendorZip();
        String Price=getItem(position).getPrice();

        Transaction_Handler vendor=new Transaction_Handler(Status,userid,Fname,Lname,add,zip,customerEmail,Service,Date,Time,Vemail," "," "," "," ", P,transactionid);
        LayoutInflater inflater=LayoutInflater.from(mContext);
        convertView=inflater.inflate(mResource,parent, false);
        name1=(TextView) convertView.findViewById(R.id.compName);
        name2=(TextView) convertView.findViewById(R.id.compADD);
        name3=(TextView) convertView.findViewById(R.id.Compemail);
        name4=(TextView) convertView.findViewById(R.id.price);


        name1.setText(Status);
        name2.setText(dateAndTime);
        name3.setText(Vemail);
        name4.setText(Service);



        return convertView ;
    }
}
