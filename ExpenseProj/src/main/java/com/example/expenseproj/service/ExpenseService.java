package com.example.expenseproj.service;

import com.example.expenseproj.model.Expense;
import com.example.expenseproj.model.User;
import com.example.expenseproj.repository.ExpenseRepository;
import com.example.expenseproj.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ExpenseService {

@Autowired
    private ExpenseRepository expenseRepository;
@Autowired
private UserRepository userRepository;

    public Expense addExpense(Expense expense, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
                expense.setUser(user);
                return  expenseRepository.save(expense);

    }



public List<Object[]> getExpenseSummary(Long userId){
    return expenseRepository.getExpenseSummaryByCategory(userId);
}

}
