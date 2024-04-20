package org.example;

public class StationBFactory extends TicketFactory {
    @Override
    public EconomyTicket createEconomyTicket(String stationName) {
        return new EconomyTicket(stationName);
    }

    @Override
    public CoupeTicket createCoupeTicket(String stationName) {
        return new CoupeTicket(stationName);
    }

    @Override
    public BusinessTicket createBusinessTicket(String stationName) {
        return new BusinessTicket(stationName);
    }
}