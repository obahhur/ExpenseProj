package com.example.expenseproj.service;

import com.example.expenseproj.model.Expense;
import com.example.expenseproj.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ExpenseService {

@Autowired
    private ExpenseRepository expenseRepository;

public Expense addExpense(Expense expense){
    return expenseRepository.save(expense);
}

public List<Object[]> getExpenseSummary(Long userId){
    return expenseRepository.getExpenseSummaryByCategory(userId);
}

}
