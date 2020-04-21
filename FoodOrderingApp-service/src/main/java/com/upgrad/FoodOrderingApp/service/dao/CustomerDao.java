package com.upgrad.FoodOrderingApp.service.dao;

import com.upgrad.FoodOrderingApp.service.entity.CustomerEntity;

public interface CustomerDao {

	CustomerEntity saveCustomer(CustomerEntity customerEntity);


	CustomerEntity getCustomer(String contactNumber);
}
