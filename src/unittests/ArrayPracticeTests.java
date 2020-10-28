package unittests;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

public class ArrayPracticeTests {
    @Test
    public void asListTakesAVarargsParameter() {
        int expected = 5;
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Assert.assertEquals(expected, list.size());
    }

    @Test
    public void addToArrayCreatedListThrowsUnsupportedOperationException() {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Assert.assertThrows(UnsupportedOperationException.class, () -> list.add(1));
    }

    @Test
    public void removeFromArrayCreatedListThrowsUnsupportedOperationException() {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Assert.assertThrows(UnsupportedOperationException.class, () -> list.remove(1));
    }

    @Test
    public void streamMethodCreatesStreamFromArraySubset() {
        int expected = 8;
        Integer[] array = new Integer[] {1,2,3,4,5,6,7,8,9,10};
        Stream<Integer> stream = Arrays.stream(array, 0, 8);
        List<Integer> list = stream.collect(Collectors.toList());
        Assert.assertEquals(expected, list.size());
    }

    @Test
    public void sortMethodSortsArraySubset() {
        Integer[] expected = new Integer[] {2,3,4,5,1};
        Integer[] array = new Integer[] {5,4,3,2,1};
        Arrays.sort(array, 0, 4);
        Assert.assertArrayEquals(expected, array);
    }

    @Test
    public void binarySearchMethodFindsElementInSortedArraySubset() {
        int expected = 0;
        Integer[] array = new Integer[] {1,2,3,4,5,6,7,8,9,10};
        int result = Arrays.binarySearch(array, 0, 6, 1);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void fillMethodFillsEveryElementInArray() {
        Integer[] expected = new Integer[] {1,1,1,1,1};
        Integer[] result = new Integer[5];
        Arrays.fill(result, 1);
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void fillMethodFillsSubSetOfElementsInArray() {
        Integer[] expected = new Integer[] {1,1,1,1,2};
        Integer[] result = new Integer[5];
        Arrays.fill(result, 0, 4, 1);
        result[4] = 2;
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void copyOfMethodCreatesSubsetCopyOfArray() {
        Integer[] expected = new Integer[] {1,2,3};
        Integer[] array = new Integer[] {1,2,3,4,5};
        Integer[] result = Arrays.copyOf(array, 3);
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void copyOfMethodCreatesExtraElementsFromArray() {
        int[] expected = new int[] {1,2,3,0,0};
        int[] array = new int[] {1,2,3};
        int[] result = Arrays.copyOf(array, 5);
        Assert.assertArrayEquals(expected, result);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void copyOfMethodThrowsNegativeArraySizeExceptionIfNegativeLengthIsPassedIn() {
        Integer[] array = new Integer[] {1,2,3};
        Integer[] error = Arrays.copyOf(array, -3);
    }

    @Test
    public void setAllMethodCreatesArrayUsingIndex() {
        Integer[] expected = new Integer[] {1,2,3,4,5};
        Integer[] result = new Integer[5];
        Arrays.setAll(result, p -> p + 1);
        Assert.assertArrayEquals(expected, result);
    }
}
