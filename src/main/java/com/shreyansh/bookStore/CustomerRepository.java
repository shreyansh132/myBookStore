package com.shreyansh.bookStore;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerDetails, Integer> {

	
	List<CustomerDetails> findByFirstName(String firstName);

	List<CustomerDetails> findByActive(Integer active);

//	@Modifying
//	@Query("update CustomerDetails c set c.active= :active where c.customer_id= :id")
//	void makeActive(Integer id, Integer active);
//	

}
