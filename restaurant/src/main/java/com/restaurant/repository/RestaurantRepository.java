package com.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.restaurant.entity.Restaurant;

@Service
public interface RestaurantRepository extends JpaRepository<Restaurant, Long>
{
}