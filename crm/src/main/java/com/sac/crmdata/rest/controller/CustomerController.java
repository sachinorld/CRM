package com.sac.crmdata.rest.controller;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sac.crmdata.dao.CustomerRepository;
import com.sac.crmdata.entity.Customer;
import com.sac.crmdata.model.CustomerDTO;
import com.sac.crmdata.rest.service.CustomerService;

@Controller
public class CustomerController {

	private static final Logger logger = LogManager.getLogger(CustomerController.class);
	
	public CustomerController() {
		super();
	}

	@Autowired
	CustomerService customerService;
	
	@Autowired
	CustomerRepository repository;
	
	@GetMapping(value = "/customers", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> list = (List<Customer>) repository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping(value = "/customer/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public ResponseEntity<Customer> getCustomer(@PathVariable("id")Long id) {
		logger.debug("getting customer details: " + id);
		return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id));
	}
	
	@GetMapping(value = "/customer", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public ResponseEntity<Customer> getCustomerLookup(@RequestParam("name")String name) {
		logger.debug("getting customer details: " + name);
		return ResponseEntity.status(HttpStatus.OK).body(customerService.getCustomerLookup(name));
	}
	
	@PutMapping(value = "/customer", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public ResponseEntity<Customer> getCustomer(@RequestBody CustomerDTO custDTO) {
		logger.debug("getting customer details ");
		return ResponseEntity.status(HttpStatus.OK).body(customerService.getCustomer(custDTO));
	}
	
	@PostMapping(value = "/customer", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Customer> addCustomer(@RequestBody CustomerDTO cust) {
		Date date = new Date(cust.getDate());
		Customer entity = repository.save(new Customer(cust.getName(), cust.getEmail(), date));
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}
}
