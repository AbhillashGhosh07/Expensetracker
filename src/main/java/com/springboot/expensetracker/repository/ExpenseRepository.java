package com.springboot.expensetracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.expensetracker.entity.Expense;



public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	
	 Optional<Expense> findByExpenseId(String id);

}
