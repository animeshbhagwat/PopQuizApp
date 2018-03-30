package com.example.shreyas.popquiz;

/**
 * Created by Shreyas on 30-03-2018.
 */

public class Student{
    String id,rollNo,Email;

    public Student(String id, String rollNo, String email) {
        this.id = id;
        this.rollNo = rollNo;
        Email = email;
    }

    public String getId() {
        return id;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getEmail() {
        return Email;
    }
}

