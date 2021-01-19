package com.notynote.GPA;

import com.notynote.Student;
import com.notynote.Subject;

abstract class GPA {

    public abstract Double getGPA();
    public abstract boolean isDistinction();
    public abstract boolean isHighDistinction();

    public boolean possibleDistinction(Student student,int remainingSubject,double oldGPAXOldCredit) {
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

    public double FindPossibleGrade(Student student,int remainingSubject,double requireGrade,double oldGPAXOldCredit) {

        double remainCreditXGrade = 0.0;

        for (double i = 1.0; i <= 4.0; i+=0.5) {
            for (int j = 0; j < remainingSubject; j++) {
                remainCreditXGrade += i*4;
            }
            if ((remainCreditXGrade+oldGPAXOldCredit)/student.getRequireCredit() > requireGrade) {
                return i;
            }

        }

        return 0.0;
    }

}
