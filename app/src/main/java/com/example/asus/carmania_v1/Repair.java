package com.example.asus.carmania_v1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.asus.carmania_v1.modelClass.shop_list_adapter;
import com.example.asus.carmania_v1.modelClass.shops;

import java.util.ArrayList;
import java.util.List;

public class Repair extends AppCompatActivity {

    private ListView mshop;
    private shop_list_adapter adapter;
    private List<shops> mShopsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair);

        mshop = (ListView)findViewById(R.id.shoplist);
        mShopsList = new ArrayList<>();
        mShopsList.add(new shops("Vehicle Solution","Solmaid","01882096479"));
        mShopsList.add(new shops("Beacon Auto Solution Company","Cocacola Road, Vatara, Baridhara","01733077657"));

        mShopsList.add(new shops("Shawon Automobiles","Solmaid","01711541223"));
        mShopsList.add(new shops("Auto Express Ltd","Kuwaiti Mosque Road, vatara","01973319900"));
        mShopsList.add(new shops("USA Auto Service Center","Kuwaiti Mosque Road, Vatara","01754756185"));
        mShopsList.add(new shops("A1 Auto Center","Kuwaiti Mosque Road, vatara","01819199499"));
        mShopsList.add(new shops("Touch Automobile Spa","Cocacola Road, Vatara","01610466634"));
        mShopsList.add(new shops("Zaara Trading & Vista Auto","Cocacola Road, Vatara","01818330763"));



        adapter = new shop_list_adapter(getApplicationContext(),mShopsList);
        mshop.setAdapter(adapter);

        mshop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"clicked",Toast.LENGTH_LONG).show();
            }
        });

    }
}
