package com.loan.model;

import java.util.ArrayList;
import java.util.List;

public class LoanApplication extends Person {
    // CHANGED FROM 'int' TO 'Integer' SO IT NEVER THROWS THIS ERROR!
    private Integer loanId = 0;
    private double loanAmount;
    private Integer tenureMonths;
    private String status;

    private List<String> emiSchedule = new ArrayList<>();

    public LoanApplication() {
        super();
    }

    public LoanApplication(Integer loanId, String applicantName, double income, double loanAmount, Integer tenureMonths) {
        super(applicantName, income);
        this.loanId = loanId;
        this.loanAmount = loanAmount;
        this.tenureMonths = tenureMonths;
        this.status = "PENDING";
    }

    @Override
    public String getRole() {
        return "Loan Applicant";
    }

    // Notice these now say 'Integer' instead of 'int'
    public Integer getLoanId() { return loanId; }
    public void setLoanId(Integer loanId) { this.loanId = loanId; }

    public double getLoanAmount() { return loanAmount; }
    public void setLoanAmount(double loanAmount) { this.loanAmount = loanAmount; }

    public Integer getTenureMonths() { return tenureMonths; }
    public void setTenureMonths(Integer tenureMonths) { this.tenureMonths = tenureMonths; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<String> getEmiSchedule() { return emiSchedule; }
    public void setEmiSchedule(List<String> emiSchedule) { this.emiSchedule = emiSchedule; }
}