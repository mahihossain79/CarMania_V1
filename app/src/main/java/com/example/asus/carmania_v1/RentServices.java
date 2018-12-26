package com.example.asus.carmania_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class RentServices extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_services);
    }

    public void SelfDriven(View view) {
        Intent intent2 = new Intent(RentServices.this,selfDriven.class);
        startActivity(intent2);
        finish();
    }

    public void RentACar(View view) {
        Intent intent = new Intent(RentServices.this,rent.class);
        startActivity(intent);
        finish();
    }

    public void GiveRent(View view) {
        Intent intent1 = new Intent(RentServices.this,GiveRent.class);
        startActivity(intent1);
        finish();
    }




    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            Intent intent = new Intent(RentServices.this,Services.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
