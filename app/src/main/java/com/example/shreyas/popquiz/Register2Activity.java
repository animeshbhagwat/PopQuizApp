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

public class Register2Activity extends AppCompatActivity {
    private EditText EmailET4,PasswordET4;
    private Button RegisterET4;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        final EditText EmailET4 = findViewById(R.id.EmailET4);
        EditText NameET = findViewById(R.id.NameET);
        final EditText PasswordET4 = findViewById(R.id.PasswordET4);
        Button RegisterET4 = findViewById(R.id.ResgiterET4);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog =new ProgressDialog(this);




        RegisterET4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Email = EmailET4.getText().toString().trim();
                String Password = PasswordET4.getText().toString().trim();

                if (TextUtils.isEmpty(Email)) {
                    //email is empty
                    Toast.makeText(Register2Activity.this, "Please enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (TextUtils.isEmpty(Password)) {
                    //password is empty
                    Toast.makeText(Register2Activity.this, "Please enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressDialog.setMessage("Registering User");
                progressDialog.show();

                firebaseAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(Register2Activity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_SHORT).show();
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
