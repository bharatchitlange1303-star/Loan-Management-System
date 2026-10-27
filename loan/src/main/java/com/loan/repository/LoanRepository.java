package com.loan.repository;


import com.loan.exception.LoanNotFoundException;
import com.loan.model.LoanApplication;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LoanRepository {
    // Assignment 2b: HashMap with Generics to store records by unique ID
    private Map<Integer, LoanApplication> loanMap = new HashMap<>();
    private int currentId = 1;

    public LoanApplication save(LoanApplication app) {
        if (app.getLoanId() == null || app.getLoanId() == 0) {
            app.setLoanId(currentId++);
        }
        loanMap.put(app.getLoanId(), app);
        return app;
    }

    public LoanApplication findById(int id) {
        // Assignment 2c: Throw exception if record is missing
        if (!loanMap.containsKey(id)) {
            throw new LoanNotFoundException("Loan ID " + id + " not found!");
        }
        return loanMap.get(id);
    }

    public List<LoanApplication> findAll() {
        return new ArrayList<>(loanMap.values());
    }
}
