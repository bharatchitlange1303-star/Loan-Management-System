package com.loan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoanApp {

	public static void main(String[] args) {
		SpringApplication.run(LoanApp.class, args);
		System.out.println("Personal Loan Management System Started Successfully!");
	}
}


/*testing part on Postman:

TEST 1: apply for a loan (POST)
 http://localhost:8080/loans/apply  [POST]
{
  "applicantName": "Bharat Chitlange",
  "income": 70000,
  "loanAmount": 220000,
  "tenureMonths": 6
}

Test 2: apply for an ineligible loan (POST)
{
  "applicantName": "Yash Brahmecha",
  "income": 15000,
  "loanAmount": 100000,
  "tenureMonths": 10
}

Test 3: admin approves loan #(loan Id:1) & generates EMI Schedule (PUT)
http://localhost:8080/loans/1/decision?approve=true


Test 4: track/pay 1st Month EMI (PUT)
http://localhost:8080/loans/1/pay?month=1

Test 5: view all loans or filter by status (GET)
http://localhost:8080/loans?status=APPROVED

Test 6: trigger custom exception handling (PUT)
http://localhost:8080/loans/99/decision?approve=true

 */
