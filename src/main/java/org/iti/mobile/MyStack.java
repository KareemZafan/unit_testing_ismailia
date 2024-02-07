package org.iti.mobile;

import java.util.ArrayList;
import java.util.List;

public class MyStack {

    private final int STACK_LIMIT = 10;
    private List<String> myStackList;

    public MyStack() {
        myStackList = new ArrayList<>();
    }

    public void push(String item) {
        if (isFull()) throw new ArrayIndexOutOfBoundsException("Stack Overflow!");
        myStackList.add(item);
    }

    public String pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is Empty!");
        String poppedItem = getPeek();
        myStackList.remove(getStackSize() - 1);
        return poppedItem;
    }


    public boolean isFull() {
        return myStackList.size() == STACK_LIMIT;
    }

    public boolean isEmpty() {
        return myStackList.isEmpty();
    }

    public int getStackSize() {
        return myStackList.size();
    }

    public String getPeek() {
        if (isEmpty()) return null;
        return myStackList.get(getStackSize() - 1);
    }


    public List<String> getCurrentStack() {
        return myStackList;
    }

    public int getStackLimit() {
        return STACK_LIMIT;
    }

}
