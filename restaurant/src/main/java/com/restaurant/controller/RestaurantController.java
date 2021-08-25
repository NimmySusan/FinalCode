package com.restaurant.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.ArrayList;

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

import com.restaurant.entity.Dish;
import com.restaurant.entity.Restaurant;
import com.restaurant.repository.DishRepository;
import com.restaurant.repository.RestaurantRepository;
import com.restaurant.service.RestaurantService;

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
	
	
//	@PostMapping("/restaurant")
//	public ResponseEntity<Restaurant> save(@RequestBody Restaurant restaurant)
//	{
//	Restaurant obj = restaurantService.save(restaurant);
//	return new ResponseEntity<Restaurant>(obj,HttpStatus.CREATED);
//	}
	
//	@GetMapping("/customer/{loc}")
//	public void display(String loc)
//	{
//		try
//		{
//			Restaurant restaurant = new Restaurant();
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodie?autoReconnect=true&useSSL=false","root","password");
//	        Statement stmt2=con.createStatement();
//			ResultSet rs=stmt2.executeQuery("select * from restaurant where location="+"\""+loc+"\"");
//			
//			if(rs.next())
//			{
//				System.out.println(rs.getString(1));
//			}
//		}
//		catch(Exception e)
//		{
//			System.out.println(e);
//		}
//	}
	
	
	//adding restaurant
	@PutMapping("/restaurant/addRestaurant")
	public ResponseEntity<Restaurant> add(@RequestBody Restaurant restaurant) 
	{
		return ResponseEntity.ok(restaurantRepository.save(restaurant));
	}
	
	
}
