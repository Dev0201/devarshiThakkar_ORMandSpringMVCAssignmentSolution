package com.CRMcode.springdemo.dao;

import java.util.List;

import com.CRMcode.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
