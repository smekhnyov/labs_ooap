package org.example;

public class BusinessTicket extends Ticket {
    public BusinessTicket(String stationName) {
        super(stationName);
    }

    @Override
    public String ticketDetails() {
        return "This is a Business class ticket purchased at " + getStationName() + " station.";
    }
}