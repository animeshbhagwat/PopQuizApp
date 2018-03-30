package com.example.shreyas.popquiz;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private EditText EmailET,PasswordET;
    private Button LoginET,RegisterET;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText EmailET = findViewById(R.id.EmailET);
         final EditText PasswordET = findViewById(R.id.PasswordET);
         final Button LoginET = findViewById(R.id.LoginET);
         Button RegisterET = findViewById(R.id.RegisterET);
         firebaseAuth = FirebaseAuth.getInstance();
        progressDialog =new ProgressDialog(this);

        RegisterET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(MainActivity.this,RegisterActivity.class);
                MainActivity.this.startActivity(registerIntent);
            }
        });

        LoginET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Email = EmailET.getText().toString().trim();
                String Password = PasswordET.getText().toString().trim();

                if (TextUtils.isEmpty(Email)) {
                    //email is empty
                    Toast.makeText(MainActivity.this, "Please enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (TextUtils.isEmpty(Password)) {
                    //password is empty
                    Toast.makeText(MainActivity.this, "Please enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressDialog.setMessage("Logging User");
                progressDialog.show();

                firebaseAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Intent mainIntent = new Intent(MainActivity.this,StudentActivity.class);
                            startActivity(mainIntent);
                            progressDialog.dismiss();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"could not log in",Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }

                    }
                });

            }
        });


    }
    }

