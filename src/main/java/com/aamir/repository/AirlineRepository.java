package com.aamir.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aamir.model.Airline;

public interface AirlineRepository extends JpaRepository<Airline,Integer> {

}
