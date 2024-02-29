package com.example.airline_api.models;

import java.util.List;
import java.util.Locale;

public class PassengerDTO {

    private String name;
    private String email;
    private List<Long> flight_ids;

    public PassengerDTO(String name, String email, List<Long> flight_ids) {
        this.name = name;
        this.email = email;
        this.flight_ids = flight_ids;
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

    public List<Long> getFlight_ids() {
        return flight_ids;
    }

    public void setFlight_ids(List<Long> flight_ids) {
        this.flight_ids = flight_ids;
    }
}
