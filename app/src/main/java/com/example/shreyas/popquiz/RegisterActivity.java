package com.example.shreyas.popquiz;

import android.app.ProgressDialog;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    private EditText EmailET, RollET, PasswordET2;
    private Button RegisterET2;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText EmailET2 = findViewById(R.id.EmailET2);
        final EditText RollET = findViewById(R.id.RollET2);
        final EditText PasswordET2 = findViewById(R.id.PasswordET2);
        Button RegisterET2= findViewById(R.id.RegisterET2);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog =new ProgressDialog(this);
        databaseReference = FirebaseDatabase.getInstance().getReference("student");

        RegisterET2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String Email = EmailET2.getText().toString().trim();
                String Password = PasswordET2.getText().toString().trim();
                final String rollNo = RollET.getText().toString().trim();

                if (TextUtils.isEmpty(Email)) {
                    //email is empty
                    Toast.makeText(RegisterActivity.this, "Please enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (TextUtils.isEmpty(Password)) {
                    //password is empty
                    Toast.makeText(RegisterActivity.this, "Please enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressDialog.setMessage("Registering User");
                progressDialog.show();

                firebaseAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            String id =databaseReference.push().getKey();
                            Student student=new Student(id,rollNo,Email);
                            databaseReference.child(id).setValue(student);
                            progressDialog.dismiss();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"could not registerd",Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }

                    }
                });

            }
        });

       }

      }


