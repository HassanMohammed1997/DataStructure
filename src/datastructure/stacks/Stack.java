package datastructure.stacks;

import java.util.Arrays;

public class Stack {
    private final int[] items = new int[5];
    private int count = 0;

    public void push(int item) {
        items[count] = item;
        count++;
    }

    public int pop() {
        if (count == items.length)
            throw new IllegalStateException();

        return items[count--];
    }

    public int peek() {
        if (count == items.length)
            throw new IllegalStateException();

        return items[count - 1];
    }

    public boolean empty() {
        return count == 0;
    }

    @Override
    public String toString() {
        int[] contents = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(contents);
    }
}
