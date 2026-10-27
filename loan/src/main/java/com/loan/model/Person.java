package com.loan.model;

public class Person {
    private String applicantName;
    private double income;

    public Person() {}

    public Person(String applicantName, double income) {
        this.applicantName = applicantName;
        this.income = income;
    }

    // Method to be overridden (Polymorphism)
    public String getRole() {
        return "General User";
    }

    // Encapsulation: Getters and Setters
    public String getApplicantName() { return applicantName; }
    public void setApplicantName(String applicantName) { this.applicantName = applicantName; }

    public double getIncome() { return income; }
    public void setIncome(double income) { this.income = income; }
}
