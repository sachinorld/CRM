package com.sac.crmdata.crm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.sac.crmdata.dao.CustomerRepository;
import com.sac.crmdata.entity.Customer;
import com.sac.crmdata.properties.CustomerProperties;
import com.sac.crmdata.rest.service.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { CrmApplication.class })
@TestPropertySource("classpath:config-test.properties")
@EnableAutoConfiguration
@ActiveProfiles("test")
public class CustomerServiceTest {
	
	CustomerService customerService;
	CustomerRepository repository;
	CustomerProperties propertiesMock;
	
	@Autowired
	CustomerProperties properties;
	
	@Before
	public void prepare() {
		repository = Mockito.mock(CustomerRepository.class);
		customerService = new CustomerService(repository);
		propertiesMock = Mockito.mock(CustomerProperties.class);
		customerService.setProperties(propertiesMock);
	}
	
	@Test
	public void testGetCustomer() {
		List<Customer> list = new ArrayList<Customer>();
		list.add(new Customer(1L, "sachin", "111@test.com", new Date()));
		Mockito.when(repository.findByEmail("111@test.com")).thenReturn(list);
		Mockito.when(propertiesMock.getSachin_mail_id()).thenReturn(properties.getSachin_mail_id());
		Customer customer = customerService.getCustomerLookup("sachin");
		
		Assert.assertNotNull(customer);
	}
}
