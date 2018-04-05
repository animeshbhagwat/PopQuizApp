package com.example.shreyas.popquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class StudentActivity extends AppCompatActivity {
    private Button AnswerA, AnswerB, AnswerC, AnswerD;
    private TextView ScoreTV, QuestionTV;
    private int score = 0;
    private int questionNo=100;
    private String answer;
    private DatabaseReference questionRef,answerARef,answerBRef,answerCRef,answerDRef,correctRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        ScoreTV = findViewById(R.id.ScoreTV);
        QuestionTV = findViewById(R.id.QuestionTV);
        AnswerA =  findViewById(R.id.AnswerA);
        AnswerB =  findViewById(R.id.AnswerB);
        AnswerC =  findViewById(R.id.AnswerC);
        AnswerD =  findViewById(R.id.AnswerD);

        updateQuestions();

        AnswerA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(AnswerA.getText().equals(answer)){
                    score=score+1;
                    updateScore(score);
                    updateQuestions();
                }
                else{
                    updateQuestions();
                }
            }
        });

        AnswerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(AnswerB.getText().equals(answer)){
                    score=score+1;
                    updateScore(score);
                    updateQuestions();
                }
                else{
                    updateQuestions();
                }
            }
        });

        AnswerC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(AnswerC.getText().equals(answer)){
                    score=score+1;
                    updateScore(score);
                    updateQuestions();
                }
                else{
                    updateQuestions();
                }
            }
        });

        AnswerD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(AnswerD.getText().equals(answer)){
                    score=score+1;
                    updateScore(score);
                    updateQuestions();
                }
                else{
                    updateQuestions();
                }
            }
        });

    }

    void updateQuestions(){
        questionRef = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://popquiz-fad55.firebaseio.com/questions/"+questionNo+"/question");

        questionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String question =dataSnapshot.getValue(String.class);
                QuestionTV.setText(question);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        answerARef = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://popquiz-fad55.firebaseio.com/questions/"+questionNo+"/answerA");
        answerARef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice =dataSnapshot.getValue(String.class);
                AnswerA.setText(choice);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        answerBRef = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://popquiz-fad55.firebaseio.com/questions/"+questionNo+"/answerB");
        answerBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice =dataSnapshot.getValue(String.class);
                AnswerB.setText(choice);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        answerCRef = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://popquiz-fad55.firebaseio.com/questions/"+questionNo+"/answerC");
        answerCRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice =dataSnapshot.getValue(String.class);
                AnswerC.setText(choice);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        answerDRef = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://popquiz-fad55.firebaseio.com/questions/"+questionNo+"/answerD");
        answerDRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice =dataSnapshot.getValue(String.class);
                AnswerD.setText(choice);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        correctRef = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://popquiz-fad55.firebaseio.com/questions/"+questionNo+"/correct");
        correctRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                answer =dataSnapshot.getValue(String.class);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        questionNo++;
    }

    private void updateScore(int score){
        ScoreTV.setText("score :"+String.format("%d",score));
    }

}