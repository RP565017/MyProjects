package com.programming.techie.service;

import com.programming.techie.model.Expense;
import com.programming.techie.repository.ExpenseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(Expense expense){
        expenseRepository.insert(expense);
    }
    public ResponseEntity<Expense> getAllExpense(){
       return ResponseEntity.ok(expenseRepository.findAll().get(0));
    }
    public void updateExpense( Expense expense){
        Expense SavedExpense = expenseRepository
                .findById(expense.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cant FInd Expense By Id %s", expense.getId())));

        SavedExpense.setExpenseName(expense.getExpenseName());
        SavedExpense.setExpenseCategory(expense.getExpenseCategory());
        SavedExpense.setExpenseAmount(expense.getExpenseAmount());
        expenseRepository.save(expense);
    }
    public void deleteExpense(String id){
        expenseRepository.deleteById(id);
    }
    public Expense getExpenseNyName(String name){
        return expenseRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Can't Find Exppense by Name", name)));
    }
}
