package Uebung_4;

import java.util.NoSuchElementException;

public class Ringpuffer <T> {
    private int size;
    private int capacity;
    private int v, h = 0;
    private T[] arr;

    public Ringpuffer(int capacity) {
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public T get(int pos) throws NoSuchElementException {
        if(pos > size)
            throw new NoSuchElementException("Noch nicht belegt");
        return arr[pos];
    }

    public T set(int pos, T e) throws NoSuchElementException {
        if (pos > size)
            throw new NoSuchElementException("Noch nicht belegt");
        T ret = arr[pos];
        arr[pos] = e;
        return ret;
    }
    public void addFirst(T e) {

    }
    public void addLast(T e) {
        arr[h++%capacity] = e;
        size++;
    }

    public T removeFirst() {
        T ret = arr[v];
        v++;
        v %= capacity;
        size--;
        return ret;
    }
}
