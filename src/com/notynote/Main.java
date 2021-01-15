package com.notynote;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.notynote.GPA.CurrentGPA;
import com.notynote.GPA.DistinctionGPA;
import com.notynote.GPA.GraduateGPA;
import com.notynote.GPA.HighDistinctionGPA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    //Global Scanner for user input
    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {

        int usermenu = 0;
        boolean endprogram = true;
        Connection connection = null;

        try {
            connection = connect();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException f) {
            f.printStackTrace();
        }

        try {
            printStudent(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //do to keep loop program
        do {

            //Main Menu
            System.out.println("Welcome to GPA Calculator\n" +
                    "This is a Console Version");
            //check for correct input
            do {
                try {
                    System.out.println("1. View GPA\n" +
                            "2. Check eligibility for distinction\n" +
                            "3. Check eligibility for graduation\n" +
                            "4. Calculate minimum grade for distinction\n" +
                            "5. Calculate minimum grade for high distinction\n" +
                            "6. End Program");
                    usermenu = Integer.parseInt(console.next());
                } catch (Exception ignore){
                    System.out.println("===Error===");
                }
            } while (usermenu != 1 && usermenu != 2 && usermenu != 3 && usermenu != 4 && usermenu != 5 && usermenu != 6);
            Student student = new Student();
            CurrentGPA currentGPA = new CurrentGPA(student);
            Double GPA = currentGPA.getGPA();
            int creditLeft = student.requireCredit - student.totalCredit;
            String distinctions;

            if(currentGPA.isDistinction()) {
                if(currentGPA.isHighDistinction()) {
                    distinctions = "You are eligible to earn High Distinctions";
                } else {
                    distinctions = "You are eligible to earn Distinctions";
                }
            } else {
                distinctions = "You are not eligible for Distinctions";
            }

            if (usermenu == 1) {
                try {
                    printStudent(connection);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                System.out.println("===================================\n" +
                        "Your GPA: " + String.format("%.2f",GPA) +
                        "\nYou earned credit: " + student.totalCredit +
                        "\nYou need " + creditLeft + " credits to graduate" +
                        "\n" + distinctions +
                        "\n===================================\n");
            } else if (usermenu == 2) {
                System.out.println("===================================\n" +
                        distinctions +
                        "\n===================================\n");
            } else if (usermenu == 3) {
                GraduateGPA graduateGPA = new GraduateGPA(student);
                System.out.println(graduateGPA.toString());
            } else if (usermenu == 4) {
                DistinctionGPA distinctionGPA = new DistinctionGPA(student);
                System.out.println(distinctionGPA);
            } else if (usermenu == 5) {
                HighDistinctionGPA highDistinctionGPA = new HighDistinctionGPA(student);
                System.out.println(highDistinctionGPA);
            } else {
                System.out.println("End Program");
                endprogram = false;
            }

        } while (endprogram);

    }

    private static void printStudent(Connection connection) throws SQLException {

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM student");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("SID"));
            System.out.println(resultSet.getString("S_Name"));
        }

        statement.close();

    }

    private static Connection connect() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setServerTimezone("Asia/Bangkok");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("gpa_calculation");
        dataSource.setUser("pg2");
        dataSource.setPassword("Passw0rd");

        return dataSource.getConnection();
    }
}
