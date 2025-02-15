package com.example.expenses.controller;

import com.example.expenses.model.Expense;
import com.example.expenses.service.ExpenseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(ExpenseController.class)
class ExpenseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExpenseService expenseService;

    @Test
    void showUpdateForm() throws Exception {
        Expense expense = new Expense();
        expense.setId(1L);
        expense.setDescription("Groceries");
        expense.setAmount(50.0);
        expense.setCategory("Food");

        when(expenseService.getExpenseById(1L)).thenReturn(expense);

        mockMvc.perform(get("/expenses/edit/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("expense-form"));
    }

    @Test
    void saveExpense() throws Exception {
        Expense expense = new Expense();
        expense.setId(1L);
        expense.setDescription("Groceries");
        expense.setAmount(50.0);
        expense.setCategory("Food");

        when(expenseService.saveExpense(expense)).thenReturn(expense);

        mockMvc.perform(post("/expenses")
                        .param("id", "1")
                        .param("description", "Groceries")
                        .param("amount", "50.0")
                        .param("category", "Food"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/expenses"));
    }
}