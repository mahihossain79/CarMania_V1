package com.example.asus.carmania_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Self_Driven_Rent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self__driven__rent);
    }

    public void Submit(View view) {
        Toast.makeText(getApplicationContext(),"Your Rent request in being processed." +
                " You will be notified shortly",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Self_Driven_Rent.this,Services.class);
        startActivity(intent);
        finish();
    }



}
