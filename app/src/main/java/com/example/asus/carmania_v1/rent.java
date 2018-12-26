package com.example.asus.carmania_v1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class rent extends AppCompatActivity {

    private DatabaseReference mDatabase;
    EditText mRentDate,mPickUp,mDestination,mTime,mSeatCapacity,mContact;
    Spinner mcartype;
    Button mRentSubmit;
    static int key = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mcartype = (Spinner)findViewById(R.id.rentCarType);
        mRentDate =(EditText)findViewById(R.id.rentDate);
        mPickUp=(EditText)findViewById(R.id.from);
        mDestination=(EditText)findViewById(R.id.destination);
        mTime= (EditText)findViewById(R.id.pickUpTime);
        mSeatCapacity = (EditText)findViewById(R.id.seatCapacity);
        mContact =(EditText)findViewById(R.id.contact);

        mRentSubmit=(Button)findViewById(R.id.rentSubmit);
        mRentSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String carType = mcartype.getSelectedItem().toString().trim();
                String rentDate = mRentDate.getText().toString().trim();
                String pickUp = mPickUp.getText().toString().trim();
                String destination =mDestination.getText().toString().trim();
                String time = mTime.getText().toString().trim();
                String seatCapacity = mSeatCapacity.getText().toString().trim();
                String contact = mContact.getText().toString().trim();


                HashMap<String, String> datamap = new HashMap<String, String>();
                datamap.put("Car Type", carType);
                datamap.put("Rent Date", rentDate);
                datamap.put("Pick Up Location", pickUp);
                datamap.put("Destination", destination);
                datamap.put("Pick Up Time",time);
                datamap.put("Seat Capacity", seatCapacity);
                datamap.put("Contact Number",contact);


                mDatabase.child("Rent Request").child(Integer.toString(key)).setValue(datamap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            key++;
                            Toast.makeText(rent.this,"Your Rent request in being processed." +
                                    "You will be notified shortly",Toast.LENGTH_LONG).show();
                            Intent i = new Intent(rent.this,RentServices.class);
                            startActivity(i);
                            finish();
                        }
                        else {
                            Toast.makeText(rent.this,"Your Ad is not Posted",Toast.LENGTH_LONG).show();
                        }
                    }
                });


            }
        });


        String[] carTypes = new String[]{"Select Car Type","Sedan","Microbus","Wagon","Hatchback"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, carTypes);
        mcartype.setAdapter(adapter);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            Intent intent = new Intent(rent.this,Services.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
