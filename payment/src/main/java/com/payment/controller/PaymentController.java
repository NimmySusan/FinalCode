package com.payment.controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.entity.Payment;
import com.payment.repository.PaymentRepository;

@RestController
@RequestMapping("/")
public class PaymentController
{
	private PaymentRepository paymentRepository;
	
	@Autowired
	public PaymentController(PaymentRepository paymentRepository)
	{
		this.paymentRepository=paymentRepository;
	}
	
	//view all payment
	@GetMapping("/all")
	public ResponseEntity<List<Payment>> getAll()
	{
		return ResponseEntity.ok(paymentRepository.findAll());
	}
	
	//add value 
	@PutMapping("/{oid}/{price}")
	public ResponseEntity<Payment> Create(@PathVariable Long oid, @PathVariable Long price, @RequestBody Payment payment)
	{
		try
		{
			Payment pay = new Payment();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/foodie?autoReconnect=true&useSSL=false","root","password");
	        Statement stmt2=con.createStatement();
	        ResultSet rs=stmt2.executeQuery("select price,customer_id from rorder where order_id="+ oid );
	        if(rs.next())
			{
	        	Long p=rs.getLong(1);
	        	Long q=rs.getLong(2);
	        	pay.setPrice(p);
	        	pay.setCustomerId(q);
			}
	        pay.setOrderId(oid);
	        pay.setPaymentMode(payment.getPaymentMode());
	        return ResponseEntity.ok(paymentRepository.save(pay));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
}
