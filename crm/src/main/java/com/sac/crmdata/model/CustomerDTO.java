package com.sac.crmdata.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class CustomerDTO {

	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Long id;
	private String name;
	private String email;
	private Long date;
	public CustomerDTO(Long id, String name, String email, Long date) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.date = date;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getDate() {
		return date;
	}
	public void setDate(Long date) {
		this.date = date;
	}
}
