package com.sac.crmdata.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "CUST_REF")
    @SequenceGenerator(sequenceName = "customer_reference", allocationSize = 1, name = "CUST_REF")
    private Long id;

    private String name;

    public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String email;

    @Column(name = "CREATED_DATE")
    private Date date;

    public Customer(String name, String email, Date date) {
		super();
		this.name = name;
		this.email = email;
		this.date = date;
	}
    
    public Customer(Long id, String name, String email, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.date = date;
	}

	public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
