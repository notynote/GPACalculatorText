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
                    System.out.println("1. View GPA");
                    usermenu = Integer.parseInt(console.next());
                } catch (Exception ignore){
                    System.out.println("===Error===");
                }
            } while (usermenu != 1);

            Student student = new Student();

            Double gradeXCreadit = 0.0;

            for (Subject subject:student.subjects) {

                gradeXCreadit += (subject.grade * subject.credit);

            }

            Double GPA = gradeXCreadit/student.totalCredit;
            int creditLeft = 160 - student.totalCredit;
            String distinctions = "";

            if(GPA >= 3.25 && student.creditTransfer < 20) {
                if(GPA >= 3.5) {
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
