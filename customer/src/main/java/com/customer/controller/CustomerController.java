package com.customer.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.entity.Customer;
import com.customer.repository.CustomerRepository;

@RestController
@RequestMapping("/")
public class CustomerController 
{
	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerController(CustomerRepository customerRepository)
	{
		this.customerRepository=customerRepository;
	}
	
	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> getAll()
	{
		return ResponseEntity.ok(customerRepository.findAll());
	}
	
	//adding into
	@PutMapping("/customer")
	public ResponseEntity<Customer> add(@RequestBody Customer customer) 
	{
		return ResponseEntity.ok(customerRepository.save(customer));
	}
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> update(@RequestBody Customer customer) 
	{
		return ResponseEntity.ok(customerRepository.save(customer));
	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<Customer> delete(@PathVariable Long id)
	{
		customerRepository.findById(id).ifPresent(customerRepository::delete);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/customer/location/{loc}")
	public List Display(@PathVariable String loc) {
		try 
		{	
				ArrayList al = new ArrayList();
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/foodie?autoReconnect=true&useSSL=false","root","password");
		        Statement stmt1=con.createStatement();
		        ResultSet rs1=stmt1.executeQuery("select * from restaurant where location="+ "\"" +loc+"\""+ "and approval=" +true);
		        while(rs1.next())
		        {
		        	al.add(" Restaurant Id : " +rs1.getLong(1)+"  ||  Category : "+rs1.getLong(2)+
							"  || Restaurant Name : "+rs1.getString(3)+" || Contact Detail : "+rs1.getLong(5)+
				" ||Rating : "+rs1.getString(6));
		        }
		        return al;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
	
	@GetMapping("/customer/rname/{res}")
	public List DisplayByName(@PathVariable String res) {
		try 
		{	
				ArrayList al = new ArrayList();
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/foodie?autoReconnect=true&useSSL=false","root","password");
		        Statement stmt1=con.createStatement();
		        ResultSet rs1=stmt1.executeQuery("select * from restaurant where restaurant_name="+ "\"" +res+"\""+ "and approval=" +true);
		        while(rs1.next())
		        {
		        	al.add(" Restaurant Id : " +rs1.getLong(1)+"  ||  Category : "+rs1.getLong(2)+
							"  || Restaurant Location : "+rs1.getString(4)+" || Contact Detail : "+rs1.getLong(5)+
				" ||Restaurant : "+rs1.getString(6));
		        }
		        return al;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
	
	@GetMapping("/customer/rate/{rate}")
	public List DisplayByRating(@PathVariable String rate) {
		try 
		{	
				ArrayList al = new ArrayList();
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/foodie?autoReconnect=true&useSSL=false","root","password");
		        Statement stmt1=con.createStatement();
		        ResultSet rs1=stmt1.executeQuery("select * from restaurant where rating="+ "\"" +rate+"\""+ "and approval=" +true);
		        while(rs1.next())
		        {
		        	al.add(" Restaurant Id : " +rs1.getLong(1)+"  ||  Category : "+rs1.getLong(2)+
		    				" ||Restaurant Name : "+rs1.getString(3)+
							"  || Restaurant Location : "+rs1.getString(4)+" || Contact Detail : "+rs1.getLong(5));
		        }
		        return al;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
	
	@GetMapping("/customer/dname/{dname}")
	public List DisplayByDishName(@PathVariable String dname) {
		try 
		{	
				ArrayList al = new ArrayList();
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/foodie?autoReconnect=true&useSSL=false","root","password");
		        Statement stmt1=con.createStatement();
		        ResultSet rs1=stmt1.executeQuery("select dish.dishid,dish.restaurant_id,dish.price,dish.availability from dish,restaurant where dish.dishname="+ "\"" +dname+"\""+ "and restaurant.approval=" +true);
		        while(rs1.next())
		        {
		        	al.add(" Dish Id : " +rs1.getLong(1)+"  ||  Restaurant Id : "+rs1.getLong(2)+
							" || price : "+rs1.getLong(3)+
							" || Availability : "+rs1.getString(4));
		        }
		        return al;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
}
