package com.springboot.expensetracker.controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.expensetracker.dto.ExpenseDTO;

@Controller
public class ExpenseController {
	
	private static List<ExpenseDTO> list=new ArrayList<>();
	
	static {
		ExpenseDTO expense=new ExpenseDTO();
		expense.setName("Water Bill");
		expense.setDescription("Water Bill");
		expense.setAmount(new BigDecimal(700.00));
		expense.setDate(new Date(System.currentTimeMillis()));
		list.add(expense);
		
		expense=new ExpenseDTO();
		expense.setName("Electricity Bill");
		expense.setDescription("Electricity Bill");
		expense.setAmount(new BigDecimal(900.00));
		expense.setDate(new Date(System.currentTimeMillis()));
		list.add(expense);
	}
	
	@GetMapping("/expencess")
	public String showExpenseList(Model model) {
		model.addAttribute("expenses",list);
		return "expense-list";
	}

}
