package Uebung_0.A_2;

import java.util.NoSuchElementException;

/**
 * @author Tim Schulz
 * @version 24.03.2023
 * Implementiert die Schnittstelle Schlange
 */
public class SchlangeMitArray implements Schlange {

    int[] arr;
    private int size = 0;
    private int maxInsert;    //Max insert

    public SchlangeMitArray(int maxGroesse) {
        maxInsert = maxGroesse;
        arr = new int[maxGroesse];
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

    /**
     * Fügt dem Speicher ein neues Element hinzu
     * @param i Übergebener Wert
     * @throws IllegalStateException Falls der Speicher voll ist
     */
    @Override
    public void insert(int i) throws IllegalStateException {
        if (size == arr.length) {
            throw new IllegalStateException("Speicher voll");       //Wirft Exception, falls Speicher voll
        }


        arr[--maxInsert] = i;    //Verringert die Position des Einfügens ("stellt sich hinten an")
                                //-- wegen IndexOutOfBoundException
        size++;                 //Inkrementiert die size, da Element eingefügt wurde
    }

    /**
     * Entfernt ein Element aus dem Speicher
     * @throws NoSuchElementException Falls der Speicher leer ist
     */
    @Override
    public int remove() throws NoSuchElementException {
        if (size == 0){
            throw new NoSuchElementException("Speicher leer");  //Wirft Exception, falls Speicher leer
        }
        int r = arr[capacity()-1];
        maxInsert++;
        shift();
        size--;
        return r;
    }

    /**
     * Liefert das erste Element, ohne es zu entfernen
     * @return Erste Element
     * @throws NoSuchElementException Falls der Speicher leer ist
     */
    @Override
    public int front() throws NoSuchElementException {
        if (size == 0){
            throw new NoSuchElementException("Speicher leer");  //Wirft Exception, falls Speicher leer
        }
        return arr[capacity()-1];
    }

    /**
     * Shiftet die Elemente im Array
     */
    private void shift() {
        for (int i = arr.length-1; i > 0; i--) {
            arr[i] = arr[i-1];
        }
    }
}
