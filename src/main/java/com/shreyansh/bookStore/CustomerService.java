package com.shreyansh.bookStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerService {
	
	@Autowired 
	private CustomerRepository customerRepository;
	
	//Add new Customer
		public void addNewCustomer(CustomerDetails customerDetails) {
			customerRepository.save(customerDetails);
		}
		
	//Add new Customer
		public void addCustomerList(List<CustomerDetails> customerDetails) {
			customerRepository.saveAll(customerDetails);
		}
	
//	//make Customer active/inactive
//	public void makeActive(Integer id, Integer active) {
//			customerRepository.makeActive(id, active);
//	}	
			
		//delete new Customer
		public void deleteCustomer(CustomerDetails customerDetails) {
			customerRepository.delete(customerDetails);
		}
		
		//update Customer
		public void updateCustomer(CustomerDetails customerDetails) {
			Integer id = customerDetails.getCustomerId();
			Optional<CustomerDetails> result = customerRepository.findById(id);
			if(result.isPresent())
				customerRepository.save(customerDetails);
			else throw new RuntimeException("Did not find Customer for the id :" +id);  
		}
		
		//get Customer with id
		public CustomerDetails getCustomerById(Integer id) {
			CustomerDetails customerDetails = null;
			if(customerRepository.existsById(id)) {
				Optional<CustomerDetails> result = customerRepository.findById(id);
				customerDetails = result.get();
			}
			else throw new RuntimeException("Did not find Customer for the id :" +id);  
			return customerDetails;
		}
		
		//get Customer list
		public List<CustomerDetails> getAllCustomers() {
			List<CustomerDetails> CustomerList = new ArrayList<CustomerDetails>();
			for(CustomerDetails p : customerRepository.findAll()) {
				CustomerList.add(p);
			}
			return CustomerList;
		}

		//get Customer by first name
		public List<CustomerDetails> getCustomerByName(String name) {
			return customerRepository.findByFirstName(name);
		}
		
		//All Active/Inactive Customers
		public List<CustomerDetails> getActiveCustomers(Integer active) {
			return customerRepository.findByActive(active);
		}
		
	//Delete all Customers
		public void deleteAllCustomers() {
			 customerRepository.deleteAll();
		}
		
	//Delete all Customers
		public void deleteById(Integer id) {
			 customerRepository.deleteById(id);
		}	
		
	//total number of Customers available
		public Long customersCount() {
			return customerRepository.count();
		}
}
