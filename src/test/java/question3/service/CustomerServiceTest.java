package question3.service;

import static org.junit.Assert.*;
import org.junit.Test;
import question3.model.Customer;
import question3.model.Location;
import question3.service.impl.CustomerServiceImpl;
import question3.util.DistanceUnit;

import java.util.List;

public class CustomerServiceTest {

    private final static Location INTERCOM_OFFICE_LOCATION = new Location(53.3381985, -6.2592576);
    private final static Integer DISTANCE = 100;
    private final static DistanceUnit DISTANCE_UNIT = DistanceUnit.KM;

    @Test
    public void testGetCustomersNearLocation() {
        CustomerServiceAPI customerService = new CustomerServiceImpl();

        List<Customer> customers = customerService.getCustomersNearLocation(INTERCOM_OFFICE_LOCATION, DISTANCE, DISTANCE_UNIT);
        assertEquals(customers.size(), 16);
    }

    @Test(expected = NullPointerException.class)
    public void testNullInput() {
        CustomerServiceAPI customerService = new CustomerServiceImpl();

        customerService.getCustomersNearLocation(null, null, null);
    }

}
