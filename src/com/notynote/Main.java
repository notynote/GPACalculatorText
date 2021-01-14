package com.notynote;

import java.util.Scanner;

public class Main {

    //Global Scanner for user input
    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {

        int usermenu = 0;
        boolean endprogram = true;

        //do to keep loop program
        do {

            //Main Menu
            System.out.println("Welcome to GPA Calculator\n" +
                    "This is a Console Version");
            //check for correct input
            do {
                try {
                    System.out.println("1. View GPA\n" +
                            "2. Check eligibility for distinction");
                    usermenu = Integer.parseInt(console.next());
                } catch (Exception ignore){
                    System.out.println("===Error===");
                }
            } while (usermenu != 1);
            Student student = new Student();

            CurrentGPA currentGPA = new CurrentGPA(student);
            Double GPA = currentGPA.getGPA();

            int creditLeft = student.requireCredit - student.totalCredit;
            String distinctions = "";

            if(currentGPA.isDistinction()) {
                if(currentGPA.isHighDistinction()) {
                    distinctions = "You are eligible to earn High Distinctions";
                } else {
                    distinctions = "You are eligible to earn Distinctions";
                }
            }

            System.out.println("Your GPA: " + String.format("%.2f",GPA) +
                    "\nYou earned credit: " + student.totalCredit +
                    "\nYou need " + creditLeft + " credits to graduate" +
                    "\n" + distinctions );

            System.out.println("End Program");
            endprogram = false;


        } while (endprogram);

    }
}
