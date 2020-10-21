// https://medium.com/swlh/understanding-java-8s-consumer-supplier-predicate-and-function-c1889b9423d
package unittests;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PredicatePracticeTests {
    Stream<String> stringStream;

    @Before
    public void setUp() {
        stringStream = Stream.of("William", "Steven", "Matthew");
    }

    @Test
    public void lambdaPredicateFiltersStreamAndReturnsOne() {
        Predicate<String> predicate = s -> s.startsWith("W");
        List<String> nameList = stringStream.filter(predicate).collect(Collectors.toList());
        int expected = 1;
        Assert.assertEquals(expected, nameList.size());
    }

    @Test
    public void overriddenPredicateFiltersStreamAndReturnsOne() {
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("W");
            }
        };
        List<String> nameList = stringStream.filter(predicate).collect(Collectors.toList());
        int expected = 1;
        Assert.assertEquals(expected, nameList.size());
    }

    @Test
    public void andPredicateFiltersStreamAndReturnsZero() {
        Predicate<String> firstLetterPredicate = s -> s.startsWith("W");
        Predicate<String> lastLetterPredicate = s -> s.endsWith("w");
        List<String> nameList = stringStream.filter(firstLetterPredicate.and(lastLetterPredicate)).collect(Collectors.toList());
        int expected = 0;
        Assert.assertEquals(expected, nameList.size());
    }

    @Test
    public void orPredicateFiltersStreamAndReturnsTwo() {
        Predicate<String> firstLetterPredicate = s -> s.startsWith("W");
        Predicate<String> lastLetterPredicate = s -> s.endsWith("n");
        List<String> nameList = stringStream.filter(firstLetterPredicate.or(lastLetterPredicate)).collect(Collectors.toList());
        int expected = 2;
        Assert.assertEquals(expected, nameList.size());
    }

    @Test
    public void negatePredicateFiltersStreamAndReturnsTwo() {
        Predicate<String> predicate = s -> s.startsWith("W");
        List<String> nameList = stringStream.filter(predicate.negate()).collect(Collectors.toList());
        int expected = 2;
        Assert.assertEquals(expected, nameList.size());
    }

    @Test
    public void testMethodFiltersStreamAndReturnsOne() {
        Predicate<String> predicate = s -> s.startsWith("W");
        List<String> nameList = new ArrayList<>();
        for (String s: stringStream.collect(Collectors.toList())) {
            if (predicate.test(s)) {
                nameList.add(s);
            }
        }
        int expected = 1;
        Assert.assertEquals(expected, nameList.size());
    }
}
