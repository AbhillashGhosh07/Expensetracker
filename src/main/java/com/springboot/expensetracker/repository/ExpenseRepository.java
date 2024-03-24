package com.springboot.expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.expensetracker.entity.Expense;



public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
