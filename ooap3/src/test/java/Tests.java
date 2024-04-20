import org.junit.jupiter.api.Test;

import org.example.Ticket;
import org.example.EconomyTicket;
import org.example.CoupeTicket;
import org.example.BusinessTicket;
import org.example.TicketFactory;
import org.example.StationAFactory;
import org.example.StationBFactory;
import org.example.StationCFactory;


import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Tests {
    @Test
    public void testStationATicket() {
        TicketFactory stationAFactory = new StationAFactory();

        EconomyTicket economyTicketA = stationAFactory.createEconomyTicket("A");
        CoupeTicket coupeTicketA = stationAFactory.createCoupeTicket("A");
        BusinessTicket businessTicketA = stationAFactory.createBusinessTicket("A");

        assertEquals("A", economyTicketA.getStationName());
        assertEquals("A", coupeTicketA.getStationName());
        assertEquals("A", businessTicketA.getStationName());

        assertEquals("This is an Economy class ticket purchased at A station.", economyTicketA.ticketDetails());
        assertEquals("This is a Coupe class ticket purchased at A station.", coupeTicketA.ticketDetails());
        assertEquals("This is a Business class ticket purchased at A station.", businessTicketA.ticketDetails());
    }

    @Test
    public void testStationBTicket() {
        TicketFactory stationBFactory = new StationBFactory();

        EconomyTicket economyTicketB = stationBFactory.createEconomyTicket("B");
        CoupeTicket coupeTicketB = stationBFactory.createCoupeTicket("B");
        BusinessTicket businessTicketB = stationBFactory.createBusinessTicket("B");

        assertEquals("B", economyTicketB.getStationName());
        assertEquals("B", coupeTicketB.getStationName());
        assertEquals("B", businessTicketB.getStationName());

        assertEquals("This is an Economy class ticket purchased at B station.", economyTicketB.ticketDetails());
        assertEquals("This is a Coupe class ticket purchased at B station.", coupeTicketB.ticketDetails());
        assertEquals("This is a Business class ticket purchased at B station.", businessTicketB.ticketDetails());
    }

    @Test
    public void testStationCFactory() {
        TicketFactory stationCFactory = new StationCFactory();

        // Создаем билеты на станции C
        EconomyTicket economyTicketC = stationCFactory.createEconomyTicket("C");
        CoupeTicket coupeTicketC = stationCFactory.createCoupeTicket("C");
        BusinessTicket businessTicketC = stationCFactory.createBusinessTicket("C");

        // Проверяем детали билетов
        assertEquals("C", economyTicketC.getStationName());
        assertEquals("C", coupeTicketC.getStationName());
        assertEquals("C", businessTicketC.getStationName());

        assertEquals("This is an Economy class ticket purchased at C station.", economyTicketC.ticketDetails());
        assertEquals("This is a Coupe class ticket purchased at C station.", coupeTicketC.ticketDetails());
        assertEquals("This is a Business class ticket purchased at C station.", businessTicketC.ticketDetails());
    }

    @Test
    public void testExceptionFactory() {
        String invalidStationName = "d"; // Недопустимое значение станции

        // Проверяем, что исключение IllegalArgumentException выбрасывается при недопустимом значении станции
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            TicketFactory ticketFactory;
            switch (invalidStationName) {
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
        });

        // Проверяем сообщение исключения
        String expectedMessage = "Invalid station name";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testExceptionTicket() {
        String invalidTicketType = "SV"; // Недопустимое значение станции

        // Проверяем, что исключение IllegalArgumentException выбрасывается при недопустимом значении станции
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Ticket ticket;
            TicketFactory ticketFactory = new StationAFactory();
            switch (invalidTicketType) {
                case "economy":
                    ticket = ticketFactory.createEconomyTicket("A");
                    break;
                case "coupe":
                    ticket = ticketFactory.createCoupeTicket("A");
                    break;
                case "business":
                    ticket = ticketFactory.createBusinessTicket("A");
                    break;
                default:
                    throw new IllegalArgumentException("Invalid ticket type");
            }
        });

        // Проверяем сообщение исключения
        String expectedMessage = "Invalid ticket type";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testCreateManyTickets() {
        TicketFactory stationAFactory = new StationAFactory();
        int numTickets = 100;

        for (int i = 0; i < numTickets; i++) {
            EconomyTicket economyTicket = stationAFactory.createEconomyTicket("Station A");
            assertNotNull(economyTicket); // Проверяем, что билет был создан
            assertEquals("Station A", economyTicket.getStationName()); // Проверяем, что билет привязан к правильной станции
        }
    }
}
