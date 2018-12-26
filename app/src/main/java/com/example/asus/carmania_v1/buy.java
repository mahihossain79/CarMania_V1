package com.example.asus.carmania_v1;

import android.content.Intent;
import android.graphics.Movie;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.carmania_v1.modelClass.Custom_adapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class buy extends AppCompatActivity {

    private DatabaseReference mDatabase;
    //private RecyclerView mAdList;
    //private ArrayList<String> mAds = new ArrayList<>();
   // private ArrayList<String> mKeys = new ArrayList<>();

    private List<Ads> mAdList = new ArrayList<>();
    private RecyclerView recyclerView;
    private Custom_adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Ad");
        mDatabase.keepSynced(true);
        mAdapter = new Custom_adapter(mAdList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);

    }

   /* @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Ads,AdsViewHolder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<Ads,AdsViewHolder>
                (Ads.class,R.layout.custom_layout,AdsViewHolder.class,mDatabase){
            @Override
            protected void populateViewHolder(AdsViewHolder viewHolder, Ads model, int position) {
                viewHolder.setCarName(model.getCarName());
                viewHolder.setCarType(model.getCarType());
                viewHolder.setColor(model.getColor());
                viewHolder.setEngineCapacity(model.getEngineCapacity());
                viewHolder.setModel(model.getModel());
                viewHolder.setPrice(model.getPrice());
                viewHolder.setSeatCapacity(model.getSeatCapacity());
            }

        };
        mAdList.setAdapter(firebaseRecyclerAdapter);
    }

    public static class AdsViewHolder extends RecyclerView.ViewHolder {
        View mView;
        public AdsViewHolder(View itemView){
            super(itemView);
            mView = itemView;
        }
        public void setCarName(String carName){
            TextView mCarName =(TextView)mView.findViewById(R.id.carNameshow);
            mCarName.setText(carName);
        }

        void setCarType(String carType){
            TextView mCarType =(TextView)mView.findViewById(R.id.cartypeshow);
            mCarType.setText(carType);
        }

        public void setColor(String color){
            TextView mColor = (TextView)mView.findViewById(R.id.colorshow);
            mColor.setText(color);
        }
        public void setEngineCapacity(String engineCapacity){
            TextView mEngineCapacity = (TextView)mView.findViewById(R.id.engineCapacityshow);
            mEngineCapacity.setText(engineCapacity);
        }
        public void setModel(String model){
            TextView mModel = (TextView)mView.findViewById(R.id.modelshow);
            mModel.setText(model);
        }
        public void setSeatCapacity(String seatCapacity)
        {
            TextView mSeatCapacity = (TextView)mView.findViewById(R.id.seatCapacityshow);
            mSeatCapacity.setText(seatCapacity);
        }
        public void setPrice(String price)
        {
            TextView mPrice = (TextView)mView.findViewById(R.id.priceshow );
            mPrice.setText(price);
        }
    }
*/
    //mDatabase.addChildEventListener(new ChildEventListener() {

    //@Override

    //public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

    //try{

    //String carType = dataSnapshot.getValue(String.class);

    //String carName = dataSnapshot.getValue(String.class);

    //String engineCapacity = dataSnapshot.getValue(String.class);

    //String model = dataSnapshot.getValue(String.class);

    //String color = dataSnapshot.getValue(String.class);

    //String seatCapacity = dataSnapshot.getValue(String.class);

    //String price = dataSnapshot.getValue(String.class);

    //

    //

    //mAds.add(carType);

    //mAds.add(carName);

    //mAds.add(engineCapacity);

    //mAds.add(model);

    //mAds.add(color);

    //mAds.add(seatCapacity);

    //mAds.add(price);

    //arrayAdapter.notifyDataSetChanged();

    //

    //String key = dataSnapshot.getKey();

    //mKeys.add(key);

    //} catch (Exception e) {

    //Toast.makeText(buy.this, "unsuccessful", Toast.LENGTH_LONG).show();

    //}

    //}

    //

    //

    //

    //@Override

    //public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

    //// String value = dataSnapshot.getValue(String.class);

    //

    //// arrayAdapter.notifyDataSetChanged();

    //

    //}

    //

    //@Override

    //public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

    //

    //}

    //

    //@Override

    //public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

    //

    //}

    //

    //@Override

    //public void onCancelled(@NonNull DatabaseError databaseError) {

    //

    //}

    //});

    //}

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            Intent intent = new Intent(buy.this,Services.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

}
