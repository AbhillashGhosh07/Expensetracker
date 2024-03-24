package com.springboot.expensetracker.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.expensetracker.dto.ExpenseDTO;
import com.springboot.expensetracker.entity.Expense;
import com.springboot.expensetracker.repository.ExpenseRepository;

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

}
