package com.testing;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.payroll.jdbc.EmployeePayrollData;
import com.payroll.jdbc.EmployeePayrollService;

public class EmployeePayrollServiceTest {

	EmployeePayrollService employeePayrollService;
	List<EmployeePayrollData> employeePayrollList;
	
	 @Test
	  public void given3EmployeePayrollInDB_WhenRetrieved_ShouldMatchEmployeeCount() {
		 employeePayrollService = new EmployeePayrollService();
		 employeePayrollList = employeePayrollService.readEmployeePayRollData(EmployeePayrollService.IOService.DB_IO);
		 assertEquals(5, employeePayrollList.size());
	 }
}
