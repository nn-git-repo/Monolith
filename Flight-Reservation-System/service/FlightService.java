package com.example.flightreservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightreservation.entity.Flight;
import com.example.flightreservation.repository.FlightRepository;

@Service
public class FlightService {
	@Autowired
    private FlightRepository flightRepository;

    public Flight addFlight(Flight flight) {
        if (flightRepository.findByFlightNumber(flight.getFlightNumber()).isPresent()) {
            throw new RuntimeException("Flight number already exists.");
        }
        return flightRepository.save(flight);
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found."));
    }

    public Flight updateFlight(Long id, Flight flightDetails) {
        Flight flight = getFlightById(id);
        flight.setOrigin(flightDetails.getOrigin());
        flight.setDestination(flightDetails.getDestination());
        flight.setDepartureTime(flightDetails.getDepartureTime());
        flight.setSeatsAvailable(flightDetails.getSeatsAvailable());
        return flightRepository.save(flight);
    }

    public void deleteFlight(Long id) {
        Flight flight = getFlightById(id);
        flightRepository.delete(flight);
    }
}
