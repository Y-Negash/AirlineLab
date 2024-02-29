package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

   @Autowired
    FlightRepository flightRepository;

   @Autowired
    PassengerRepository passengerRepository;

    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Flight japan = new Flight("Japan", 300, "20/05/24", "20:35");
        Flight brazil = new Flight("Brazil", 200, "19/11/24", "14:30");
        Flight congo = new Flight("Congo", 150, "30/01/25", "01:00");
        Flight india = new Flight("India", 400, "02/02/26", "15:00");
        Flight belgium = new Flight("Belgium", 150, "30/01/25", "01:00");

        flightRepository.save(japan);
        flightRepository.save(brazil);
        flightRepository.save(congo);
        flightRepository.save(india);
        flightRepository.save(belgium);

        Passenger sallie = new Passenger("Sallie", "sallie0101@gmail.com");
        Passenger drake = new Passenger("Drake", "draKe564@gmail.com");
        Passenger mike = new Passenger("Mike", "bestpassengerEver@gmail.com");
        Passenger karen = new Passenger("Karen", "worstpassengerEVER@gmail.com");

        passengerRepository.save(sallie);
        passengerRepository.save(drake);
        passengerRepository.save(mike);
        passengerRepository.save(karen);

    }
}
