package com.springboot.expensetracker.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.expensetracker.dto.ExpenseDTO;
import com.springboot.expensetracker.entity.Expense;
import com.springboot.expensetracker.repository.ExpenseRepository;
import com.springboot.expensetracker.util.DateTimeUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseService {
	
	private final ExpenseRepository expenseRepository;
	private final ModelMapper modelMapper;
	
	public List<ExpenseDTO> getAllEmployees(){
		List<Expense> expenseList= expenseRepository.findAll();
		List<ExpenseDTO> list=expenseList.stream().map(this::mapToDto).collect(Collectors.toList());
		return list;
	}
	
	public ExpenseDTO mapToDto(Expense expense) {
		/*ExpenseDTO expenseDTO= new ExpenseDTO();
		expenseDTO.setId(expense.getId());
		expenseDTO.setExpenseId(expense.getExpenseId());
		expenseDTO.setAmount(expense.getAmount());
		expenseDTO.setName(expense.getName());
		expenseDTO.setDescription(expense.getDescription());
		expenseDTO.setDate(expense.getDate());*/
		ExpenseDTO expenseDTO=modelMapper.map(expense, ExpenseDTO.class);
		return expenseDTO;
		
	}
	
	public ExpenseDTO saveExpenseDetails(ExpenseDTO dto) throws Exception {
		Expense expense=mapToEntity(dto);
		
		//Save the expense to the repository
		expense=expenseRepository.save(expense);
		System.out.println("Expense inside Service is : "+expense.toString());
		return mapToDto(expense);
		
	}
	
	public Expense mapToEntity(ExpenseDTO dto) throws Exception {
		Expense expense=modelMapper.map(dto, Expense.class);
		
		//Generate ExpenseId
		System.out.println("The expense ID is : "+dto.getExpenseId());
		if(dto.getExpenseId()==null) {
			expense.setExpenseId(UUID.randomUUID().toString());
		}
		//Set Expense Date
		expense.setDate(DateTimeUtil.convertStringToDate(dto.getStringDate()));
		
		return expense;
	}

	public void deleteExpense(String id) {
		Expense existingExpense=expenseRepository.findByExpenseId(id).orElseThrow(()->new RuntimeException("Expense not fount with the id : "+id));
		expenseRepository.delete(existingExpense);
	}
	
	public ExpenseDTO updateExpense(String id) {
		Expense existingExpense=expenseRepository.findByExpenseId(id).orElseThrow(()->new RuntimeException("Expense not fount with the id : "+id));
		return mapToDto(existingExpense);
	}

}
