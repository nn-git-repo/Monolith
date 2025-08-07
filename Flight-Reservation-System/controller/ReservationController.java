package com.example.flightreservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightreservation.entity.Reservation;
import com.example.flightreservation.service.ReservationService;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
	@Autowired
    private ReservationService reservationService;

    @PostMapping("/flight/{flightId}")
    public ResponseEntity<Reservation> makeReservation(@PathVariable Long flightId, @RequestBody Reservation reservation) {
        return new ResponseEntity<>(reservationService.makeReservation(flightId, reservation), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/flight/{flightId}")
    public List<Reservation> getReservationsByFlight(@PathVariable Long flightId) {
        return reservationService.getReservationsByFlight(flightId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelReservation(@PathVariable Long id) {
        reservationService.cancelReservation(id);
        return ResponseEntity.noContent().build();
    }
}
