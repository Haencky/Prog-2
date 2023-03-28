package Uebung_2.A_3;

import java.util.NoSuchElementException;

/**
 * @author Tim Schulz
 * @version 28.03.2023
 * Implementiert die Schnittstelle Schlange
 */
public class SchlangeMitArrayGen<T> implements Schlange <T> {

    T[] arr;
    int size = 0;
    public int maxInput;    //Max insert
    int maxRemove;
    int max;

    @SuppressWarnings("unchecked")
    public SchlangeMitArrayGen(int maxGroesse) {
        maxInput = maxGroesse;
        maxRemove = maxGroesse-1;
        max = maxGroesse;
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

    /**
     * Fügt dem Speicher ein neues Element hinzu
     * @param i Übergebener Wert
     * @throws IllegalStateException Falls der Speicher voll ist
     */
    @Override
    public void insert(T i) throws IllegalStateException {
        if (size == arr.length) {
            throw new IllegalStateException("Speicher voll");       //Wirft Exception, falls Speicher voll
        }
                     //Inkrementiert die size, da Element eingefügt wurde
        if (maxRemove == 0 || size == 0) {
            maxInput = max;
            maxRemove = max-1;
        }
        ++size;
        arr[--maxInput] = i;     //Verringert die Position des Einfügens ("stellt sich hinten an")
                            //-- wegen IndexOutOfBoundException
    }

    /**
     * Entfernt ein Element aus dem Speicher
     * @throws NoSuchElementException Falls der Speicher leer ist
     */
    @Override
    public T remove() throws NoSuchElementException {
        if (size == 0){
            throw new NoSuchElementException("Speicher leer");  //Wirft Exception, falls Speicher leer
        }
        size--;         //Verringert size, da Element entfernt wurde
        return arr[maxRemove--];
    }

    /**
     * Liefert das erste Element, ohne es zu entfernen
     * @return Erste Element
     * @throws NoSuchElementException Falls der Speicher leer ist
     */
    @Override
    public T front() throws NoSuchElementException {
        if (size == 0){
            throw new NoSuchElementException("Speicher leer");  //Wirft Exception, falls Speicher leer
        }
        return arr[maxRemove];
    }
}
