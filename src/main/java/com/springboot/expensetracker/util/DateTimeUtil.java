package com.springboot.expensetracker.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class DateTimeUtil {

	public static String convertDateToString(Date date) {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(date);
	}
	
	public static Date convertStringToDate(String dateString) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date=sdf.parse(dateString);
		return new Date(date.getTime());
	}
}
