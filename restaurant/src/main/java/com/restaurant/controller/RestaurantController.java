package com.restaurant.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.ArrayList;

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

import com.restaurant.entity.Restaurant;
import com.restaurant.repository.RestaurantRepository;

@RestController
@RequestMapping("/")
public class RestaurantController 
{
	private RestaurantRepository restaurantRepository;
	
	
	@Autowired
	public RestaurantController(RestaurantRepository restaurantRepository)
	{
	this.restaurantRepository = restaurantRepository;
	}

	//adding restaurant
	@PutMapping("/restaurant/addRestaurant")
	public ResponseEntity<Restaurant> add(@RequestBody Restaurant restaurant) 
	{
		return ResponseEntity.ok(restaurantRepository.save(restaurant));
	}
	
	//view all restaurant
	@GetMapping("/restaurant")
	public ResponseEntity<List<Restaurant>> getAll()
	{
		return ResponseEntity.ok(restaurantRepository.findAll());
	}
	
	@PostMapping("/restaurant")
	public ResponseEntity<Restaurant> update(@RequestBody Restaurant restaurant) 
	{
		return ResponseEntity.ok(restaurantRepository.save(restaurant));
	}
	
	@DeleteMapping("/restaurant")
	public ResponseEntity<Restaurant> delete(@PathVariable Long id) {
		restaurantRepository.findById(id).ifPresent(restaurantRepository::delete);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/restaurant/order/{rid}")
	public List Display(@PathVariable Long rid) {
		try 
		{	
				ArrayList al = new ArrayList();
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/foodie?autoReconnect=true&useSSL=false","root","password");
		        Statement stmt1=con.createStatement();
		        ResultSet rs1=stmt1.executeQuery("select * from rorder where restaurant_id="+ "\"" +rid+"\"");
		        while(rs1.next())
		        {
		        	al.add(" Order Id : " +rs1.getLong(1)+"  ||  Quantity : "+rs1.getLong(2)+"  ||  Price : "+rs1.getLong(3)+
							"  || Dish Name : "+rs1.getString(5)+" || Customer Id : "+rs1.getLong(7));
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
