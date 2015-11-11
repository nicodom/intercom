package question2.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class FlattenUtilTest {
    private static final Object[] INTEGER_NESTED_ARRAY = new Object[] {new Object[] {1, 2, new Integer[]{3}}, 4};
    private static final Integer[] FLAT_INTEGER_ARRAY = new Integer[] {1, 2, 3, 4};
    private static final Object[] ILLEGAL_WITH_NULL_ARRAY = new Object[] {new Object[] {1, null, new Integer[]{3}}, 4};
    private static final Object[] ILLEGAL_ELEMENT_ARRAY = new Object[] {new Object[] {1, "foo", new Integer[]{3}}, 4};

    private static final int ARRAY_X_DIMENSION = 10;
    private static final int ARRAY_Y_DIMENSION = 500;
    private static final int ARRAY_Z_DIMENSION = 1000;

    @Test
    public void testFlatten() {
        List<Integer> flatIntegerList = FlattenUtil.flatten(INTEGER_NESTED_ARRAY);
        assertArrayEquals(flatIntegerList.toArray(), FLAT_INTEGER_ARRAY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullElement() {
        FlattenUtil.flatten(ILLEGAL_WITH_NULL_ARRAY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullInput() {
        FlattenUtil.flatten(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInput() {
        FlattenUtil.flatten(ILLEGAL_ELEMENT_ARRAY);
    }

    @Test
    public void testBig3DArray() {

        List<Integer> flatList = new ArrayList<>();
        Integer[][][] inputNotFlatArray = new Integer[ARRAY_X_DIMENSION][ARRAY_Y_DIMENSION][ARRAY_Z_DIMENSION];

        int contentCounter = 0;
        for(int x = 0 ; x < inputNotFlatArray.length ; x++) {
            for (int y = 0 ; y < inputNotFlatArray[x].length ; y++) {
                for (int z = 0; z <inputNotFlatArray[x][y].length; z++) {
                    inputNotFlatArray[x][y][z] = contentCounter++;
                }
            }
        }

        IntStream.range(0, ARRAY_X_DIMENSION * ARRAY_Y_DIMENSION * ARRAY_Z_DIMENSION).forEach(flatList::add);

        List<Integer> resultFlatList = FlattenUtil.flatten(inputNotFlatArray);

        assertThat(resultFlatList, is(flatList));
    }

}
