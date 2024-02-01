package task;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringIterator implements Iterator<String> {

    private String[] arr;
    private int position = 0;

    StringIterator(String[] arr) throws RuntimeException {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("Array must be not empty and not null");
        }

        this.arr = arr;
    }

    public boolean hasNext() {
        return this.position <= this.arr.length - 1;
    }

    public String next() {
        try {
            return this.arr[position++];
        } catch (IndexOutOfBoundsException var3) {
            throw new NoSuchElementException();
        }
    }


}