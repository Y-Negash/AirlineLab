package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.models.PassengerDTO;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightRepository flightRepository;
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public Passenger findPassengerById(Long id) {
        return passengerRepository.findById(id).get();
    }


    public Passenger addPassenger(PassengerDTO passengerDTO) {

        Passenger passenger = new Passenger(passengerDTO.getName(), passengerDTO.getEmail());

        for(Long flightIds : passengerDTO.getFlight_ids()){
            Flight flight = flightRepository.findById(flightIds).get();
            passenger.addFlight(flight);
        }
        return passengerRepository.save(passenger);
    }

}
