package com.aamir.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aamir.model.Airline;
import com.aamir.repository.AirlineRepository;

@Service
public class AirlineService {
	@Autowired
	private AirlineRepository repository;
	
	
	public List<Airline> findAll() {
		return repository.findAll();
	}

	public Airline findById(int id) {
		Optional<Airline> airline = repository.findById(id);
		if (airline.isPresent()) {
			System.out.println(airline);
			return airline.get();
		} else {
			return new Airline(); 
		}
	}

	public int save(Airline airline) {
		int id = 0;
		if (repository.existsById(airline.getAirlineId())) {
			id = -1;
		} else {
			Airline airline2 = repository.saveAndFlush(airline);
			id = airline2.getAirlineId();
		}
		return id;
	}

	public int update(Airline airline) {
		Optional<Airline> existsAirline = repository.findById(airline.getAirlineId());
		int id = 0;
		if (existsAirline.isPresent()) {
			repository.saveAndFlush(airline);
			id = 1;
		} else {
			id = -1;
		}
		return id;
	}

	public int deleteById(Integer id) {
		Optional<Airline> existsAirline = repository.findById(id);
		int i = 0;
		if (existsAirline.isPresent()) {
			repository.deleteById(id);
			i = 1;
		} else {
			i = -1;
		}
		return i;
	}

}
