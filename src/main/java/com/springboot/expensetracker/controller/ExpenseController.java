package com.springboot.expensetracker.controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.expensetracker.dto.ExpenseDTO;
import com.springboot.expensetracker.repository.ExpenseRepository;
import com.springboot.expensetracker.service.ExpenseService;

import lombok.RequiredArgsConstructor;

@Controller
public class ExpenseController {
	
	private static List<ExpenseDTO> list=new ArrayList<>();
	@Autowired
	private ExpenseService service;
	
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
		model.addAttribute("expenses",service.getAllEmployees());
		return "expense-list";
	}
	
	@GetMapping("/createExpense")
	public String createExpense(Model model) {
		model.addAttribute("expense",new ExpenseDTO());
		return "expense-form";
	}
	
	@PostMapping("/saveOrUpdateExpense")
	public String saveOrUpdateExpense(@ModelAttribute("expense") ExpenseDTO dto) throws Exception {
		System.out.println("Printing the expense dto : "+dto);
		service.saveExpenseDetails(dto);
		return "redirect:/expencess";
	}
	
	@GetMapping("/deleteExpenses")
	public String deleteExpenses(@RequestParam String id) {
		System.out.println("Deleting the expense with id : "+id);
		service.deleteExpense(id);
		return "redirect:/expencess";
	}
	
	@GetMapping("/updateExpenses")
	public String updateExpenses(@RequestParam String id,Model model) {
		System.out.println("Updating the expense with id : "+id);
		ExpenseDTO dto=service.updateExpense(id);
		model.addAttribute("expense",dto);
		return "expense-form";
	}

}
