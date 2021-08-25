package com.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.entity.Dish;
import com.restaurant.repository.DishRepository;

@RestController
@RequestMapping("/")
public class DishController 
{

	private DishRepository dishRepository;
	
	@Autowired
	public DishController(DishRepository dishRepository)
	{
	this.dishRepository = dishRepository;
	}
	
	@PutMapping("/restaurant/dish")
	public ResponseEntity<Dish> add(@RequestBody Dish dish) 
	{
		return ResponseEntity.ok(dishRepository.save(dish));
	}
	
	@PostMapping("/restaurant/dish")
	public ResponseEntity<Dish> update(@RequestBody Dish dish) 
	{
		return ResponseEntity.ok(dishRepository.save(dish));
	}
	
	@DeleteMapping("/restaurant/dish/{id}")
	public ResponseEntity<Dish> delete(@PathVariable Long id) {
		dishRepository.findById(id).ifPresent(dishRepository::delete);
		return ResponseEntity.ok().build();
	}
}
