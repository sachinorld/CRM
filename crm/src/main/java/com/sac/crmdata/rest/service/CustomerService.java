package com.sac.crmdata.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sac.crmdata.dao.CustomerRepository;
import com.sac.crmdata.entity.Customer;
import com.sac.crmdata.model.CustomerDTO;
import com.sac.crmdata.properties.CustomerProperties;

@Service
public class CustomerService {

	CustomerRepository repository;
	CustomerProperties properties;
	
	@Autowired
	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}
	
	@Autowired
	public void setProperties(CustomerProperties properties) {
		this.properties = properties;
	}

	public Customer getCustomerLookup(String custName) {
		// TODO fetch mailId for custName.
		String custEmail = properties.getSachin_mail_id();
		List<Customer> custList = repository.findByEmail(custEmail);
		Customer resultCust = custList.stream().filter(customer -> custName.equals(customer.getName())).findFirst()
				.get();
		return resultCust;
	}

	/*
	 * Notice that use of @Transactional updates the user stored in DB with email. 
	 * No need of explicit update DB operation.
	 */
	@Transactional
	public Customer getCustomer(CustomerDTO custDTO) {
		Customer customer = repository.findById(custDTO.getId());
		customer.setEmail(custDTO.getEmail());
		return customer;
	}
}
