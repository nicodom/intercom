package question3.dao;

import java.io.IOException;
import java.util.List;

public interface GenericDAO<T> {

    List<T> list();
}
