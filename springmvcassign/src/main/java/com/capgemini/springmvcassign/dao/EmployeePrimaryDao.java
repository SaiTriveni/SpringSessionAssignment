package com.capgemini.springmvcassign.dao;

import java.util.List;

import com.capgemini.springmvcassign.bean.EmployeePrimary;

public interface EmployeePrimaryDao {

	public EmployeePrimary authenticate(int id,String password);
	public EmployeePrimary getEmployee(int id);
	public boolean addEmployee(EmployeePrimary primary);
	public boolean deleteEmployee(int id);
	public boolean updateEmployee(EmployeePrimary primary);
	public List<EmployeePrimary> getAllEmployees();
	
	
	
	
}
