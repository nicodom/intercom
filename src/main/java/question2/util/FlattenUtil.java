package question2.util;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

/**
 * This class contains methods for flattening arrays.
 *
 * <p>The methods in this class throw a {@code IllegalArgumentException},
 * if the specified array element is either null or is not the right type
 * or is not an array itself.</p
 *
 * <p>This class is immutable and thread-safe.</p>
 *
 * @author Domenico Fioravanti
 */
public class FlattenUtil {

    /**
     *
     * @param objects array to flatten as list of integers
     * @return list of Integers
     */
    public static List<Integer> flatten(Object[] objects) {
        //checking null
        if(objects == null) throw new IllegalArgumentException("Element is null");

        return flattenAsStream(objects).collect(toList());
    }

    /**
     *
     * @param objects array to flatten as stream
     * @return stream of Integers
     */
    private static Stream<Integer> flattenAsStream(Object[] objects) {
        //checking null
        if(objects == null) throw new IllegalArgumentException("Element is null");

        return asList(objects)
                .stream()
                .flatMap(item -> {
                    if (item instanceof Integer) return Stream.of((Integer) item);
                    else if (item instanceof Object[]) return flattenAsStream((Object[]) item);
                    else throw new IllegalArgumentException("Element is not an Integer nor an Array");
                });
    }

}
