package com.example.shreyas.popquiz;

/**
 * Created by Shreyas on 29-03-2018.
 */

public class QuizActivity {
    String qId,question,answerA,answerB,answerC,answerD,correct;

    public QuizActivity(String qId, String question, String answerA, String answerB, String answerC, String answerD, String correct) {
        this.qId = qId;
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correct = correct;
    }

    public String getqId() {
        return qId;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswerA() {
        return answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public String getCorrect() {
        return correct;
    }
}
