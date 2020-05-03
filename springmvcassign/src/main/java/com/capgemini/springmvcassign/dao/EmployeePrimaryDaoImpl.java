package com.capgemini.springmvcassign.dao;

import java.util.LinkedList;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.capgemini.springmvcassign.bean.EmployeePrimary;
@Repository
public class EmployeePrimaryDaoImpl implements EmployeePrimaryDao {
	
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public EmployeePrimary authenticate(int id,String password) {
		EmployeePrimary primary=getEmployee(id);
		if(primary != null && primary.getPassword().equals(password)) {
			return primary;
		}
		return null;
	}

	@Override
	public EmployeePrimary getEmployee(int id) {
		EntityManager manager = factory.createEntityManager();
		EmployeePrimary employeePrimary = manager.find(EmployeePrimary.class,id);
		manager.close();
		return employeePrimary;
	
	}

	@Override
	public boolean addEmployee(EmployeePrimary primary) {
		
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isAdded =  false;
		try {
			transaction.begin();
			manager.persist(primary);
			transaction.commit();
			isAdded = true;
			System.out.println("added");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return isAdded;
	}

	@Override
	public boolean deleteEmployee(int id) {
		boolean isDeleted = false;
		EntityManager manager = factory.createEntityManager();
		EmployeePrimary employeePrimary = manager.find(EmployeePrimary.class,id);
		if(employeePrimary != null) {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.remove(employeePrimary);
			transaction.commit();
			isDeleted=true;
		}
		manager.close();
		return isDeleted;
	}

	@Override
	public boolean updateEmployee(EmployeePrimary primary) {
		boolean isUpdated = false;
		EntityManager manager = factory.createEntityManager();
		EmployeePrimary employeePrimary = manager.find(EmployeePrimary.class,primary.getId());
		if(employeePrimary != null) {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			employeePrimary.setDesignation(primary.getDesignation());
			transaction.commit();
			isUpdated = true;
		}
		manager.close();
		return isUpdated;
	}

	@Override
	public List<EmployeePrimary> getAllEmployees() {
		EntityManager manager=factory.createEntityManager();
		String jpql="select m from EmployeePrimary m";
		javax.persistence.Query query=manager.createQuery(jpql);
		List<EmployeePrimary> employeeList=query.getResultList();
		return employeeList;
	}
	
	}


