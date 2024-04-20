package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the station name: ");
        String stationName = scanner.nextLine().toLowerCase();

        System.out.println("Enter the ticket type: ");
        System.out.println("Economy, Coupe, or Business");
        String ticketType = scanner.nextLine().toLowerCase();

        TicketFactory ticketFactory;
        switch (stationName) {
            case "a":
                ticketFactory = new StationAFactory();
                break;
            case "b":
                ticketFactory = new StationBFactory();
                break;
            case "c":
                ticketFactory = new StationCFactory();
                break;
            default:
                throw new IllegalArgumentException("Invalid station name");
        }

        Ticket ticket;
        switch (ticketType) {
            case "economy":
                ticket = ticketFactory.createEconomyTicket(stationName);
                break;
            case "coupe":
                ticket = ticketFactory.createCoupeTicket(stationName);
                break;
            case "business":
                ticket = ticketFactory.createBusinessTicket(stationName);
                break;
            default:
                throw new IllegalArgumentException("Invalid ticket type");
        }

        System.out.println(ticket.ticketDetails());
    }
}
