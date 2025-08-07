package com.example.flightreservation.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightreservation.entity.Flight;
import com.example.flightreservation.entity.Reservation;
import com.example.flightreservation.repository.FlightRepository;
import com.example.flightreservation.repository.ReservationRepository;

@Service
public class ReservationService {
	@Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private FlightRepository flightRepository;

    public Reservation makeReservation(Long flightId, Reservation reservation) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new RuntimeException("Flight not found."));

        if (flight.getSeatsAvailable() < reservation.getSeatsBooked()) {
            throw new RuntimeException("Not enough seats available.");
        }

        flight.setSeatsAvailable(flight.getSeatsAvailable() - reservation.getSeatsBooked());
        reservation.setReservedAt(LocalDateTime.now());
        reservation.setFlight(flight);

        flightRepository.save(flight);  // Update flight seats
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public List<Reservation> getReservationsByFlight(Long flightId) {
        return reservationRepository.findByFlightId(flightId);
    }

    public void cancelReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found."));
        
        Flight flight = reservation.getFlight();
        flight.setSeatsAvailable(flight.getSeatsAvailable() + reservation.getSeatsBooked());
        flightRepository.save(flight);

        reservationRepository.delete(reservation);
    }
}
