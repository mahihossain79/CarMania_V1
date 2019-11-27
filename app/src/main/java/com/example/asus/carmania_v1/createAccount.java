package com.example.asus.carmania_v1;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asus.carmania_v1.dataBaseManage.databaseHealper;
import com.example.asus.carmania_v1.modelClass.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class createAccount extends AppCompatActivity {

    EditText firstName,lastName,phoneNumber,email,password,confirmPassword;
    private FirebaseAuth mAuth;
    FirebaseDatabase database;
    DatabaseReference userRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        userRef = database.getReference();
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        phoneNumber = findViewById(R.id.phoneNumber);
        email = findViewById(R.id.newEmail);
        password= findViewById(R.id.newPassword);
        confirmPassword = findViewById(R.id.confirmPassword);

        /*dbHealper = new databaseHealper(createAccount.this);*/
    }

    /*private void dataEntryMethod() {

        try {
            String FirstName = firstName.getText().toString();
            String LastName = lastName.getText().toString();
            String Email = email.getText().toString();
            String Password = password.getText().toString();
            String ConfirmPassword = confirmPassword.getText().toString();
            String Phone = phoneNumber.getText().toString();

            user = new Users(FirstName,LastName,Email,Password,Phone);

            dbHealper.dataEntry(user);
            Toast.makeText(this,"successfull",Toast.LENGTH_LONG).show();

        }catch (Exception e)
        {
            Toast.makeText(this,"error",Toast.LENGTH_LONG).show();
        }

    }*/

    //
    private void validationData() {
        int flag = 0;
        String FirstName = firstName.getText().toString().trim();
        String LastName = lastName.getText().toString().trim();
        String Email = email.getText().toString().trim();
        String Password = password.getText().toString().trim();
        String ConfirmPassword = confirmPassword.getText().toString().trim();
        String Phone = phoneNumber.getText().toString().trim();

        if(!Password.equals(ConfirmPassword)){
            password.setError("Password don't match!!");
            flag=1;
        }
        else if(FirstName.isEmpty()){
            firstName.setError("Please Enter your Name!!!");
            flag=1;
        }



        if(flag==0){
           Users user = new Users(FirstName,LastName,Email,Password,Phone);
            SignUp(user);
        }
    }

    private void SignUp(final Users user) {

        mAuth.createUserWithEmailAndPassword(user.getEmail(), user.getPassword())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.i("status","working fine");
                            SharedPreferences.Editor editor = (SharedPreferences.Editor) getSharedPreferences("Userdata", MODE_PRIVATE);
                            SignIn(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.i("status: ", "failed");
                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });

    }

    private void SignIn(final Users user) {
        mAuth.signInWithEmailAndPassword(user.getEmail(), user.getPassword())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();

                            SharedPreferences preferences = getSharedPreferences("Profile Preferences", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("UserUid", currentFirebaseUser.getUid());
                            editor.commit();
                            editor.putString("Email", user.getEmail());
                            editor.commit();
                            editor.putString("Name", user.getFirstName()+" "+user.getLastName());
                            editor.commit();
                            editor.putString("Phone", user.getPhone());
                            editor.commit();

                            String Key = currentFirebaseUser.getUid();
                            SavetoFireBaseDB(user, Key);
                            Intent intent = new Intent(getApplicationContext(), Services.class);
                            startActivity(intent);
                            Toast.makeText(getApplicationContext(), "Log In Successful.", Toast.LENGTH_LONG).show();
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getApplicationContext(), "Log In Error.", Toast.LENGTH_LONG).show();
                        }

                        // ...
                    }
                });

    }

    private void SavetoFireBaseDB(Users user, String key) {
        userRef.child("user").child(key).setValue(user);
    }

    public void Register(View view) {

        //dataEntryMethod();
        validationData();
        /*Intent intent = new Intent(createAccount.this,Services.class);
        startActivity(intent);
        finish();*/

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            Intent intent = new Intent(createAccount.this,initWindow.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
