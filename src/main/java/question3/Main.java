package question3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import question3.model.Customer;
import question3.model.Location;
import question3.service.CustomerServiceAPI;
import question3.service.impl.CustomerServiceImpl;
import question3.util.DistanceUnit;

import java.util.List;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private final static Location INTERCOM_OFFICE_LOCATION = new Location(53.3381985, -6.2592576);
    private final static Integer DISTANCE = 100;
    private final static DistanceUnit DISTANCE_UNIT = DistanceUnit.KM;

    public static void main(String[] args) {

        try {
            CustomerServiceAPI customerService = new CustomerServiceImpl();
            List<Customer> customers = customerService.getCustomersNearLocation(INTERCOM_OFFICE_LOCATION, DISTANCE, DISTANCE_UNIT);
            customers.stream().forEach(System.out::println);
        } catch (Throwable t) {
            LOGGER.error("Error in main", t);
        }

    }
}
