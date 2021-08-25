package com.restaurant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dish {
	@Id
	private Long dishid;
	@Column
	private Long restaurant_id;
	@Column
	private String dishname;
	@Column
	private Long price;
	@Column
	private String availability;
	
	public Long getRestaurant_id() {
		return restaurant_id;
	}
	public void setRestaurant_id(Long restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public Long getDishid() {
		return dishid;
	}
	public void setDishid(Long dishid) {
		this.dishid = dishid;
	}
	public String getDishname() {
		return dishname;
	}
	public void setDishname(String dishname) {
		this.dishname = dishname;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public Dish(Long dishid,Long restaurant_id, String dishname, Long price, String availability) {
		super();
		this.dishid = dishid;
		this.restaurant_id=restaurant_id;
		this.dishname = dishname;
		this.price = price;
		this.availability = availability;
		
	}
	public Dish() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
