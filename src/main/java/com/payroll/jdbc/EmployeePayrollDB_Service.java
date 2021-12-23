package com.payroll.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollDB_Service {
	//step-1:- Loading the driver. 
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/payroll_service";
	static final String USER_NAME = "root";
	static final String PASSWORD = "SAItarun*1";
	
	private Connection getConnection() throws SQLException {
		Connection connection;
		System.out.println("Connecting to database :- " + JDBC_URL);
		
		//Step-2:- Establishing a connection with data base.
		connection = DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);
		System.out.println("Connection is successfull :- " + connection);
		return connection;
	}
	
	/*** Retriving/reading data from database. ***/
	public List<EmployeePayrollData> readData() {
		String sql = "SELECT * FROM employee_payroll; ";        //Query to retrive data.
		List<EmployeePayrollData> employeePayrollDataList = new ArrayList<EmployeePayrollData>();
		
		try {
			Connection connection = this.getConnection();
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()) {
				int id = result.getInt("ID");
				String name = result.getString("Name");
				double salary = result.getDouble("Salary");
				LocalDate startDate = result.getDate("Start_date").toLocalDate();
				employeePayrollDataList.add(new EmployeePayrollData(id, name, salary, startDate));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeePayrollDataList;
	}
}
