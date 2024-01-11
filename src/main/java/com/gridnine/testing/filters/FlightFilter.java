package com.gridnine.testing.filters;

import com.gridnine.testing.model.Flight;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightFilter {
    LocalDateTime currTime = LocalDateTime.now();
    int waitingTime = 2;

    List<Flight> filter(List<Flight> flights);
}
