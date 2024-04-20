package org.example;

public class EconomyTicket extends Ticket {
    public EconomyTicket(String stationName) {
        super(stationName);
    }

    @Override
    public String ticketDetails() {
        return "This is an Economy class ticket purchased at " + getStationName() + " station.";
    }
}