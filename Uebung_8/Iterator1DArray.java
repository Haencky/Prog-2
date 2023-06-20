package Uebung_8;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Iterator1DArray<T> implements Iterator<T> {

    private int i;
    private T[] arr;
    private int grenze;

    /**
     * Konstruktor für ganz vorne bis ganz hinten
     * @param a Array über das iteriert wird
     */
    public Iterator1DArray(T[] a) {
        arr = a;
        i = 0;
        grenze = arr.length;
    }

    public Iterator1DArray(T[] a, int begin) {
        arr = a;
        i = begin;
        grenze = arr.length;
    }

    public Iterator1DArray(T[] a, int begin, int end) {
        arr = a;
        i = begin;
        grenze = end;
    }
    @Override
    public boolean hasNext() {
        return i < grenze;
    }

    @Override
    public T next() {
        if (!hasNext())
            throw new NoSuchElementException("Element ist nicht vorhanden");
        return arr[i++];
    }
}
