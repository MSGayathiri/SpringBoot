package com.fab.customerservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
	public class CustomerServiceImpl implements CustomerService {

	    @Autowired
	    private CustomerRepository customerRepository;

	    @Override
	    public List<Customer> getAllCustomers() {
	        return customerRepository.findAll();
	    }

	    @Override
	    public Customer getCustomerById(Long id) {
	        return customerRepository.findById(id).orElseThrow();
	    }

	    @Override
	    public Customer createCustomer(Customer customer) {
	        return customerRepository.save(customer);
	    }

	    @Override
	    public Customer updateCustomer(Long id, Customer customer) {
	        Customer existingCustomer = getCustomerById(id);
	        existingCustomer.setName(customer.getName());
	        existingCustomer.setEmail(customer.getEmail());
	        existingCustomer.setPhone(customer.getPhone());
	        return customerRepository.save(existingCustomer);
	    }

	    @Override
	    public void deleteCustomer(Long id) {
	        customerRepository.deleteById(id);
	    }
	}


