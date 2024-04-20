package org.example;

public abstract class Ticket {
    private String stationName;

    public Ticket(String stationName) {
        this.stationName = stationName;
    }

    public abstract String ticketDetails();

    public String getStationName() {
        return stationName;
    }
}