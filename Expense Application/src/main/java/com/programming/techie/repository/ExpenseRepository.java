package com.programming.techie.repository;

import com.programming.techie.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ExpenseRepository extends MongoRepository<Expense, String> {

    @Query("{ 'name' : ?0}")
    Optional<Expense> findByName(String name);
}
