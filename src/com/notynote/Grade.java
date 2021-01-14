package com.notynote;

import java.util.HashMap;

public class Grade {
    static HashMap<String, Double> gradeMap = new HashMap<>();
    static HashMap<Double, String> gradeTextMap = new HashMap<>();

    public Grade() {
        gradeMap.put("A", 4.0);
        gradeMap.put("B+", 3.5);
        gradeMap.put("B", 3.0);
        gradeMap.put("C+", 2.5);
        gradeMap.put("C", 2.0);
        gradeMap.put("D+", 1.5);
        gradeMap.put("D", 1.0);
        gradeMap.put("F", 0.0);


        gradeTextMap.put(4.0, "A");
        gradeTextMap.put(3.5, "B+");
        gradeTextMap.put(3.0, "B");
        gradeTextMap.put(2.5, "C+");
        gradeTextMap.put(2.0, "C");
        gradeTextMap.put(1.5, "D+");
        gradeTextMap.put(1.0, "D");
        gradeTextMap.put(0.0, "F");
    }

    public static Double getGradeValue(String grade) {
        return gradeMap.get(grade);
    }

    public static String getGradeText(Double grade) { return gradeTextMap.get(grade); }
}
