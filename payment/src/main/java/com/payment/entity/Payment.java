package com.payment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long PaymentId;
	@Column
	private Long OrderId;
	@Column
	private String PaymentMode;
	@Column
	private Long customerId;
	@Column
	private Long price;
//	private Long AccountNumber;
//	private String BankName;
	
	
	public Payment() {
	super();
	// TODO Auto-generated constructor stub
	}

	
	public Long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	public Long getPrice() {
		return price;
	}


	public void setPrice(Long price) {
		this.price = price;
	}


	public Long getPaymentId() {
		return PaymentId;
	}

	public void setPaymentId(Long paymentId) {
		PaymentId = paymentId;
	}

	public Long getOrderId() {
		return OrderId;
	}

	public void setOrderId(Long orderId) {
		OrderId = orderId;
	}

	public String getPaymentMode() {
		return PaymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		PaymentMode = paymentMode;
	}

	public Payment(Long paymentId, Long orderId, String paymentMode,Long price,Long customerId) {
		super();
		PaymentId = paymentId;
		OrderId = orderId;
		PaymentMode = paymentMode;
		this.price=price;
		this.customerId=customerId;
	}
	
	
}
