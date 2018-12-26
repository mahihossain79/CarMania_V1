package com.example.asus.carmania_v1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.BitSet;
import java.util.HashMap;

public class selfDriven extends AppCompatActivity {

    DatabaseReference mDatabase;
    EditText mFirstName,mLastName,mPhoneNumber,mEmail,mAddress,mNid,mDrivingLicense,mTin;
    Button mselfSubmit,mSelectNidImage,mSelectDLImage;
    ImageView mNidImage,mDLImage;
    private int REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_driven);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mFirstName = (EditText)findViewById(R.id.firstName);
        mLastName = (EditText)findViewById(R.id.lastName);
        mPhoneNumber= (EditText)findViewById(R.id.phoneNumber);
        mEmail=(EditText)findViewById(R.id.selfdriveEmail);
        mAddress=(EditText)findViewById(R.id.address);
        mNid=(EditText)findViewById(R.id.nid);
        mDrivingLicense=(EditText)findViewById(R.id.drivingLicense);
        mTin=(EditText)findViewById(R.id.tin);
        mselfSubmit=(Button)findViewById(R.id.selfsubmit);
        mSelectNidImage = (Button) findViewById(R.id.selectNidImage);
        mSelectDLImage =(Button)findViewById(R.id.selectDLImage);
        mNidImage=(ImageView)findViewById(R.id.nidImage);
        mDLImage=(ImageView)findViewById(R.id.dLImage);

        pickImage();


        mselfSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = mFirstName.getText().toString().trim();
                String lastName = mLastName.getText().toString().trim();
                String phoneNumber = mPhoneNumber.getText().toString().trim();
                String email = mEmail.getText().toString().trim();
                String address = mAddress.getText().toString().trim();
                String nid = mNid.getText().toString().trim();
                String drivingLicense = mDrivingLicense.getText().toString().trim();
                String tin = mTin.getText().toString().trim();


                HashMap<String,String> datamap = new HashMap<String, String>();
                datamap.put("First Name",firstName);
                datamap.put("Last Name",lastName);
                datamap.put("Phone Number",phoneNumber);
                datamap.put("Email",email);
                datamap.put("Address",address);
                datamap.put("NID",nid);
                datamap.put("Driving License",drivingLicense);
                datamap.put("TIN",tin);



                mDatabase.child("User Info").push().setValue(datamap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(selfDriven.this,"Your information is saved",Toast.LENGTH_LONG).show();
                            Intent i = new Intent(selfDriven.this,Services.class);
                            startActivity(i);
                            finish();
                        }
                        else {
                            Toast.makeText(selfDriven.this,"Your info is not saved",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });



    }




    public void pickImage(){
        mSelectNidImage.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent intent = new Intent();
                                                intent.setType("image/*");
                                                intent.setAction(Intent.ACTION_GET_CONTENT);
                                                startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUEST_CODE);
                                            }
                                        }
        );
        mSelectDLImage.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   Intent intent2 = new Intent();
                                                   intent2.setType("image/*");
                                                   intent2.setAction(Intent.ACTION_GET_CONTENT);
                                                   startActivityForResult(Intent.createChooser(intent2, "Select Picture"), REQUEST_CODE);
                                               }
                                           }
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && null != data) {
            try{
                final Uri uriImage = data.getData();
                final InputStream inputStream = getContentResolver().openInputStream(uriImage);
                final Bitmap imageMap = BitmapFactory.decodeStream(inputStream);
                final Uri uriImage2 = data.getData();
                final InputStream inputStream2 = getContentResolver().openInputStream(uriImage2);
                final Bitmap imageMap2 = BitmapFactory.decodeStream(inputStream2);
                mNidImage.setImageBitmap(imageMap);
                mDLImage.setImageBitmap(imageMap2);

            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(selfDriven.this, "Image was not found", Toast.LENGTH_SHORT).show();
            }

        }


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            Intent intent = new Intent(selfDriven.this,RentServices.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    public void Submit(View view) {
        Intent intent = new Intent(selfDriven.this,Self_Driven_Rent.class);
        startActivity(intent);
        finish();
    }

}
