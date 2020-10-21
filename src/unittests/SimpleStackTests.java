package unittests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import datastructure.SimpleStack;
import exceptions.StackIsEmptyException;

public class SimpleStackTests {
    SimpleStack stack;

    @Before
    public void setUp() {
        stack = new SimpleStack();
    }

    @Test
    public void peekThrowsExceptionIfTopIsEmpty() {
        Assert.assertThrows(StackIsEmptyException.class, () -> stack.peek());
    }

    @Test
    public void pushAssignsValueToTop() throws StackIsEmptyException {
        Object expected = 1;
        stack.push(1);
        Assert.assertEquals(expected, stack.peek());
    }

    @Test
    public void peekReturnsTopIfTopIsNotEmpty() throws StackIsEmptyException {
        Object expected = 1;
        stack.push(expected);
        Assert.assertEquals(expected, stack.peek());
    }

    @Test
    public void pushAssignsValuesToTopAndBottomIfTopIsNotEmpty() {
        boolean expected = false;
        stack.push(1);
        stack.push(2);
        Assert.assertEquals(expected, stack.isEmpty());
    }

    @Test
    public void topReceivesNewValueIfTopIsNotEmpty() throws StackIsEmptyException {
        Object expected = 2;
        stack.push(1);
        stack.push(2);
        Assert.assertEquals(expected, stack.peek());
    }

    @Test
    public void isEmptyReturnsTrueIfStackIsEmpty() {
        boolean expected = true;
        Assert.assertEquals(expected, stack.isEmpty());
    }

    @Test
    public void isEmptyReturnsFalseIfStackIsNotEmpty() {
        boolean expected = false;
        stack.push(1);
        Assert.assertEquals(expected, stack.isEmpty());
    }

    @Test
    public void popReturnsTopAndSetsTopToNullIfBottomIsEmpty() throws StackIsEmptyException {
        Object expected = 1;
        stack.push(1);
        Object result = stack.pop();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void popReturnsTopAndAssignsValueToTopIfBottomIsNotEmpty() throws StackIsEmptyException {
        Object expected = 1;
        stack.push(1);
        stack.push(2);
        stack.pop();
        Object result = stack.pop();
        Assert.assertEquals(expected, result);
    }
}