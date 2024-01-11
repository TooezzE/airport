import com.gridnine.testing.filters.FlightFilter;
import com.gridnine.testing.filters.impl.ArrivalBeforeDepartureFilter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

class ArrivalBeforeDepartureFilterTest {
    @Test
    void filterTest() {
        LocalDateTime currTime = LocalDateTime.now();

        Flight defaultFlight = new Flight(
                Arrays.asList(
                        new Segment(currTime, currTime.plusHours(4)),
                        new Segment(currTime.plusHours(5), currTime.plusHours(9)))
        );

        Flight arrivalBeforeDepartureFlight = new Flight(
                Arrays.asList(
                    new Segment(currTime, currTime.minusHours(4)),
                    new Segment(currTime.plusHours(8), currTime.minusHours(9)))
        );

        List<Flight> flights = Arrays.asList(arrivalBeforeDepartureFlight, defaultFlight);

        FlightFilter filter = new ArrivalBeforeDepartureFilter();
        List<Flight> expected = List.of(arrivalBeforeDepartureFlight);
        List<Flight> actual = filter.filter(flights);

        Assertions.assertEquals(expected, actual);
    }
}
