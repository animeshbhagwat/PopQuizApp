package com.example.shreyas.popquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    Button Answer1,Answer2,Answer3,Answer4;
    TextView ScoreET,QuestionET;
    private Questions nQuestions = new Questions();
    private String nAnswers;
    private int nScore=0;
    private int nQuestionsLength = nQuestions.nQuestions.length;
    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        r =new Random();

        Answer1 = findViewById(R.id.Answer1);
        Answer2 = findViewById(R.id.Answer2);
        Answer3 = findViewById(R.id.Answer3);
        Answer4 = findViewById(R.id.Answer4);

        ScoreET = findViewById(R.id.ScoreET);
        QuestionET = findViewById(R.id.QuestionET);

        ScoreET.setText("Score :"+nScore);

        updateQuestion(r.nextInt(nQuestionsLength));

        Answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Answer1.getText() == nAnswers){
                    nScore++;
                    ScoreET.setText("Score :"+nScore);
                    updateQuestion(r.nextInt(nQuestionsLength));
                }
                else
                    gameOver();

            }
        });

        Answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Answer2.getText() == nAnswers){
                    nScore++;
                    ScoreET.setText("Score :"+nScore);
                    updateQuestion(r.nextInt(nQuestionsLength));
                }
                else
                    gameOver();

            }
        });

        Answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Answer3.getText() == nAnswers){
                    nScore++;
                    ScoreET.setText("Score :"+nScore);
                    updateQuestion(r.nextInt(nQuestionsLength));
                }
                else
                    gameOver();

            }
        });

        Answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Answer4.getText() == nAnswers){
                    nScore++;
                    ScoreET.setText("Score :"+nScore);
                    updateQuestion(r.nextInt(nQuestionsLength));
                }
                else
                    gameOver();

            }
        });
    }

    private void updateQuestion (int num){
        QuestionET.setText(nQuestions.getQuestion(num));
        Answer1.setText(nQuestions.getChoice1(num));
        Answer2.setText(nQuestions.getChoice2(num));
        Answer3.setText(nQuestions.getChoice3(num));
        Answer4.setText(nQuestions.getChoice4(num));

        nAnswers = nQuestions.getCorrectAnswer(num);
    }

    private void gameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(QuizActivity.this);
        alertDialogBuilder
                .setMessage(" Game Over! Your Score is :" + nScore)
                .setCancelable(false)
                .setPositiveButton("NEW GAME", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    startActivity(new Intent(getApplicationContext(),QuizActivity.class));
                    }
                })
                .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
    }
    }
