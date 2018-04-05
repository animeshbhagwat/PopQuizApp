package com.example.shreyas.popquiz;

/**
 * Created by Shreyas on 29-03-2018.
 */

public class QuizActivity {
    String question,answerA,answerB,answerC,answerD,correct;
    public int qId;

    public QuizActivity(int qkey, String question, String answerA, String answerB, String answerC, String answerD, String correct) {
        this.qId=qkey;
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correct = correct;
    }

    public int getqId() {
        return (qId);
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

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public void setqId(int qId) {
        this.qId = qId;
    }
}
