package com.example.flightreservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flightreservation.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{
	 List<Reservation> findByFlightId(Long flightId);
}
