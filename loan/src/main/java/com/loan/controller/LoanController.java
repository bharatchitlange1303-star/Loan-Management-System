package com.loan.controller;


import com.loan.exception.LoanNotFoundException;
import com.loan.model.LoanApplication;
import com.loan.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService service;

    // 1. User applies for a loan
    @PostMapping("/apply")
    public String applyLoan(@RequestBody LoanApplication app) {
        // Assignment 2c: Try-Catch exception handling
        try {
            LoanApplication saved = service.applyForLoan(app);
            return "Application Submitted! Loan ID: " + saved.getLoanId() + " | Status: " + saved.getStatus();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    // 2. Admin approves or rejects loan
    @PutMapping("/{id}/decision")
    public Object adminDecision(@PathVariable int id, @RequestParam boolean approve) {
        try {
            return service.processLoanByAdmin(id, approve);
        } catch (LoanNotFoundException e) {
            return e.getMessage();
        }
    }

    // 3. Track / Pay EMI for a specific month
    @PutMapping("/{id}/pay")
    public Object payEmi(@PathVariable int id, @RequestParam int month) {
        try {
            return service.payEmi(id, month);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    // 4. View all loans (or filter by status using Stream API)
    @GetMapping
    public List<LoanApplication> viewLoans(@RequestParam(required = false) String status) {
        if (status != null) {
            return service.getLoansByStatus(status);
        }
        return service.getAllLoans();
    }
}