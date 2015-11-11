package question3.holder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


public enum ObjectMapperHolder {

    INSTANCE;

    private final ObjectMapper mapper;

    ObjectMapperHolder() {
        this.mapper = create();
    }

    public ObjectMapper get() {
        return this.mapper;
    }

    private static ObjectMapper create() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.findAndRegisterModules();
        return mapper;
    }

}