package com.capgemini.springmvcassign.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springmvcassign.bean.EmployeePrimary;
import com.capgemini.springmvcassign.dao.EmployeePrimaryDao;

@Service
public class EmployeePrimaryServiceImpl implements EmployeePrimaryService {
	
	@Autowired
	private EmployeePrimaryDao dao;

	@Override
	public EmployeePrimary authenticate(int id,String password) {
		if(id<1 || password == null || password .isEmpty() || password .trim().isEmpty()) {
			return null;
		}else {
			return dao.authenticate(id, password);
		}
		
	}

	@Override
	public EmployeePrimary getEmployee(int id) {
		if(id<1) {
			return null;
		}else { 
		return dao.getEmployee(id);
		}
	}

	@Override
	public boolean addEmployee(EmployeePrimary primary) {
		if(primary!=null) {
			return dao.addEmployee(primary);
		}else {
		return false;
		}
	}

	@Override
	public boolean deleteEmployee(int id) {
		if(id<1) {
			return false;
		}else {
			return dao.deleteEmployee(id);
		}
		
	}

	@Override
	public boolean updateEmployee(EmployeePrimary primary) {
		if(primary!=null) {
			return dao.updateEmployee(primary);
		}else {
			return false;
		}
	}

	@Override
	public List<EmployeePrimary> getAllEmployees() {
		return dao.getAllEmployees();
	}

}
