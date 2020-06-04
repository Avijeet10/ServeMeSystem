package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class VendorListAdapter extends ArrayAdapter<RecyclerViewAdapter> {

    private static final String TAG="VendorListAdapter";
    private Context mContext;
    int mResource;


    public VendorListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<RecyclerViewAdapter> objects) {
        super(context, resource, objects);
        this.mContext = context;
        mResource=resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        String companyName=getItem(position).getCompanyName().toString();
        String email=getItem(position).getEmail().toString();
        String phnum=getItem(position).getPhnum().toString();
        String companyAddress=getItem(position).getCompanyAddress().toString();
        String companyZip=getItem(position).getCompanyZip().toString();
        String passWord=getItem(position).getPassWord().toString();
        String retailerId=getItem(position).getRetailerId().toString();
        String serviceType=getItem(position).getServiceType().toString();
        String username=getItem(position).getUsername().toString();

        RecyclerViewAdapter vendor=new RecyclerViewAdapter(companyAddress,companyName,companyZip,email,passWord,phnum,retailerId,serviceType,username);
        LayoutInflater inflater=LayoutInflater.from(mContext);
        convertView=inflater.inflate(mResource,parent, false);
        TextView name1=(TextView) convertView.findViewById(R.id.vendorinfo);
        TextView email2=(TextView) convertView.findViewById(R.id.vendorinfo1);
        TextView phone3=(TextView) convertView.findViewById(R.id.vendorinfo2);
        TextView address=(TextView) convertView.findViewById(R.id.vendorinfo3);

        name1.setText(companyName);
        email2.setText(email);
        phone3.setText(phnum);
        address.setText(companyAddress);
        return convertView ;
    }
}
