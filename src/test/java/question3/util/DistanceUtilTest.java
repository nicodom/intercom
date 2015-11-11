package question3.util;

import org.junit.Test;
import static org.junit.Assert.*;
import question3.model.Location;

public class DistanceUtilTest {

    private final static Location INTERCOM_OFFICE_LOCATION = new Location(53.3381985, -6.2592576);
    private final static Location MY_ROME_OFFICE_LOCATION = new Location(41.925780, 12.482828);

    @Test
    public void testNullDistance() {
        for (DistanceUnit distanceUnit : DistanceUnit.values()) {
            double distance = DistanceUtil.distanceBetweenPoints(INTERCOM_OFFICE_LOCATION.getLatitude(), INTERCOM_OFFICE_LOCATION.getLongitude(),
                    INTERCOM_OFFICE_LOCATION.getLatitude(), INTERCOM_OFFICE_LOCATION.getLongitude(), distanceUnit);

            assertEquals(distance, 0.0, 0.0);
        }
    }

    @Test
    public void testDublinRomeDistance() {
        double distanceInKm = DistanceUtil.distanceBetweenPoints(INTERCOM_OFFICE_LOCATION.getLatitude(), INTERCOM_OFFICE_LOCATION.getLongitude(),
                MY_ROME_OFFICE_LOCATION.getLatitude(), MY_ROME_OFFICE_LOCATION.getLongitude(), DistanceUnit.KM);

        assertEquals(distanceInKm, 1882.290939226745, 0.0);
    }

    @Test(expected = NullPointerException.class)
    public void testNullArgument() {
        DistanceUtil.distanceBetweenPoints(INTERCOM_OFFICE_LOCATION.getLatitude(), INTERCOM_OFFICE_LOCATION.getLongitude(),
                MY_ROME_OFFICE_LOCATION.getLatitude(), MY_ROME_OFFICE_LOCATION.getLongitude(), null);
    }

}
