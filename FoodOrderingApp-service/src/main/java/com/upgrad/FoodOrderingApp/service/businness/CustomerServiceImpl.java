package com.upgrad.FoodOrderingApp.service.businness;

import com.upgrad.FoodOrderingApp.service.dao.CustomerDao;
import com.upgrad.FoodOrderingApp.service.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {


	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private PasswordCryptographyProvider passwordCryptographyProvider;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CustomerEntity saveCustomer(CustomerEntity customerEntity) {
		//handle the validations


//		if(customerDao.getCustomer(customerEntity.getContactNumber() != null) {
//			//throw exception
//		}


		//if validations are okay then save the customer in db;

		String[] encryptPassoword = passwordCryptographyProvider.encrypt(customerEntity.getPassword());

		customerEntity.setSalt(encryptPassoword[0]);
		customerEntity.setPassword(encryptPassoword[1]);

		return customerDao.saveCustomer(customerEntity);

	}
}
