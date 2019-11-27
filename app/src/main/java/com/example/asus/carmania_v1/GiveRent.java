package com.example.asus.carmania_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.asus.carmania_v1.modelClass.Custom_adapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class GiveRent extends AppCompatActivity {


    private DatabaseReference mDatabase;
    private StorageReference mStorage;
    EditText mcarName, mengineCapacity, mmodel, mcolor, mseatCapacity, mprice, mphone;
    Spinner mcartype;
    private Button msellSubmit;
    private Button mSelectImage;
    private ImageView mItemImage;
    private int REQUEST_CODE = 1;
    private String mimageURL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_rent);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            Intent intent = new Intent(GiveRent.this,RentServices.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
