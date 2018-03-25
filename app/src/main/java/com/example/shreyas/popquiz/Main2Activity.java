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

public class Main2Activity extends AppCompatActivity {
    private EditText EmailET3,PasswordET3;
    private Button LoginET2,RegisterET3;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final EditText EmailET3 = findViewById(R.id.EmailET3);
        final EditText PasswordET3 = findViewById(R.id.PasswordET3);
        final Button LoginET2 = findViewById(R.id.LoginET2);
        Button RegisterET3 = findViewById(R.id.RegisterET3);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog =new ProgressDialog(this);

        RegisterET3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(Main2Activity.this,Register2Activity.class);
                Main2Activity.this.startActivity(registerIntent);
            }
        });

        LoginET2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Email = EmailET3.getText().toString().trim();
                String Password = PasswordET3.getText().toString().trim();

                if (TextUtils.isEmpty(Email)) {
                    //email is empty
                    Toast.makeText(Main2Activity.this, "Please enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (TextUtils.isEmpty(Password)) {
                    //password is empty
                    Toast.makeText(Main2Activity.this, "Please enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressDialog.setMessage("Logging User");
                progressDialog.show();

                firebaseAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(Main2Activity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),"Log in Successfully",Toast.LENGTH_SHORT).show();
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
