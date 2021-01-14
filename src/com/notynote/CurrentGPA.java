package com.notynote;

public class CurrentGPA implements GPA{

    Student student;

    public CurrentGPA(Student student) {
        this.student = student;
    }

    @Override
    public Double getGPA() {

        Grade grade = new Grade();
        Double gradeXCredit = 0.0;

        for (Subject subject: student.subjects) {
            Double dGrade = grade.getGradeValue(subject.grade);
            gradeXCredit += (dGrade * subject.credit);
        }

        Double GPA = gradeXCredit/student.totalCredit;

        return GPA;

    }

    @Override
    public boolean isDistinction() {
        if (student.creditTransfer < 20) {
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
