package com.example.shreyas.popquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText RollET = (EditText) findViewById(R.id.RollET);
        final EditText PasswordET = (EditText) findViewById(R.id.PasswordET);
        final Button LoginET = (Button) findViewById(R.id.LoginET);
        final Button RegisterET = (Button) findViewById(R.id.RegisterET);

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
                Intent registerIntent = new Intent(MainActivity.this,QuizActivity.class);
                MainActivity.this.startActivity(registerIntent);
            }
        });
    }
}
