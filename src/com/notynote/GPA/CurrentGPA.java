package com.notynote.GPA;

import com.notynote.Grade;
import com.notynote.Student;
import com.notynote.Subject;

public class CurrentGPA implements GPA {

    Student student;

    public CurrentGPA(Student student) {
        this.student = student;
    }

    @Override
    public Double getGPA() {

        Grade grade = new Grade();
        double gradeXCredit = 0.0;

        for (Subject subject: student.getSubjects()) {
            Double dGrade = grade.getGradeValue(subject.getGrade());
            gradeXCredit += (dGrade * subject.getCredit());
            if (subject.getGrade().equalsIgnoreCase("F")) {
                student.setHasF(true);
            }
        }

        return gradeXCredit/student.getTotalCredit();

    }

    @Override
    public boolean isDistinction() {
        if (student.getCreditTransfer() < 20 || !student.isHasF()) {
            return getGPA() >= 3.25;
        }
        return false;
    }

    @Override
    public boolean isHighDistinction() {
        if (isDistinction()) {
            return getGPA() >= 3.5;
        }
        return false;
    }
}
