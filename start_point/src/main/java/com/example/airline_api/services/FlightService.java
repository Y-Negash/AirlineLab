package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.FlightDTO;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.models.PassengerDTO;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;


    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight findFlightById(Long id) {
        return flightRepository.findById(id).get();
    }

    public Flight addFlight(FlightDTO flightDTO) {

        Flight flight = new Flight(
                flightDTO.getDestination(),
                flightDTO.getCapacity(),
                flightDTO.getDepartureDate(),
                flightDTO.getDepartureTime()
        );

            for(Long passengerIds : flightDTO.getPassenger_ids()){
                Passenger passenger = passengerRepository.findById(passengerIds).get();
                flight.addPassenger(passenger);
            }
            return flightRepository.save(flight);
        }

    public Flight addPassenger(FlightDTO flightDTO, Long id) {
        Flight updatedFlight = flightRepository.findById(id).get();
        updatedFlight.setDestination(flightDTO.getDestination());
        updatedFlight.setCapacity(flightDTO.getCapacity());
        updatedFlight.setDepartureDate(flightDTO.getDepartureDate());
        updatedFlight.setDepartureTime(flightDTO.getDepartureTime());
        updatedFlight.setPassengers(new ArrayList<>());

        for (long passengerIds: flightDTO.getPassenger_ids()){
            Passenger passenger = passengerRepository.findById(passengerIds).get();
            updatedFlight.addPassenger(passenger);
        }
        return flightRepository.save(updatedFlight);
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }
}
