package com.aamir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aamir.model.Airline;
import com.aamir.services.AirlineService;

@RestController
@RequestMapping(value = "/airline")
public class AirlineController {
	@Autowired
	private AirlineService service;
	
	
	@GetMapping(value = "/list")
	public ResponseEntity<List<Airline>> getAllAirlines() {
		System.out.println(""+new ResponseEntity<List<Airline>>(service.findAll(), HttpStatus.OK));
		return new ResponseEntity<List<Airline>>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Airline> getAirline(@PathVariable Integer id) {
		return new ResponseEntity<Airline>(service.findById(id), HttpStatus.OK);
	}

	@PostMapping(value = "/save")
	public ResponseEntity<Integer> newAirline(@RequestBody Airline airline) {
		System.out.println("controller ::"+airline);
		return new ResponseEntity<Integer>(service.save(airline), HttpStatus.OK);
	}

	@PatchMapping(value = "/update")
	public ResponseEntity<Integer> updateAirline(@RequestBody Airline airline) {
		return new ResponseEntity<Integer>(service.update(airline), HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<Integer> deleteAirline(@RequestBody Airline airline) {
		return new ResponseEntity<Integer>(service.deleteById(airline.getAirlineId()), HttpStatus.OK);
	}
	

}
