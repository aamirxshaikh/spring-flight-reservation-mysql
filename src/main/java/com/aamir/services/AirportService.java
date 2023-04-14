package com.aamir.services;
 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aamir.model.Airport;
import com.aamir.repository.AirportRepository;


@Service
public class AirportService {
	@Autowired
	private AirportRepository repository;
	
	
	public List<Airport> findAll() {
		return repository.findAll();
	}

	public Airport findById(int id) {
		Optional<Airport> airport = repository.findById(id);
		if (airport.isPresent()) {
			System.out.println(airport);
			return airport.get();
		} else {
			return new Airport(); 
		}
	}

	public int save(Airport airport) {
		int id = 0;
		if (repository.existsById(airport.getAirportId())) {
			id = -1;
		} else {
			Airport airport2 = repository.saveAndFlush(airport);
			id = airport2.getAirportId();
		}
		return id;
	}

	public int update(Airport airport) {
		Optional<Airport> existsAirport = repository.findById(airport.getAirportId());
		int id = 0;
		if (existsAirport.isPresent()) {
			repository.saveAndFlush(airport);
			id = 1;
		} else {
			id = -1;
		}
		return id;
	}

	public int deleteById(Integer id) {
		Optional<Airport> existsAirport = repository.findById(id);
		int i = 0;
		if (existsAirport.isPresent()) {
			repository.deleteById(id);
			i = 1;
		} else {
			i = -1;
		}
		return i;
	}

}