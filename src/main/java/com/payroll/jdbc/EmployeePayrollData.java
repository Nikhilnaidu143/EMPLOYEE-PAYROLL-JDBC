package com.payroll.jdbc;

import java.time.LocalDate;
import java.util.Objects;

public class EmployeePayrollData {
	
	private int id;
	private String name;
	private double salary;
	private LocalDate startDate;
	
	public EmployeePayrollData(int id, String name , double startDate) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.startDate = null;
	}

	public EmployeePayrollData(int id, String name , double salary , LocalDate startDate) {
		this(id,name,salary);
		this.startDate = startDate;
	}
}
