package com.springboot.expensetracker.dto;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDTO {
	private long id;
	private String expenseId;
	private String name;
	private String description;
	private BigDecimal amount;
	private Date date;
	private String stringDate;
}
