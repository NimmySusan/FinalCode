package com.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer
{
	@Id
	private Long customerId;
	@Column
	private Long contactNum;
	@Column
	private String loc;
	@Column
	private String password;
	@Column
	private String customerName;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getContactNum() {
		return contactNum;
	}
	public void setContactNum(Long contactNum) {
		this.contactNum = contactNum;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String restaurantName) {
		this.customerName = restaurantName;
	}
	public Customer(Long customerId, Long contactNum, String loc, String password, String customerName) {
		super();
		this.customerId = customerId;
		this.contactNum = contactNum;
		this.loc = loc;
		this.password=password;
		this.customerName = customerName;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
