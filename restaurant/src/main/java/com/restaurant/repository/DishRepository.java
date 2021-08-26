package com.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.restaurant.entity.Dish;

@Service
public interface DishRepository extends JpaRepository<Dish, Long> {

}
