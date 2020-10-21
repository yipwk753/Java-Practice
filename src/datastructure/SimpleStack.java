package datastructure;

import exceptions.StackIsEmptyException;

public class SimpleStack {
    // no array, just two elements
    private Object top = null;
    private Object bottom = null;

	public boolean isEmpty() {
		return top == null && bottom == null ? true: false;
	}

	public void push(Object object) {
        if (top != null) {
            bottom = top;
        }
        top = object;
	}

	public Object peek() throws StackIsEmptyException {
		if (top == null) {
            throw new StackIsEmptyException("Peek: Stack is empty.");
        }
        return top;
	}

	public Object pop() throws StackIsEmptyException {
		if (top == null) {
            throw new StackIsEmptyException("Pop: Stack is empty.");
        }
        Object temp = top;
        if (bottom != null) {
            top = bottom;
        }
        else {
            top = null;
        }
        return temp;
	}
}
