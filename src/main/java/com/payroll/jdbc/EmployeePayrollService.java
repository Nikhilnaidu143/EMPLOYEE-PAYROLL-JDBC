package com.payroll.jdbc;

import java.util.List;

public class EmployeePayrollService {
	//enum
	public enum IOService { 
		CONSOLE_IO, 
		FILE_IO, 
		DB_IO
	};
	
	private List<EmployeePayrollData> employeePayrollDataList;
	private EmployeePayrollService employeePayrollService;
	
	//default constructor.
	public EmployeePayrollService() {
		
	}
	
	public List<EmployeePayrollData> readEmployeePayRollData(IOService ioservice) {
		if(ioservice.equals(IOService.DB_IO)) {
			this.employeePayrollDataList = new EmployeePayrollDB_Service().readData();
		}
		return employeePayrollDataList;
	}
}
