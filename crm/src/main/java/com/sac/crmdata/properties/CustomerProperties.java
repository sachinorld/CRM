package com.sac.crmdata.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "customer")
@PropertySource("classpath:config.properties")
public class CustomerProperties {

	@Value("${customer.sachin_mail_id}")
	private String sachin_mail_id;

	public String getSachin_mail_id() {
		return sachin_mail_id;
	}

	public void setSachin_mail_id(String sachin_mail_id) {
		this.sachin_mail_id = sachin_mail_id;
	}
	
}
