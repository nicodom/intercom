package question3.model;

import org.junit.Test;

public class LocationTest {

    @Test(expected = IllegalArgumentException.class)
    public void testUnsuccessfulCreation() {
        new Location(91, 181);
    }
}
