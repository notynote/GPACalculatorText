package com.notynote;

public class Student {

    int sid;
    String sName,sPassword;
    int termTaken;
    int creditEarned, creditTransfer,totalCredit;
    String Department;
    Subject[] subjects;

    public Student(){
        this.sid = 1801310010;
        this.sName = "NotyNote";
        this.creditEarned = 128;
        this.creditTransfer = 4;
        this.totalCredit = 128+4;
        this.subjects = new Subject[]{
                new Subject("ENG101", 4, 4.0),
                new Subject("ENG102", 4, 4.0),
                new Subject("ITE101", 4, 4.0),
                new Subject("MAT101", 4, 3.5),
                new Subject("MIS103", 4, 4.0),
                new Subject("ENG103", 4, 4.0),
                new Subject("ITE131", 4, 4.0),
                new Subject("ITE210", 4, 4.0),
                new Subject("ITE221", 4, 4.0),
                new Subject("ITE240", 4, 4.0),
                new Subject("ITE441", 4, 4.0),
                new Subject("STA101", 4, 3.0),
                new Subject("ITE222", 4, 4.0),
                new Subject("ITE231", 4, 4.0),
                new Subject("ITE321", 4, 3.5),
                new Subject("ITE451", 4, 4.0),
                new Subject("ITE120", 4, 4.0),
                new Subject("ITE201", 4, 4.0),
                new Subject("ITE224", 4, 4.0),
                new Subject("ITE233", 4, 4.0),
                new Subject("ITE343", 4, 4.0),
                new Subject("ITE254", 4, 4.0),
                new Subject("ITE337", 4, 4.0),
                new Subject("ITE442", 4, 2.5),
                new Subject("ITE475", 4, 3.0),
                new Subject("ATH102", 4, 4.0),
                new Subject("ITE331", 4, 4.0),
                new Subject("ITE420", 4, 4.0),
                new Subject("ITE479", 4, 4.0),
                new Subject("ITE220", 4, 4.0),
                new Subject("MKT213", 4, 4.0),
                new Subject("PSY101", 4, 4.0),
                new Subject("PSY102", 4, 4.0)
        };
    }

    public Student(int sid,String sName,int creditEarned,int creditTransfer) {
        this.sid = sid;
        this.sName = sName;
        this.creditEarned = creditEarned;
        this.creditTransfer = creditTransfer;
        totalCredit = creditEarned+creditTransfer;
    }

}
