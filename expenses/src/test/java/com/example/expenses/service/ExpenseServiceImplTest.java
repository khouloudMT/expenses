package com.example.expenses.service;

import com.example.expenses.model.Expense;
import com.example.expenses.repository.ExpenseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ExpenseServiceImplTest {

    @Mock
    private ExpenseRepository expenseRepository;

    @InjectMocks
    private ExpenseServiceImpl expenseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getExpenseById() {
        Expense expense = new Expense();
        expense.setId(1L);
        expense.setDescription("Groceries");
        expense.setAmount(50.0);
        expense.setCategory("Food");

        when(expenseRepository.findById(1L)).thenReturn(Optional.of(expense));

        Expense foundExpense = expenseService.getExpenseById(1L);
        assertEquals("Groceries", foundExpense.getDescription());
        verify(expenseRepository, times(1)).findById(1L);
    }

    @Test
    void saveExpense() {
        Expense expense = new Expense();
        expense.setDescription("Groceries");
        expense.setAmount(50.0);
        expense.setCategory("Food");

        when(expenseRepository.save(expense)).thenReturn(expense);

        Expense savedExpense = expenseService.saveExpense(expense);
        assertEquals("Groceries", savedExpense.getDescription());
        verify(expenseRepository, times(1)).save(expense);
    }
}