package Uebung_4;

import java.util.NoSuchElementException;

public class DynArray <T> {
    private int size;
    private int capacity;
    private T[] arr;

    @SuppressWarnings("unchecked")
    public DynArray() {
        size = 0;
        capacity = 1;
        arr = (T[]) new Object[capacity];
    }

    /**
     * Gibt die Anzahl an belegten Plätzen an
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * Verdoppelt die Größe des Arrays und kopiert die Werte
     */
    @SuppressWarnings("unchecked")
    private void increase() {
        //verdoppelt die capacity
        capacity *= 2;
        //Anlegen eines neuen Arrays
        T[] newArr = (T[]) new Object[capacity];
        //kopieren der Werte, nur bis size, da mehr nicht belegt ist
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        //umlegen der Referenz, sodass arr jetzt das neue Array ist
        arr = newArr;
    }

    /**
     * Halbiert die Größe des Arrays und kopiert die Werte
     */
    @SuppressWarnings("unchecked")
    private void decrease() {
        //halbiert die capacity
        capacity /= 2;
        //anlegen eines neuen Arrays
        T[] arrNew = (T[]) new Object[capacity];
        //kopieren der Werte, nur bis size, da mehr nicht belegt ist
        for (int i = 0; i < size; i++) {
            arrNew[i] = arr[i];
        }
        //Umlegen der Referenz, sodass arr jetzt das neue Array ist
        arr = arrNew;
    }

    /**
     * Dreht das Array um
     * @return gespiegeltes Array
     */
    @SuppressWarnings("unchecked")
    private T[] reverse() {
        //neues Array anlegen
        T[] tmp = (T[]) new Object[capacity];
        //Werte spiegeln
        for (int i = 0; i < size; i++) {
           tmp[size - 1 - i] = arr[i];
        }
        //Gespiegeltes Array zurückgeben
        return tmp;
    }

    /**
     * Gibt die Größe des Arrays an
     * @return capacity = arr.length
     */
    public int capacity() {
        return capacity;
    }

    /**
     * Gibt das Element an der gewünschten Stelle zurück
     * @throws NoSuchElementException, falls pos > size
     * @param pos Position, die zurückgegeben werden soll
     * @return
     */
    public T get(int pos) throws NoSuchElementException {
        if (pos > size)
            throw new NoSuchElementException("Platz ist noch unbelegt");
        return arr[pos];
    }

    /**
     * Überschreibt den Wert an pos, und gibt den alten Wert zurück
     * @throws NoSuchElementException, falls pos > size
     * @param pos Position, die überschrieben & zurückgegeben wird
     * @param e Element mit dem überschrieben wird
     * @return (altes) arr[pos]
     */
    public T set(int pos, T e) throws NoSuchElementException {
        if (pos > size)
            throw new NoSuchElementException("Platz ist noch nicht belegt");
        T ret = arr[pos];
        arr[pos] = e;
        return ret;
    }

    /**
     * Fügt ein Element vorne hinzu
     * @param e Element das eingefügt wird
     */
    public void addFirst(T e) {
        //spiegeln des Arrays
        arr = reverse();
        //hinten anfügen des Elements
        addLast(e);
        //zurück spiegeln
        arr = reverse();
    }

    /**
     * Fügt ein Element hinten am Array hinzu
     * @param e Element das eingefügt wird
     */
    public void addLast(T e) {
        //Falls das Array voll ist, wird die Größe verdoppelt
        if (size == capacity)
            increase();
        //size wird erhöht, und das neue Element hinten eingefügt
        arr[size++] = e;
    }

    /**
     * Entfernt das letzte Element, und gibt es zurück
     * @return arr[size--]
     * @throws NoSuchElementException, falls Array leer ist
     */
    public T removeLast() throws NoSuchElementException {
        if (size == 0)
            throw new NoSuchElementException("Array ist leer");
        //letztes Element aussuchen, und verringern der Größe
        T ret = arr[--size];
        //falls nur 1/4 belegt ist, wird die Größe halbiert
        if (capacity / 4 == size)
            decrease();
        return ret;
    }

    /**
     * Entfernt das erste Element und gibt es zurück
     * @return arr[0]
     * @throws NoSuchElementException, falls Array leer ist
     */
    public T removeFirst() throws NoSuchElementException {
        if (size == 0)
            throw new NoSuchElementException("Array ist leer");
        arr = reverse();
        T ret = removeLast();
        arr = reverse();
        return ret;
    }

    public String toString() {
        String s = "Dynamisches Array: {";
        for (int i = 0; i < size; i++) {
            s += arr[i];
            if (i < size-1)
                s += ", ";
        }
        s += "}";
        return s;
    }
}
