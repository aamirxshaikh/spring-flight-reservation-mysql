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

import com.aamir.model.Airport;
import com.aamir.services.AirportService;


@RestController
@RequestMapping(value = "/airport")
//@CrossOrigin(origins = "*")
public class AirportController {
	@Autowired
	private AirportService service;
	
	@GetMapping(value = "/list")
	public ResponseEntity<List<Airport>> getAllCountries() {
		System.out.println(""+new ResponseEntity<List<Airport>>(service.findAll(), HttpStatus.OK));
		return new ResponseEntity<List<Airport>>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Airport> getAirline(@PathVariable Integer id) {
		return new ResponseEntity<Airport>(service.findById(id), HttpStatus.OK);
	}

	@PostMapping(value = "/save")
	public ResponseEntity<Integer> newAirport(@RequestBody Airport airport) {
		System.out.println("controller ::"+airport);
		return new ResponseEntity<Integer>(service.save(airport), HttpStatus.OK);
	}

	@PatchMapping(value = "/update")
	public ResponseEntity<Integer> updateAirport(@RequestBody Airport airport) {
		return new ResponseEntity<Integer>(service.update(airport), HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<Integer> deleteAirport(@RequestBody Airport airport) {
		return new ResponseEntity<Integer>(service.deleteById(airport.getAirportId()), HttpStatus.OK);
	}
}

