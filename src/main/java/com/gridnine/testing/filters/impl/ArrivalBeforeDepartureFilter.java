package com.gridnine.testing.filters.impl;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.filters.FlightFilter;

import java.util.List;
import java.util.stream.Collectors;

public class ArrivalBeforeDepartureFilter implements FlightFilter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(f -> f.getSegments()
                        .stream()
                        .anyMatch(s -> s.getDepartureDate().isAfter(s.getArrivalDate())))
                .collect(Collectors.toList());
    }
}
