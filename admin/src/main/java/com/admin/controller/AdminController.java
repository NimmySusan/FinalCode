package com.admin.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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


@RestController
@RequestMapping("/")
public class AdminController 
{
//	private AdminRepository adminRepository;
//	
//	@Autowired
//	public AdminController(AdminRepository adminRepository)
//	{
//		this.adminRepository=adminRepository;
//	}
	
//	@PutMapping("/admin")
//	public ResponseEntity<Admin> add(@RequestBody Admin admin) 
//	{
//		return ResponseEntity.ok(adminRepository.save(admin));
//	}
	
	@PutMapping("/admin/restaurant/{rid}")
	public String approve(@PathVariable Long rid)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/foodie?autoReconnect=true&useSSL=false","root","password");
	        Statement stmt2=con.createStatement();
			stmt2.executeUpdate("update restaurant SET approval="+true +" where restaurant_id="+ rid);
			
			return "Approved";
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
	
	@DeleteMapping("/admin/restaurant/delete/{rid}")
	public String delete(@PathVariable Long rid)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/foodie?autoReconnect=true&useSSL=false","root","password");
	        Statement stmt2=con.createStatement();
			stmt2.executeUpdate("update restaurant SET approval="+false +" where restaurant_id="+ rid);
			
			return "Disabled";
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
	
	@GetMapping("/admin/allfeedback")
	public List feed()
	{
		try 
		{	
				ArrayList al = new ArrayList();
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/foodie?autoReconnect=true&useSSL=false","root","password");
		        Statement stmt1=con.createStatement();
		        ResultSet rs1=stmt1.executeQuery("select feed_back from rorder");
		        ResultSetMetaData rsmd = rs1.getMetaData();
		        int count=rsmd.getColumnCount();
		        if(rs1.next())
		        {
		        	for(int i=1;i<=count;i++)
		        	{
		        		al.add(rs1.getString(i));
		        	}
		        }
		        return al;
		        
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
	
	@GetMapping("/admin/status")
	public List status()
	{
		try
		{
			ArrayList al = new ArrayList();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/foodie?autoReconnect=true&useSSL=false","root","password");
	        Statement stmt1=con.createStatement();
	        ResultSet rs1=stmt1.executeQuery("select status,order_id from rorder");
	        ResultSetMetaData rsmd = rs1.getMetaData();
	        int count=rsmd.getColumnCount();
	        if(rs1.next())
	        {
	        	for(int i=1;i<=count;i++)
	        	{
	        		al.add(rs1.getString(i));
	        	}
	        }
	        return al;
	        
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
	
	@GetMapping("/admin/changestatus/{id}")
	public String cstatus(@PathVariable Long id)
	{
		try
		{
			ArrayList al = new ArrayList();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/foodie?autoReconnect=true&useSSL=false","root","password");
	        Statement stmt1=con.createStatement();
	        stmt1.executeUpdate("Update rorder SET status="+"\"Delievered\""+ " where order_id="+id);
	        return "Updated";
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
}
