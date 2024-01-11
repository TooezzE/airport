import com.gridnine.testing.filters.FlightFilter;
import com.gridnine.testing.filters.impl.LongTimeWaitingFilter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class LongTimeWaitingFilterTest {

    @Test
    void filterTest(){
        LocalDateTime currTime = LocalDateTime.now();

        Flight defaultFlight = new Flight(
                Arrays.asList(
                        new Segment(currTime, currTime.plusHours(2)),
                        new Segment(currTime.plusHours(3), currTime.plusHours(7)))
        );

        Flight longTimeWaitingFlight = new Flight(
                Arrays.asList(
                    new Segment(currTime, currTime.plusHours(2)),
                    new Segment(currTime.plusHours(6), currTime.plusHours(7)))
        );

        List<Flight> flights = Arrays.asList(longTimeWaitingFlight, defaultFlight);

        FlightFilter filter = new LongTimeWaitingFilter();
        List<Flight> actual = filter.filter(flights);
        List<Flight> expected = List.of(longTimeWaitingFlight);

        Assertions.assertEquals(expected, actual);
    }
}
