import com.gridnine.testing.filters.FlightFilter;
import com.gridnine.testing.filters.impl.PastFlightsFilter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class PastFlightsFilterTest {
    @Test
    void filter(){
        LocalDateTime currTime = LocalDateTime.now();

        Flight alreadyDeparturedFlight = new Flight(
                Arrays.asList(
                    new Segment(currTime.minusDays(2), currTime.minusDays(1)),
                    new Segment(currTime.minusHours(7), currTime.plusHours(1)))
        );

        Flight notDeparturedFlight = new Flight(
                Arrays.asList(
                    new Segment(currTime.plusHours(1), currTime.plusHours(5)),
                    new Segment(currTime.plusHours(7), currTime.plusHours(10)))
        );

        List<Flight> flights = Arrays.asList(alreadyDeparturedFlight, notDeparturedFlight);


        FlightFilter filter = new PastFlightsFilter();
        List<Flight> actual = filter.filter(flights);
        List<Flight> expected = List.of(alreadyDeparturedFlight);

        Assertions.assertEquals(expected, actual);
    }
}
