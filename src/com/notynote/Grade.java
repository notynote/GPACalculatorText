package com.notynote;

import java.util.HashMap;

public class Grade {
    static HashMap<String, Double> gradeMap = new HashMap<>();

    public Grade() {
        gradeMap.put("A", 4.0);
        gradeMap.put("B+", 3.5);
        gradeMap.put("B", 3.0);
        gradeMap.put("C+", 2.5);
        gradeMap.put("C", 2.0);
        gradeMap.put("D+", 1.5);
        gradeMap.put("D", 1.0);
        gradeMap.put("F", 0.0);
    }

    public static Double getGradeValue(String grade) {
        return gradeMap.get(grade);
    }
}
