package com.aamir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aamir.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
