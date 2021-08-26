package com.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.customer.entity.Customer;
@Service
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
