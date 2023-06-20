package Uebung_5;

import Uebung_4.DynArray;

import java.util.NoSuchElementException;

public class FolgeMitDynArray <T> implements Folge <T> {
    private int size;
    private int capacity;
    private T[] arr;

    @SuppressWarnings("unchecked")
    public FolgeMitDynArray() {
        size = -1;
        capacity = 1;
        arr = (T[]) new Object[capacity];
    }

    /**
     * Gibt das Feld zurück
     * @return arr
     */
    public T[] getSpeicher() {
        return arr;
    }

    /**
     * Prüft, ob der Speicher leer ist
     * @return true falls leer, false falls nicht leer
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Gibt die Anzahl an belegten Plätzen an
     * @return size
     */
    public int size() {
        return size+1;
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
        for (int i = 0; i < size(); i++) {
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
        for (int i = 0; i < size(); i++) {
            arrNew[i] = arr[i];
        }
        //Umlegen der Referenz, sodass arr jetzt das neue Array ist
        arr = arrNew;
    }

    /**
     * Verschiebt alle Elemente von pos ausgehend nach oben, fügt e ein
     * @param pos Position, an der eingefügt wird
     * @param e Element, das eingefügt wird
     */
    @SuppressWarnings("unchecked")
    private void shiftUp(int pos, T e) {
        if (size() == capacity)
            capacity *=2;
        //neues Array bis pos
        T[]tmp = (T[]) new Object[capacity];
        //arr ebenfalls erhöhen
        increase();
        //System.out.println("Capacity-neu: " + capacity);
        //Kopieren der Werte bis pos
        for (int i = 0; i < pos; i++) {
            tmp[i] = arr[i];
        }
        tmp[pos] = e;
        size++;
        for (int i = pos+1; i < size(); i++) {
            tmp[i] = arr[i-1];
        }
        arr = tmp;
    }

    /**
     * Entfernt das Element an pos, und verschiebt andere Elemente nach unten
     * @param pos Position, die entfernt wird
     */
    @SuppressWarnings("unchecked")
    private void shiftdown(int pos) {
        T[]tmp = (T[]) new Object[capacity];
        for (int i = 0; i < pos; i++) {
            tmp[i] = arr[i];
        }
        for (int i = pos+1; i < size(); i++) {
            tmp[i-1] = arr[i];
        }
        arr = tmp;
        size--;
        if ((size() * 4) == capacity)
            decrease();
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
     * @return Element an position pos
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
     * Entfernt das Element an gewünschter Stelle, alle folgenden Elemente rutschen nach
     *
     * @param pos Entfernende Position
     * @return Element an gewünschter Stelle
     */
    @Override
    public T remove(int pos) throws IndexOutOfBoundsException {
        if (pos > size)
            throw new IndexOutOfBoundsException("Feld ist kleiner als pos");
        T ret = arr[pos];
        shiftdown(pos);
        return ret;
    }

    /**
     * Fügt ein Element an letzter Stelle ein
     * @param e Übergebener Wert
     */
    @Override
    public void insert(T e) {
        addLast(e);
    }

    /**
     * Entfernt das erste Element
     * @return Erstes Element
     */
    @Override
    public T remove() throws NoSuchElementException {
        return removeFirst();
    }

    /**
     * Fügt ein Element an gewünschter Stelle ein, andere Elemente werden dementsprechend bewegt
     * @param pos Position, an der eingefügt werden soll
     * @param e   Element das eingefügt wird
     */
    @Override
    public void insert(int pos, T e) throws IndexOutOfBoundsException {
        if (pos > size)
            throw new IndexOutOfBoundsException("Feld ist kleiner als pos");
        shiftUp(pos, e);
    }

    /**
     * Fügt ein Element vorne hinzu
     * @param e Element das eingefügt wird
     */
    public void addFirst(T e) {
        insert(0, e);
    }

    /**
     * Fügt ein Element hinten am Array hinzu
     * @param e Element das eingefügt wird
     */
    public void addLast(T e) {
        //Falls das Array voll ist, wird die Größe verdoppelt
        if (size() == capacity)
            increase();
        //size wird erhöht, und das neue Element hinten eingefügt
        arr[++size] = e;
    }

    /**
     * Entfernt das letzte Element, und gibt es zurück
     * @return arr[size--]
     * @throws NoSuchElementException, falls Array leer ist
     */
    public T removeLast() throws NoSuchElementException {
        if (size() == 0)
            throw new NoSuchElementException("Array ist leer");
        //letztes Element aussuchen, und verringern der Größe
        T ret = arr[size--];
        //falls nur 1/4 belegt ist, wird die Größe halbiert
        if (capacity / 4 == size())
            decrease();
        return ret;
    }

    /**
     * Entfernt das erste Element und gibt es zurück
     * @return arr[0]
     * @throws NoSuchElementException, falls Array leer ist
     */
    public T removeFirst() throws NoSuchElementException {
        if (size() < 1)
            throw new NoSuchElementException("Array ist leer");
        return remove(0);
    }

    /**
     * Gibt das Array als String aus
     * @return Array als String
     */
    public String toString() {
        String s = "{";
        for (int i = 0; i < size(); i++) {
            s += arr[i];
            if (i < size()-1)
                s += " - ";
        }
        s += "}";
        return s;
    }

    /**
     * Fügt eine andere Folge hinten hinzu
     * @param f Folge zum Anfügen
     * @throws NoSuchElementException Falls f leer ist
     */
    @Override
    public void append(Folge<T> f) {
        T[] tmp = f.getSpeicher();
        for (int i = 0; i < f.size(); i++) {
            insert(tmp[i]);
        }
    }
}
