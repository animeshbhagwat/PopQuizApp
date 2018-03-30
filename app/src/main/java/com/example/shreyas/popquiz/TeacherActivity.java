package com.example.shreyas.popquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TeacherActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private EditText QuestionET, AnswerAET, AnswerBET, AnswerCET, AnswerDET, CorrectET;
    private DatabaseReference databaseReference;
    private Button AddET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        QuestionET = (EditText) findViewById(R.id.QuestionET);
        AnswerAET = (EditText) findViewById(R.id.AnswerAET);
        AnswerBET = (EditText) findViewById(R.id.AnswerBET);
        AnswerCET = (EditText) findViewById(R.id.AnswerCET);
        AnswerDET = (EditText) findViewById(R.id.AnswerDET);
        CorrectET = (EditText) findViewById(R.id.CorrectET);
        AddET = (Button) findViewById(R.id.AddET);
        databaseReference = FirebaseDatabase.getInstance().getReference("questions");

        AddET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question = QuestionET.getText().toString().trim();
                String answerA = AnswerAET.getText().toString().trim();
                String answerB = AnswerBET.getText().toString().trim();
                String answerC = AnswerCET.getText().toString().trim();
                String answerD = AnswerDET.getText().toString().trim();
                String correct = CorrectET.getText().toString().trim();

                if (!TextUtils.isEmpty(question)) {
                    String id =databaseReference.push().getKey();
                    QuizActivity quizActivity = new QuizActivity(id,question,answerA,answerB,answerC,answerD,correct);
                    databaseReference.child(id).setValue(quizActivity);
                    Toast.makeText(TeacherActivity.this, "Question Added", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(TeacherActivity.this, "please add question", Toast.LENGTH_SHORT).show();
                }

            }

        });
    }
}



