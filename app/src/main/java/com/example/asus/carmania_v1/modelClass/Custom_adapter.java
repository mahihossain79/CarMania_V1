package com.example.asus.carmania_v1.modelClass;

import android.content.Context;
import android.graphics.Movie;
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
import java.util.List;
import java.util.zip.Adler32;

public class Custom_adapter extends RecyclerView.Adapter<Custom_adapter.MyViewHolder> {
    Context context;
    private ArrayList<Ads> adList;

    public Custom_adapter(ArrayList<Ads> ads) {

        adList = ads;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mCarName,mCarType,mEngineCapacity,mModel,mColor,mSeatCapacity,mPrice, mPhone;
        public ImageView mImage;
        public MyViewHolder(View view) {
            super(view);
            mCarName =(TextView)view.findViewById(R.id.carNameshow);
            mCarType =(TextView)view.findViewById(R.id.cartypeshow);
            mEngineCapacity =(TextView)view.findViewById(R.id.engineCapacityshow);
            mModel =(TextView)view.findViewById(R.id.modelshow);
            mColor =(TextView)view.findViewById(R.id.colorshow);
            mSeatCapacity =(TextView)view.findViewById(R.id.seatCapacityshow);
            mPrice= (TextView)view.findViewById(R.id.priceshow);
            mPhone = (TextView)view.findViewById(R.id.phoneshow);
            mImage= (ImageView)view.findViewById(R.id.post_image);

        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
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
