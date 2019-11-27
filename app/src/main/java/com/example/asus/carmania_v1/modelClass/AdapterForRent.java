package com.example.asus.carmania_v1.modelClass;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.carmania_v1.Ads;
import com.example.asus.carmania_v1.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterForRent  extends RecyclerView.Adapter<Custom_adapter.MyViewHolder> {
    Context context;
    private ArrayList<RentAds> rentAdList;

    public AdapterForRent(ArrayList<RentAds> rentAds) {

        rentAdList = rentAds;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mCarName,mCarType,mSeatCapacity,mlocation, mPhone;
        public ImageView mImage;
        public MyViewHolder(View view) {
            super(view);
            mCarName =(TextView)view.findViewById(R.id.carNameRent);
            mCarType =(TextView)view.findViewById(R.id.cartypeRent);
            mSeatCapacity =(TextView)view.findViewById(R.id.seatCapacityRent);
            mlocation= (TextView)view.findViewById(R.id.locationRent);
            mPhone = (TextView)view.findViewById(R.id.phoneRent);
            mImage= (ImageView)view.findViewById(R.id.post_image_rent);

        }
    }


    @Override
    public Custom_adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_for_rental, parent, false);

        return MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(Custom_adapter.MyViewHolder holder, int position) {
        Ads Ad = adList.get(position);
        holder.mCarName.setText(Ad.getCarName());
        holder.mCarType.setText("Car Type: "+Ad.getCarType());
        holder.mEngineCapacity.setText("Engine Capacity:" +Ad.getEngineCapacity());
        holder.mModel.setText("Model: " +Ad.getModel());
        holder.mColor.setText("Color: "+Ad.getColor());
        holder.mSeatCapacity.setText("Seat Capacity: "+Ad.getSeatCapacity());
        holder.mPrice.setText("Price: "+Ad.getPrice());
        holder.mPhone.setText("Contact: "+Ad.getPhone());
        Picasso.get().load(adList.get(position).getImageurl()).into(holder.mImage);
    }

    @Override
    public int getItemCount() {
        return adList.size();
    }
}

