package com.example.airline_api.models;

import java.util.List;
import java.util.Locale;

public class PassengerDTO {

    private String name;
    private String email;
    private List<Long> flight_id;

    public PassengerDTO(String name, String email, List<Long> flight_id) {
        this.name = name;
        this.email = email;
        this.flight_id = flight_id;
    }

    public PassengerDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Long> getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(List<Long> flight_id) {
        this.flight_id = flight_id;
    }
}
