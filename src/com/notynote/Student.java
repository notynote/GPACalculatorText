package com.notynote;

import java.util.ArrayList;

public class Student {

    int sid;
    String sName,sPassword;
    int termTaken;
    int creditEarned, creditTransfer,totalCredit, requireCredit;
    String Department;
    ArrayList<Subject> subjects = new ArrayList<>();

    public Student(){
        this.sid = 1801310010;
        this.sName = "NotyNote";
        this.creditEarned = 128;
        this.creditTransfer = 4;
        this.totalCredit = 128+4;
        this.requireCredit = 160;
        this.subjects.add(new Subject("ENG101", 4, "A"));
        this.subjects.add(new Subject("ENG102", 4, "B+"));
        this.subjects.add(new Subject("ITE101", 4, "A"));
        this.subjects.add(new Subject("MAT101", 4, "B+"));
        this.subjects.add(new Subject("MIS103", 4, "A"));
        this.subjects.add(new Subject("ENG103", 4, "A"));
        this.subjects.add(new Subject("ITE131", 4, "A"));
        this.subjects.add(new Subject("ITE210", 4, "A"));
        this.subjects.add(new Subject("ITE221", 4, "A"));
        this.subjects.add(new Subject("ITE240", 4, "A"));
        this.subjects.add(new Subject("ITE441", 4, "A"));
        this.subjects.add(new Subject("STA101", 4, "B"));
        this.subjects.add(new Subject("ITE222", 4, "A"));
        this.subjects.add(new Subject("ITE231", 4, "A"));
        this.subjects.add(new Subject("ITE321", 4, "B+"));
        this.subjects.add(new Subject("ITE451", 4, "A"));
        this.subjects.add(new Subject("ITE120", 4, "A"));
        this.subjects.add(new Subject("ITE201", 4, "A"));
        this.subjects.add(new Subject("ITE224", 4, "A"));
        this.subjects.add(new Subject("ITE233", 4, "A"));
        this.subjects.add(new Subject("ITE343", 4, "A"));
        this.subjects.add(new Subject("ITE254", 4, "A"));
        this.subjects.add(new Subject("ITE337", 4, "A"));
        this.subjects.add(new Subject("ITE442", 4, "C+"));
        this.subjects.add(new Subject("ITE475", 4, "B"));
        this.subjects.add(new Subject("ATH102", 4, "A"));
        this.subjects.add(new Subject("ITE331", 4, "A"));
        this.subjects.add(new Subject("ITE420", 4, "A"));
        this.subjects.add(new Subject("ITE479", 4, "A"));
        this.subjects.add(new Subject("ITE220", 4, "A"));
        this.subjects.add(new Subject("MKT213", 4, "A"));
        this.subjects.add(new Subject("PSY101", 4, "A"));
        this.subjects.add(new Subject("PSY102", 4, "A"));
    }

    public Student(int sid,String sName,int creditEarned,int creditTransfer) {
        this.sid = sid;
        this.sName = sName;
        this.creditEarned = creditEarned;
        this.creditTransfer = creditTransfer;
        totalCredit = creditEarned+creditTransfer;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }

    public int getTermTaken() {
        return termTaken;
    }

    public void setTermTaken(int termTaken) {
        this.termTaken = termTaken;
    }

    public int getCreditEarned() {
        return creditEarned;
    }

    public void setCreditEarned(int creditEarned) {
        this.creditEarned = creditEarned;
    }

    public int getCreditTransfer() {
        return creditTransfer;
    }

    public void setCreditTransfer(int creditTransfer) {
        this.creditTransfer = creditTransfer;
    }

    public int getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(int totalCredit) {
        this.totalCredit = totalCredit;
    }

    public int getRequireCredit() {
        return requireCredit;
    }

    public void setRequireCredit(int requireCredit) {
        this.requireCredit = requireCredit;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }
}
