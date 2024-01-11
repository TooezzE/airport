package com.gridnine.testing;


import com.gridnine.testing.builder.FlightBuilder;
import com.gridnine.testing.filters.impl.ArrivalBeforeDepartureFilter;
import com.gridnine.testing.filters.impl.LongTimeWaitingFilter;
import com.gridnine.testing.filters.impl.PastFlightsFilter;
import com.gridnine.testing.model.Flight;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String delimiter = "----------------";
        List<Flight> allFlights = FlightBuilder.createFlights();

        System.out.println("All flights:");
        System.out.println(allFlights);
        System.out.println(delimiter);

        System.out.println("Already finished flights:");
        System.out.println(new PastFlightsFilter().filter(allFlights));
        System.out.println(delimiter);

        System.out.println("Flights which arrival before departure:");
        System.out.println(new ArrivalBeforeDepartureFilter().filter(allFlights));
        System.out.println(delimiter);

        System.out.println("Long time waiting flights:");
        System.out.println(new LongTimeWaitingFilter().filter(allFlights));
    }
}