package com.CRMcode.springdemo.service;

import java.util.List;

import com.CRMcode.springdemo.entity.Customer;

import javassist.compiler.ast.ASTList;

public interface CustomerService {

	public ASTList getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
}
