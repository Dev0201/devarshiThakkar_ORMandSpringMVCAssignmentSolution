package com.CRMcode.springdemo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.CRMcode.springdemo.entity.Customer;
import com.CRMcode.springdemo.service.CustomerService;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import javassist.compiler.ast.ASTList;

@Controller
@RequestMapping("/customer")
public class CustomerController {

@Autowired	
private CustomerService customerService;	

@GetMapping("/list")
public String listCustomers(Model theModel)
{
	// get customers from thr DAO;
	
	ASTList theCustomers = customerService.getCustomers();
	
	// add the customers to the model
	
	theModel.addAttribute("customers", theCustomers);
	
	return "ASTlist-customers"; // In spring mvc when a string is returned,
							 // corresponding jsp file is executed.
}

@GetMapping("/showFormForAdd")
public String showrFormForAdd(Model theModel)
{
	Customer theCustomer = new Customer();
	
	theModel.addAttribute("customer",theCustomer);
	
	return "customer-form";
	
}

@PostMapping("/saveCustomer")
public String saveCustomer(@ModelAttribute("customer") Customer theCustomer)
{	
	// save the customer using the service
	
	customerService.saveCustomer(theCustomer);
	
	return "redirect:/customer/list";
}

@GetMapping("/showFormForUpdate")
public String showFormForUpdate(@RequestParam("customerId") int theId,
								Model theModel)
{
	// get the customer from the service
	Customer theCustomer = customerService.getCustomer(theId); // we fetch the customer one by one from the
															   // database table, using it's primary key, i.e theId
	 
	// set customer as a modelAttribute to prepopulate the form
	theModel.addAttribute("customer", theCustomer);
	
	// send over to the form

	return "customer-form";


}

@GetMapping("/delete")
public String deleteCustomer(@RequestParam("customerId") int theId,
								Model theModel)
{
	// delete the customer
	customerService.deleteCustomer(theId);
	
	return "redirect:/customer/list";
	
}



}




