package com.example.flightreservation.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reservation {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String passengerName;
	    private String passengerEmail;
	    private int seatsBooked;
	    private LocalDateTime reservedAt;

	    @ManyToOne
	    @JoinColumn(name = "flight_id")
	    @JsonBackReference
	    private Flight flight;

		public Reservation() {
			
		}

		public Reservation(Long id, String passengerName, String passengerEmail, int seatsBooked,
				LocalDateTime reservedAt, Flight flight) {
			
			this.id = id;
			this.passengerName = passengerName;
			this.passengerEmail = passengerEmail;
			this.seatsBooked = seatsBooked;
			this.reservedAt = reservedAt;
			this.flight = flight;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getPassengerName() {
			return passengerName;
		}

		public void setPassengerName(String passengerName) {
			this.passengerName = passengerName;
		}

		public String getPassengerEmail() {
			return passengerEmail;
		}

		public void setPassengerEmail(String passengerEmail) {
			this.passengerEmail = passengerEmail;
		}

		public int getSeatsBooked() {
			return seatsBooked;
		}

		public void setSeatsBooked(int seatsBooked) {
			this.seatsBooked = seatsBooked;
		}

		public LocalDateTime getReservedAt() {
			return reservedAt;
		}

		public void setReservedAt(LocalDateTime reservedAt) {
			this.reservedAt = reservedAt;
		}

		public Flight getFlight() {
			return flight;
		}

		public void setFlight(Flight flight) {
			this.flight = flight;
		}
	
	
	
	
}
