package com.upgrad.FoodOrderingApp.service.dao;

import com.upgrad.FoodOrderingApp.service.entity.CustomerEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CustomerDaoImpl implements CustomerDao {


	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public CustomerEntity saveCustomer(CustomerEntity customerEntity) {
		entityManager.persist(customerEntity);
		return  customerEntity;
	}

	@Override
	public CustomerEntity getCustomer(String contactNumber) {
		return null;
	}
}
