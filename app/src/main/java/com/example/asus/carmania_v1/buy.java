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
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class buy extends AppCompatActivity {

    private DatabaseReference mDatabase;

    //private RecyclerView mAdList;
    //private ArrayList<String> mAds = new ArrayList<>();
   // private ArrayList<String> mKeys = new ArrayList<>();

    private ArrayList<Ads> mAdList;
    private RecyclerView recyclerView;
    private Custom_adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);


        recyclerView = (RecyclerView)findViewById(R.id.myRecycler);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Ad");
        mDatabase.keepSynced(true);
        mAdapter = new Custom_adapter(mAdList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdList = new ArrayList<Ads>();

        mDatabase.addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(DataSnapshot dataSnapshot) {
                                                mAdList = new ArrayList<>();
                                                mAdapter = new Custom_adapter(mAdList);
                                                recyclerView.setAdapter(mAdapter);
                                                // StringBuffer stringbuffer = new StringBuffer();
                                                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                                                    Ads ads = new Ads();
                                                    ads.setCarName(dataSnapshot1.child("carName").getValue().toString());
                                                    ads.setCarType(dataSnapshot1.child("carType").getValue().toString());
                                                    ads.setEngineCapacity(dataSnapshot1.child("engineCapacity").getValue().toString());
                                                    ads.setModel(dataSnapshot1.child("model").getValue().toString());
                                                    ads.setColor(dataSnapshot1.child("color").getValue().toString());
                                                    ads.setSeatCapacity(dataSnapshot1.child("seatCapacity").getValue().toString());
                                                    ads.setPrice(dataSnapshot1.child("price").getValue().toString());
                                                    ads.setPhone(dataSnapshot1.child("phone").getValue().toString());
                                                    ads.setImageurl(dataSnapshot1.child("imageurl").getValue().toString());


                                                    //Picasso.get().load(ads.getImageurl()).into();

                                                 // Ads ads = dataSnapshot1.getValue(Ads.class);
                                                   /* Ads ads = new Ads();
                                                    String carName = Ads.getCarName();
                                                    String carType = Ads.getCarType();
                                                    String engineCapacity = Ads.getEngineCapacity();
                                                    String model = Ads.getModel();
                                                    String color = Ads.getColor();
                                                    String seatCapacity = Ads.getSeatCapacity();
                                                    String price = Ads.getPrice();
                                                    Ads.setCarName(carName);
                                                    Ads.setCarType(carType);
                                                    Ads.setEngineCapacity(engineCapacity);
                                                    Ads.setModel(model);
                                                    Ads.setColor(color);
                                                    Ads.setSeatCapacity(seatCapacity);
                                                    Ads.setPrice(price);*/
                                                    mAdList.add(ads);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                                    Toast.makeText(buy.this,"something wrong",Toast.LENGTH_SHORT).show();
                                            }

                                        });


                }

    @Override
    protected void onStart() {
        super.onStart();
    }

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




