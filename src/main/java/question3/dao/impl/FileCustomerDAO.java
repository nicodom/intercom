package question3.dao.impl;

import com.diffplug.common.base.Errors;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import question3.dao.CustomerDAO;
import question3.holder.ObjectMapperHolder;
import question3.model.Customer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class FileCustomerDAO implements CustomerDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileCustomerDAO.class);

    //improvement this can be moved to an external configuration file
    private final static String CUSTOMERS_FILE_NAME = "customers.json";

    @Override
    public List<Customer> list() {

        try (Stream<String> stream = Files.lines(Paths.get(Resources.getResource(CUSTOMERS_FILE_NAME).toURI()))) {
            return stream
                    .map(Errors.rethrow().wrap(this::getCustomerFromJSON))
                    .collect(toList());
        } catch (IOException | URISyntaxException e) {
            String errorMessage = String.format("Error in reading file %s", CUSTOMERS_FILE_NAME);
            LOGGER.error(errorMessage, e);
            //this is a blocking error, that's why we need an unchecked exception
            throw new RuntimeException(errorMessage, e);
        }
    }

    private Customer getCustomerFromJSON(String jsonLine) throws IOException {
        ObjectMapper mapper = ObjectMapperHolder.INSTANCE.get();
        return mapper.readValue(jsonLine, Customer.class);
    }
}
