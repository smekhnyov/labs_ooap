package org.example;

public abstract class TicketFactory {
    public abstract EconomyTicket createEconomyTicket(String stationName);
    public abstract CoupeTicket createCoupeTicket(String stationName);
    public abstract BusinessTicket createBusinessTicket(String stationName);
}