package com.order.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROrder")
public class Order 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	@Column
	private Long quantity;
	@Column
	private Long price;
	@Column
	private Long dishId;
	@Column
	private String dishName;
	@Column
	private Long restaurantId;
	@Column
	private Long customerId;
	@Column
	private String feedBack;
	@Column
	private String rating;
	@Column 
	private String status="Order Placed";
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getPrice() {
		return price;
	}


	public void setPrice(Long price) {
		this.price = price;
	}


	public Long getOrderId() {
		return orderId;
	}


	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}


	public Long getQuantity() {
		return quantity;
	}


	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}


	public Long getDishId() {
		return dishId;
	}


	public void setDishId(Long dishId) {
		this.dishId = dishId;
	}


	public String getDishName() {
		return dishName;
	}


	public void setDishName(String dishName) {
		this.dishName = dishName;
	}


	public Long getRestaurantId() {
		return restaurantId;
	}


	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}


	public Long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	public String getFeedBack() {
		return feedBack;
	}


	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Order(Long orderId, String dishName, Long restaurantId,Long customerId, Long dishId,  Long quantity,
			Long price,String feedBack, String rating, String status) {
		super();
		this.orderId = orderId;
		this.quantity = quantity;
		this.dishId = dishId;
		this.dishName = dishName;
		this.restaurantId = restaurantId;
		this.customerId = customerId;
		this.price=price;
		this.feedBack = feedBack;
		this.rating = rating;
		this.status = status;
	}

	
	
	

}
