package com.gridnine.testing.filters.impl;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.filters.FlightFilter;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class LongTimeWaitingFilter implements FlightFilter {
    @Override
    public List<Flight> filter(List<Flight> flightList) {
        return flightList
                .stream()
                .filter(f -> f.getSegments().size() > 1)
                .filter(f -> isLongerThenWaitingTime(f.getSegments()))
                .collect(Collectors.toList());
    }

    private static boolean isLongerThenWaitingTime(List<Segment> segments) {
        long totalTime = 0;
        for (int i = 1; i < segments.size(); i++) {
            totalTime += Duration.between(segments.get(i - 1).getArrivalDate(),
                    segments.get(i).getDepartureDate()).toHours();
        }
        return totalTime > waitingTime;
    }
}
