package com.example.asus.carmania_v1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

public class LoginWindow extends AppCompatActivity {

    EditText emailText,passText;

   // databaseHealper dbHealper;
    Users user;
    private FirebaseAuth mAuth;
    FirebaseDatabase mDatabase;
    DatabaseReference userRef;

    boolean key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_window);

        mDatabase = FirebaseDatabase.getInstance();
        userRef = mDatabase.getReference();
        mAuth = FirebaseAuth.getInstance();



        emailText = findViewById(R.id.email);
        passText = findViewById(R.id.password);

        //GetInfoUser();
    }

    /*private void authenticateData() {

        if(emailText.getText().toString().equals(user.getEmail()) && passText.getText().toString().equals(user.getPassword()))
        {
            key = true;
        }
        else
            key = false;

    }
*/
    private void showInfo() {
        Toast.makeText(this,"Email : " + emailText.getText() + "\npassword : " + passText.getText(),Toast.LENGTH_LONG).show();
    }

    public void login(View view) {

        //authenticateData();

        String email = emailText.getText().toString().trim();
        String password = passText.getText().toString().trim();


        if(email.isEmpty()){
            emailText.setError("Input field is Empty.");
        }else{
            if(password.isEmpty()){
                passText.setError("Input field is Empty.");
            }else{
                SignIn(email,password);
                Intent intent = new Intent(LoginWindow.this,Services.class);
                startActivity(intent);
                finish();

            }
        }

        /*if(key == true){

            Intent intent = new Intent(LoginWindow.this,Services.class);
            startActivity(intent);
            finish();
        }
        else{
            Toast.makeText(this,"Incorrect Email or Password",Toast.LENGTH_LONG).show();
        }*/
    }
    public void SignIn(String email, String password){

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){



                    FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;






                    Intent intent = new Intent(LoginWindow.this,Services.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "LogIn Successful.", Toast.LENGTH_LONG).show();
                    finish();

                }else {

                    Toast.makeText(getApplicationContext(), "Some Error Occured. Check Internet Connection.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

   /* public void GetInfoUser() {
        dbHealper = new databaseHealper(LoginWindow.this);
        user = dbHealper.getUserInfo();
    }*/
}
