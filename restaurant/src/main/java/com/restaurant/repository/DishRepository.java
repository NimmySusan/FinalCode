package com.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.entity.Dish;

public interface DishRepository extends JpaRepository<Dish, Long> {

}
