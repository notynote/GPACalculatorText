package com.notynote;

public class Subject {

    //variable
    String name;
    int credit;
    String grade;

    public Subject(String name, int credit, String grade) {
        this.name = name;
        this.credit = credit;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
