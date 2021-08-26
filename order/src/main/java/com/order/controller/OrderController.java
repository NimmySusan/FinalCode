package com.order.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.entity.Order;
import com.order.repository.OrderRepository;

@RestController
@RequestMapping("/")
public class OrderController
{
	private OrderRepository orderRepository;
	
	@Autowired
	public OrderController(OrderRepository orderRepository)
	{
		this.orderRepository=orderRepository;
	}
	
	//showing all the orders
	@GetMapping("/allOrders")
	public ResponseEntity<List<Order>> getAll()
	{
		return ResponseEntity.ok(orderRepository.findAll());
	}
	
	//directly taking values from database
	@PutMapping("/{cid}/{rid}/{did}/{quantity}")
	public ResponseEntity<Order> Create(@PathVariable Long cid,@PathVariable Long rid,@PathVariable Long did,@PathVariable Long quantity,@RequestBody Order order1)
	{
		try
		{
			Order order = new Order();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/foodie?autoReconnect=true&useSSL=false","root","password");
	        Statement stmt2=con.createStatement();
			ResultSet rs=stmt2.executeQuery("select price,dishname from dish where dishid="+  did );
			//System.out.println("Got the info");
			Long s=null;
			if(rs.next())
			{
				s=rs.getLong(1);
				String dishname=rs.getString(2);
				//order.setRestaurantId(restaurant_id);
				order.setDishName(dishname);
			}
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodie?autoReconnect=true&useSSL=false","root","password");
			order.setRestaurantId(rid);
			order.setCustomerId(cid);
			order.setDishId(did);
			order.setQuantity(quantity);
			order.setFeedBack(null);
			order.setRating(null);
			Long p= quantity*s;
			order.setPrice(p);
			
			order.setFeedBack(order1.getFeedBack());
			order.setRating(order1.getRating());
			
			return ResponseEntity.ok(orderRepository.save(order));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
	
	//deleting a order
	@DeleteMapping("/deleteOrder/{id}")
	public ResponseEntity<Order> delete(@PathVariable Long id)
	{
		orderRepository.findById(id).ifPresent(orderRepository::delete);
		return ResponseEntity.ok().build();
	}
}
