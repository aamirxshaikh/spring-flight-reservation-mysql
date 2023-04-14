package com.aamir.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aamir.model.Customer;
import com.aamir.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	
	public List<Customer> getAllCustomers () {
		return repository.findAll();
	}
	
	public Customer getCustomerById (int id) {
		Optional<Customer> customer = repository.findById(id);
		
		if (customer.isPresent()) {
            System.out.println(customer);
            return customer.get();
        } else {
            return new Customer(); 
        }
	}
	
	public int newCustomer (Customer customer) {
		Optional<Customer> existsCustomer = repository.findById(customer.getCustomerId());

		int id = 0;
        
        if (existsCustomer.isPresent()) {
            id = -1;
        } else {
        	Customer customer2 = repository.saveAndFlush(customer);
            id = customer2.getCustomerId();
        }
        
        return id;
	}
	
	public int updateCustomer (Customer customer) {
		Optional<Customer> existsCustomer = repository.findById(customer.getCustomerId());

		int id = 0;
        
        if (existsCustomer.isPresent()) {
            id = customer.getCustomerId();
            
            repository.saveAndFlush(customer);
        } else {
        	id = -1;
        }
        
        return id;
	}
	
	public int deleteById (Integer customerId) {
		Optional<Customer> existsCustomer = repository.findById(customerId);

		int id = 0;
        
        if (existsCustomer.isPresent()) {
        	id = customerId;
        	
            repository.deleteById(customerId);
        } else {
        	id = -1;
        }
        
        return id;
	}
}
