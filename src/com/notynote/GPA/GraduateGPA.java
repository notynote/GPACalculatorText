package com.notynote.GPA;

import com.notynote.Grade;
import com.notynote.Student;
import com.notynote.Subject;

public class GraduateGPA extends GPA {

    Student student;
    CurrentGPA currentGPA;

    public GraduateGPA(Student student) {
        this.student = student;
        this.currentGPA = new CurrentGPA(student);
    }

    public boolean qualifyForGraduate() {
        if (student.getTermTaken() < 24) {
            if (student.getTotalCredit() >= 160){
                return currentGPA.getGPA() > 2.0;
            }
        }
        return false;
    }

    @Override
    public String toString() {

        String graduate,yearText;
        int year = student.getTermTaken()/3;
        int yearLeft = 8-year;
        int creditLeft = student.getRequireCredit() - student.getTotalCredit();

        if (year < 1) {
            year = 1;
        }

        if (qualifyForGraduate()) {
            graduate = "You are qualify to graduate!";
        } else {
            graduate = "You are NOT qualify to graduate!";
        }

        if (year > 8) {
            yearText = "You have exceed maximum years (8) to qualify for graduation";
        } else {
            yearText = "You have " + yearLeft + " years left before exceed the qualification";
        }

        return "===================================\n" +
                graduate + "\n" +
                "===================================\n" +
                "Your GPA: " + String.format("%.2f",currentGPA.getGPA()) +
                "\nYou earned credit: " + student.getTotalCredit() +
                "\nYou need " + creditLeft + " credits to graduate" +
                "\nYou Studies for " + year + " Year(s)" +
                "\n" + yearText + "\n" +
                "\n===================================\n";
    }

    @Override
    public Double getGPA() {
        return 2.0;
    }

    @Override
    public boolean isDistinction() {
        if (qualifyForGraduate()) {
            if (student.getCreditTransfer() < 20 || !student.isHasF()) {
                return getGPA() >= 3.25;
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean isHighDistinction() {
        if (qualifyForGraduate()) {
            if (isDistinction()) {
                return getGPA() >= 3.5;
            }
            return false;
        }
        return false;
    }
}
