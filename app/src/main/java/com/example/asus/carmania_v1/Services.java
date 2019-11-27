package com.example.asus.carmania_v1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.example.asus.carmania_v1.dataBaseManage.databaseHealper;
import com.example.asus.carmania_v1.modelClass.Users;

public class Services extends AppCompatActivity {

    databaseHealper dbHealper;
    Users user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        dbHealper = new databaseHealper(Services.this);


    }

    public void Buy(View view) {
        Intent intent3 = new Intent(Services.this,buy.class);
        startActivity(intent3);
        finish();
    }

    public void Sell(View view) {
        Intent intent = new Intent(Services.this,Sell.class);
        startActivity(intent);
        finish();
    }
    public void Rent(View view) {
        Intent intent2 = new Intent(Services.this,RentServices.class);
        startActivity(intent2);
        finish();
    }
    public void Repair(View view) {
        Intent intent1 = new Intent(Services.this,Repair.class);
        startActivity(intent1);
        finish();
    }

    public void GetInfoUser(View view) {
        Users u = dbHealper.getUserInfo();

        AlertDialog.Builder dialog = new AlertDialog.Builder(Services.this);
        dialog.setTitle("User Details").setMessage(u.toString());
        dialog.setCancelable(false);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        dialog.show();

    }
}
