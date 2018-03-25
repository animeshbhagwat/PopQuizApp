package com.example.shreyas.popquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainPageActivity extends AppCompatActivity {
    private Button teacherET,studentET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

         studentET =(Button) findViewById(R.id.studentET);
         teacherET =(Button) findViewById(R.id.teacherET);

        studentET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(MainPageActivity.this,MainActivity.class);
                MainPageActivity.this.startActivity(registerIntent);
            }
        });

        teacherET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(MainPageActivity.this,Main2Activity.class);
                MainPageActivity.this.startActivity(registerIntent);
            }
        });


    }
}
