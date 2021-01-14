package com.notynote.GPA;

import com.notynote.Grade;
import com.notynote.Student;
import com.notynote.Subject;

public class DistinctionGPA implements GPA {

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

    //if all the rest subject has A and will not fulfill 3.25 then say it impossible
    public boolean possibleDistinction() {

        for (Subject subject: student.getSubjects()) {
            if (subject.getGrade().equalsIgnoreCase("F")) {
                return false;
            }
        }
        double remainCreditXGrade = 0.0;

        for (int i = 0; i < remainingSubject; i++) {
            remainCreditXGrade += 4*4;
        }

        double maximumGPA = (remainCreditXGrade+oldGPAXOldCredit)/student.getRequireCredit();

        return maximumGPA > 3.25;
    }

    @Override
    public String toString() {

        if (possibleDistinction()) {
            double possibleGrade = FindPossibleGrade();

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

    private double FindPossibleGrade() {

        double remainCreditXGrade = 0.0;

        for (double i = 1.0; i <= 4.0; i+=0.5) {
            for (int j = 0; j < remainingSubject; j++) {
                remainCreditXGrade += i*4;
            }
            if ((remainCreditXGrade+oldGPAXOldCredit)/student.getRequireCredit() > 3.25) {
                return i;
            }

        }

        return 0.0;
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
