package com.example.expenseproj.repository;


import com.example.expenseproj.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{
    List<Expense> findByUserIdAndDateTimeBetween(Long userId, LocalDateTime start, LocalDateTime end );

    @Query("SELECT e.category, SUM(e.amount) FROM Expense e WHERE e.user.id = ?1 GROUP BY e.category ")
    List<Object[]> getExpenseSummaryByCategory(Long userId);

}
