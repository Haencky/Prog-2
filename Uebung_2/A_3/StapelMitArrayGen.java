package Uebung_2.A_3;

import java.util.NoSuchElementException;

/**
 * @author Tim Schulz
 * @version 28.03.2023
 * Implementiert die Schnittstelle Stapel
 */
public class StapelMitArrayGen<T> implements Stapel <T> {
    T[] arr;      //Array als Speicher
    int size = 0;   //Aktuelle Größe des Arrays

    @SuppressWarnings("unchecked")
    public StapelMitArrayGen(int maxGroesse) {
        arr = (T[]) new Object[maxGroesse];
    }

    /**
     * Prüft, ob der Speicher leer ist
     * @return true falls leer, false falls nicht leer
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Gibt die Anzahl belegten Plätze des Speichers an
     * @return belegte Plätze im Speicher
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Gibt die maximale Größe des Speichers an
     * @return Maximale Größe des Speichers
     */
    @Override
    public int capacity() {
        return arr.length;
    }

    @Override
    public void insert(T i) throws IllegalStateException {
        if (size == arr.length) {
            throw new IllegalStateException("Speicher voll");
        } else {
            arr[size++] = i;
        }
    }

    /**
     * Entfernt ein Element aus dem Speicher
     * @throws NoSuchElementException Falls der Speicher leer ist
     */
    @Override
    public T remove() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("Speicher leer");  //Falls kein Element vorhanden ist
        } else {
            T ret = arr[size-1];
            size--;
            return ret;
        }
    }

    /**
     * Liefert das oberste Element ohne es zu entfernern
     * @return Oberste Element
     * @throws NoSuchElementException Falls der Speicher leer ist
     */
    @Override
    public T top() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("Speicher leer");
        } else {
            return arr[size-1];       //Verringert size nicht, da das Element nicht entfernt werden soll
        }
    }
    /*
    public void applyToAll (Funktion f) {
        int index = 0;      //Index für das Array
        for (int i : arr) {
            arr[index++] = f.auswerten(i);
        }
    }*/
}
