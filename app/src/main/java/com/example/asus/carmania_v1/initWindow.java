package com.example.asus.carmania_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class initWindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init_window);


    }

    public void Login(View view) {
        Intent intent = new Intent(initWindow.this,LoginWindow.class);
        startActivity(intent);
        finish();
    }

    public void newAccount(View view) {
        Intent intent2 = new Intent(initWindow.this,createAccount.class);
        startActivity(intent2);
        finish();
    }

    public void aboutUs(View view) {
        //Toast.makeText(this,"Designed by CSE-299 Group-9",Toast.LENGTH_LONG).show();
        Intent intent3 = new Intent(initWindow.this,aboutUs.class);
        startActivity(intent3);
        finish();
    }
}
