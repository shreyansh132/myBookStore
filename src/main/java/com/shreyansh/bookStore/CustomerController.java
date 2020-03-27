package com.shreyansh.bookStore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/book-api/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	//add new customer
	@PostMapping(value = "/addCustomer")
	public void addNewCustomerDetails(@RequestBody CustomerDetails customer){
		   customerService.addNewCustomer(customer);
	}
	
//add new book list
	@PostMapping(value = "/addCustomerList")
	public void addMultipleCustomerDetails(@RequestBody List<CustomerDetails> customerlist){
		customerService.addCustomerList(customerlist);
	}
	
	//get all Customer
	@GetMapping(value = "/allCustomers")
	public List<CustomerDetails> getAllCustomerDetails(){
		 return customerService.getAllCustomers();
	}	
}
