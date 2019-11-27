package com.example.asus.carmania_v1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

public class Sell extends AppCompatActivity {

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
        setContentView(R.layout.activity_sell);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mStorage = FirebaseStorage.getInstance().getReference();
        mcartype = (Spinner) findViewById(R.id.cartype);
        mcarName = (EditText) findViewById(R.id.carName);
        mengineCapacity = (EditText) findViewById(R.id.engineCapacity);
        mmodel = (EditText) findViewById(R.id.model);
        mcolor = (EditText) findViewById(R.id.color);
        mseatCapacity = (EditText) findViewById(R.id.seatCapacity);
        mprice = (EditText) findViewById(R.id.price);


        mSelectImage = (Button) findViewById(R.id.button_selectpic);
        mItemImage = (ImageView) findViewById(R.id.itemImage);
        pickImage();
        mphone = (EditText) findViewById(R.id.phone);

        msellSubmit = (Button) findViewById(R.id.sellSubmit);
        msellSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String carType = mcartype.getSelectedItem().toString().trim();
                String carName = mcarName.getText().toString().trim();
                String engineCapacity = mengineCapacity.getText().toString().trim();
                String model = mmodel.getText().toString().trim();
                String color = mcolor.getText().toString().trim();
                String seatCapacity = mseatCapacity.getText().toString().trim();
                String price = mprice.getText().toString().trim();
              //  String imageurl = mimageURL;
                String phone = mphone.getText().toString().trim();

                HashMap<String, String> datamap = new HashMap<String, String>();
                datamap.put("carType", carType);
                datamap.put("carName", carName);
                datamap.put("engineCapacity", engineCapacity);
                datamap.put("model", model);
                datamap.put("color", color);
                datamap.put("seatCapacity", seatCapacity);
                datamap.put("price", price);
                datamap.put("imageurl", mimageURL);
                datamap.put("phone", phone);

                mDatabase.child("Ad").push().setValue(datamap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Sell.this, "Your Ad is Posted", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(Sell.this, Services.class);
                            startActivity(i);
                            finish();
                        } else {
                            Toast.makeText(Sell.this, "Your Ad is not Posted", Toast.LENGTH_LONG).show();
                        }
                    }
                });


            }
        });

        String[] items = new String[]{"Select Car Type", "Sedan", "SUV", "Wagon", "Microbus"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        mcartype.setAdapter(adapter);


    }

    public void pickImage() {
        mSelectImage.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent intent = new Intent();
                                                intent.setType("image/*");
                                                intent.setAction(Intent.ACTION_GET_CONTENT);
                                                startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUEST_CODE);
                                            }
                                        }
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && null != data) {
            try {

                final Uri uriImage = data.getData();
                final StorageReference filepath = mStorage.child("Photos").child(uriImage.getLastPathSegment());
                filepath.putFile(uriImage);
                filepath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        //Uri downloadUrl= uri;
                        mimageURL = uri.toString();
                        //+Log.e("mahi" ,mimageURL=String.valueOf(uri));
                    }
                });
                final InputStream inputStream = getContentResolver().openInputStream(uriImage);
                final Bitmap imageMap = BitmapFactory.decodeStream(inputStream);
                mItemImage.setImageBitmap(imageMap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(Sell.this, "Image was not found", Toast.LENGTH_SHORT).show();
            }

        }


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Intent intent = new Intent(Sell.this, Services.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }


}
