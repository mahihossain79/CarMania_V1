package com.example.asus.carmania_v1.modelClass;

import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.carmania_v1.Ads;
import com.example.asus.carmania_v1.R;

import java.util.List;
import java.util.zip.Adler32;

public class Custom_adapter extends RecyclerView.Adapter<Custom_adapter.MyViewHolder> {

    private List<Ads> adList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mCarName,mCarType,mEngineCapacity,mModel,mColor,mSeatCapacity,mPrice;

        public MyViewHolder(View view) {
            super(view);
            mCarName =(TextView)view.findViewById(R.id.carNameshow);
            mCarType =(TextView)view.findViewById(R.id.cartypeshow);
            mEngineCapacity =(TextView)view.findViewById(R.id.engineCapacityshow);
            mModel =(TextView)view.findViewById(R.id.modelshow);
            mColor =(TextView)view.findViewById(R.id.colorshow);
            mSeatCapacity =(TextView)view.findViewById(R.id.seatCapacityshow);
            mPrice= (TextView)view.findViewById(R.id.priceshow);


        }
    }


    public Custom_adapter(List<Ads> adList) {
        this.adList = adList;
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
        holder.mCarType.setText(Ad.getCarType());
        holder.mEngineCapacity.setText(Ad.getEngineCapacity());
        holder.mModel.setText(Ad.getModel());
        holder.mColor.setText(Ad.getColor());
        holder.mSeatCapacity.setText(Ad.getSeatCapacity());
        holder.mPrice.setText(Ad.getPrice());
    }

    @Override
    public int getItemCount() {
        return adList.size();
    }
}
