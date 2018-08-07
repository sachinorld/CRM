package com.sac.crmdata.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sac.crmdata.rest.controller.CustomerController;

@SpringBootApplication(scanBasePackages = {"com.sac.crmdata"})
@EnableJpaRepositories("com.sac.crmdata.dao")
@PropertySource("classpath:config.properties")
@EntityScan("com.sac.crmdata.entity")
@EnableAutoConfiguration
public class CrmApplication {

//	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Autowired
	CustomerController controller;
/*	@Autowired
	DataSource dataSource;

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerProperties propeties;*/

	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);
	}

	/*@Transactional(readOnly = true)
	@Override
	public void run(String... args) {

		System.out.println("DATASOURCE = " + dataSource);

		System.out.println("\n1.findAll()...");
		for (Customer customer : customerRepository.findAll()) {
			System.out.println(customer.getName() + " : " + customer.getEmail());
		}
		String emailId = propeties.getSachin_mail_id();
		System.out.println("\n1.findByEmailId()..." + emailId);
		try {
			Customer customer = customerRepository.findByEmail(emailId).get(0);
			System.out.print(customer.getName() + " - " + customer.getEmail());
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Email '" + emailId + "' is not available.");
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\n3. findByDate....\nEnter created date to fetch customer details.");
		String dateText = sc.nextLine();
		sc.close();
		
		Date date;
		try {
			date = sdf.parse(dateText);
			List<Customer> list = customerRepository.findByDate(date);
			for (Customer customer : list) {
				System.out.println(customer.getName());
			}
		} catch (ParseException e) {
			System.err.println("Invalid input date: " + dateText);
		}
		
	}*/
}
