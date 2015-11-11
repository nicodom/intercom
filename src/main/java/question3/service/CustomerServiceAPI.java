package question3.service;

import question3.model.Customer;
import question3.model.Location;
import question3.util.DistanceUnit;

import java.util.List;

public interface CustomerServiceAPI {

    List<Customer> getCustomersNearLocation(Location location, Integer distance, DistanceUnit distanceUnit);
}
