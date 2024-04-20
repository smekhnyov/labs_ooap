package org.example;

public class CoupeTicket extends Ticket {
    public CoupeTicket(String stationName) {
        super(stationName);
    }

    @Override
    public String ticketDetails() {
        return "This is a Coupe class ticket purchased at " + getStationName() + " station.";
    }
}