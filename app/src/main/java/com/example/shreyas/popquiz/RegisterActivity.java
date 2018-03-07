package com.example.shreyas.popquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText NameET = (EditText) findViewById(R.id.NameET);
        final EditText RollET2 = (EditText) findViewById(R.id.RollET2);
        final EditText PasswordET2 = (EditText) findViewById(R.id.PasswordET2);
        final Button RegisterET2 = (Button) findViewById(R.id.ResgiterET2);
    }
}
