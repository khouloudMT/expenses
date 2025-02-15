package com.example.expenses.service;

import com.example.expenses.model.Expense;

import java.util.List;

public interface ExpenseService {
    List<Expense> getAllExpenses();
    Expense saveExpense(Expense expense);
    Expense getExpenseById(Long id);
    void deleteExpenseById(Long id);
}
