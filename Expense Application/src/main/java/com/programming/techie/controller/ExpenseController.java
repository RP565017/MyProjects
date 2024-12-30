package com.programming.techie.controller;

import com.programming.techie.model.Expense;
import com.programming.techie.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

     private final ExpenseService expenseService;
     
     public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
     }
     @PostMapping
      public ResponseEntity addExpense(@RequestBody Expense expense) {
         expenseService.addExpense(expense);
         return ResponseEntity.status(HttpStatus.CREATED).build();
     }
     @GetMapping("/all")
     public ResponseEntity<Object> getAllExpense() {
         expenseService.getAllExpense();
        return ResponseEntity.ok(expenseService.getAllExpense());
    }
    @PutMapping
    public ResponseEntity<Object> updateExpense(@RequestBody Expense expense){
         expenseService.updateExpense(expense);
         return ResponseEntity.ok().build();

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteExpense(@PathVariable String id){
         expenseService.deleteExpense(id);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{name}")
    public ResponseEntity<Expense> getExpenseNyName(@PathVariable String name){
         expenseService.getExpenseNyName(name);
         return ResponseEntity.ok(expenseService.getExpenseNyName(name));
    }
}
