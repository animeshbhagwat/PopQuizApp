package com.example.shreyas.popquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.Iterator;

public class StudentActivity extends AppCompatActivity {
    private Button AnswerA, AnswerB, AnswerC, AnswerD;
    private TextView ScoreTV, QuestionTV;
    private int score = 0;
    private String answer;
    private DatabaseReference firebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        firebaseDatabase = FirebaseDatabase.getInstance().getReference();
        ScoreTV = (TextView) findViewById(R.id.ScoreTV);
        QuestionTV = (TextView) findViewById(R.id.QuestionTV);
        AnswerA = (Button) findViewById(R.id.AnswerA);
        AnswerB = (Button) findViewById(R.id.AnswerB);
        AnswerC = (Button) findViewById(R.id.AnswerC);
        AnswerD = (Button) findViewById(R.id.AnswerD);

        updateQuestion();
        AnswerA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AnswerA.getText().equals(answer)) {
                    score = score + 1;
                    updateScore(score);
                    updateQuestion();
                } else {
                    updateQuestion();
                }
            }
        });


        AnswerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AnswerB.getText().equals(answer)) {
                    score = score + 1;
                    updateScore(score);
                    updateQuestion();
                } else {
                    updateQuestion();
                }

            }
        });

        AnswerC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AnswerC.getText().equals(answer)) {
                    score = score + 1;
                    updateScore(score);
                    updateQuestion();
                } else {
                    updateQuestion();
                }
            }
        });

        AnswerD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AnswerD.getText().equals(answer)) {
                    score = score + 1;
                    updateScore(score);
                    updateQuestion();
                } else {
                    updateQuestion();
                }
            }
        });

    }

    public void updateQuestion() {
        firebaseDatabase.child("questions").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterator<DataSnapshot> items = dataSnapshot.getChildren().iterator();
                while (items.hasNext()) {
                    DataSnapshot item = items.next();
                    String question, answerA, answerB, answerC, answerD, correct;
                    question = item.child("question").getValue().toString();
                    answerA = item.child("answerA").getValue().toString();
                    answerB = item.child("answerB").getValue().toString();
                    answerC = item.child("answerC").getValue().toString();
                    answerD = item.child("answerD").getValue().toString();
                    correct = item.child("correct").getValue().toString();


                    QuestionTV.setText(question);
                    AnswerA.setText(answerA);
                    AnswerB.setText(answerB);
                    AnswerC.setText(answerC);
                    AnswerD.setText(answerD);
                    answer = correct;
                    firebaseDatabase.child("questions").removeEventListener(this);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    private void updateScore(int score) {
        ScoreTV.setText("" + score);
    }
}

