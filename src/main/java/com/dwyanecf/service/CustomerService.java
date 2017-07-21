package com.dwyanecf.service;

import java.util.List;

import com.dwyanecf.entity.Customer;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerService {

	public Customer getCustomer(int theId);

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public void deleteCustomer(int id);
}
