package com.capgemini.springmvcassign.service;

import java.util.List;

import com.capgemini.springmvcassign.bean.EmployeePrimary;

public interface EmployeePrimaryService {

	public EmployeePrimary authenticate(int id,String password);
	public EmployeePrimary getEmployee(int id);
	public boolean addEmployee(EmployeePrimary primary);
	public boolean deleteEmployee(int id);
	public boolean updateEmployee(EmployeePrimary primary);
	public List<EmployeePrimary> getAllEmployees();
	
	
	
}
