package com.example.flightreservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightreservation.entity.Flight;
import com.example.flightreservation.service.FlightService;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
	  @Autowired
	    private FlightService flightService;

	    @PostMapping
	    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
	        return new ResponseEntity<>(flightService.addFlight(flight), HttpStatus.CREATED);
	    }

	    @GetMapping
	    public List<Flight> getAllFlights() {
	        return flightService.getAllFlights();
	    }

	    @GetMapping("/{id}")
	    public Flight getFlightById(@PathVariable Long id) {
	        return flightService.getFlightById(id);
	    }

	    @PutMapping("/{id}")
	    public Flight updateFlight(@PathVariable Long id, @RequestBody Flight flight) {
	        return flightService.updateFlight(id, flight);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
	        flightService.deleteFlight(id);
	        return ResponseEntity.noContent().build();
	    }
}
