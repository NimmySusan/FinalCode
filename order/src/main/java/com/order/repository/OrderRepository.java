package com.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.order.entity.Order;

@Service
public interface OrderRepository extends JpaRepository<Order,Long>{

}
