package com.example.expenseproj.controller;


import com.example.expenseproj.model.Expense;
import com.example.expenseproj.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")

public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense){
        return ResponseEntity.ok(expenseService.addExpense(expense));
    }
    @GetMapping("/summary/{userId}")
    public ResponseEntity<List<Object[]>> getExpenseSummary(@PathVariable Long userId){
        return ResponseEntity.ok(expenseService.getExpenseSummary(userId));
    }
}
