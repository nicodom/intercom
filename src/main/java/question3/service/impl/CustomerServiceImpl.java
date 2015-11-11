package question3.service.impl;

import question3.dao.CustomerDAO;
import question3.dao.impl.FileCustomerDAO;
import question3.model.Customer;
import question3.model.Location;
import question3.service.CustomerServiceAPI;
import question3.util.DistanceUnit;

import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;

public class CustomerServiceImpl implements CustomerServiceAPI {

    private final CustomerDAO customerDAO = new FileCustomerDAO();

    @Override
    public List<Customer> getCustomersNearLocation(Location location, Integer distance, DistanceUnit distanceUnit) {
        checkNotNull(location, "location cannot be null");
        checkNotNull(distance, "distance cannot be null");
        checkNotNull(distanceUnit, "distanceUnit cannot be null");

        List<Customer> allCustomers = customerDAO.list();
        return allCustomers
                .stream()
                .filter(customer -> customer.isInRangeFromLocation(location, distance, distanceUnit))
                .sorted()
                .collect(Collectors.toList());
    }
}
