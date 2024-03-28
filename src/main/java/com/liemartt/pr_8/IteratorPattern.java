package com.liemartt.pr_8;

import java.util.Iterator;
import java.util.NoSuchElementException;

class MyIterator<T> implements Iterator<T> {
    private final T[] items;
    private int index = 0;

    public MyIterator(T[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return index < items.length;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return items[index++];
    }
}

public class IteratorPattern {
    public static void main(String[] args) {
        System.out.println("Testing Iterator:");
        Integer[] numbers = {1, 2, 3, 4, 5};
        MyIterator<Integer> iterator = new MyIterator<>(numbers);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
