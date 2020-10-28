package unittests;

import java.util.StringJoiner;

import org.junit.Assert;
import org.junit.Test;

public class StringBuilderAndJoinerPracticeTests {
    @Test
    public void initializedStringJoinerReturnsEmptyString() {
        String expected = "";
        StringJoiner joiner = new StringJoiner(",");
        Assert.assertEquals(expected, joiner.toString());
    }

    @Test
    public void stringJoinerWithPrefixAndSuffixReturnsNonEmptyString() {
        String expected = "()";
        StringJoiner joiner = new StringJoiner(",", "(", ")");
        Assert.assertEquals(expected, joiner.toString());
    }

    @Test
    public void stringJoinerWithDefaultReturnsDefault() {
        String expected = "Default";
        StringJoiner joiner = new StringJoiner(",", "(", ")");
        joiner.setEmptyValue("Default");
        Assert.assertEquals(expected, joiner.toString());
    }

    @Test
    public void mergeJoinsStringJoinersTogether() {
        String expected = "(One, Two, Three-Four)";
        StringJoiner firstJoiner = new StringJoiner(", ", "(", ")");
        firstJoiner.add("One").add("Two");
        StringJoiner secondJoiner = new StringJoiner("-", "[", "]");
        secondJoiner.add("Three").add("Four");
        Assert.assertEquals(expected, firstJoiner.merge(secondJoiner).toString());
    }

    @Test
    public void stringJoinerAddsStringBuilder() {
        String expected = "Joiner created. Builder added.";
        StringBuilder builder = new StringBuilder();
        builder.append("Builder added.");
        StringJoiner joiner = new StringJoiner(". ");
        joiner.add("Joiner created").add(builder.toString());
        Assert.assertEquals(expected, joiner.toString());
    }

    @Test
    public void stringBuilderAppendsStringJoinerSuccess() {
        String expected = "Array: [One, Two]";
        StringBuilder builder = new StringBuilder();
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        joiner.add("One").add("Two");
        builder.append("Array: ");
        Assert.assertEquals(expected, builder.append(joiner.toString()).toString());
    }
}
