package com.notynote.GPA;

import com.notynote.Grade;
import com.notynote.Student;
import com.notynote.Subject;

public class DistinctionGPA extends GPA {

    //calculate minimum grade for distinction GPA
    Student student;
    CurrentGPA currentGPA;
    int remainingSubject;
    double oldGPAXOldCredit;

    public DistinctionGPA(Student student) {
        this.student = student;
        this.currentGPA = new CurrentGPA(student);
        this.remainingSubject = (student.getRequireCredit() - student.getTotalCredit())/4;
        this.oldGPAXOldCredit = student.getTotalCredit() * currentGPA.getGPA();
    }

    @Override
    public String toString() {

        if (possibleDistinction(student,remainingSubject,oldGPAXOldCredit)) {
            double possibleGrade = FindPossibleGrade(student,remainingSubject,3.25,oldGPAXOldCredit);

            Grade grade = new Grade();

            return "===================================\n" +
                    "Your GPA: " + String.format("%.2f",currentGPA.getGPA()) +
                    "\nYou earned credit: " + student.getTotalCredit() +
                    "\nYou need at least \"" + grade.getGradeText(possibleGrade) + "\" for the" +
                    "\nremaining subjects to get Distinction" +
                    "\n===================================\n";
        } else {
            return "IT IS NOT POSSIBLE TO EARN DISTINCTION OMG LOOK AT YOURSELF COME ON";
        }
    }

    @Override
    public Double getGPA() {
        return null;
    }

    @Override
    public boolean isDistinction() {
        return false;
    }

    @Override
    public boolean isHighDistinction() {
        return false;
    }
}
