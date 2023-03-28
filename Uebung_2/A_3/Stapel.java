package Uebung_2.A_3;

import java.util.NoSuchElementException;

/**
 * @author Tim Schulz
 * @version 28.03.2023
 * Erweitert die Schnittstelle Puffer
 */
public interface Stapel<T> extends Puffer<T> {

    /**
     * Liefert das oberste Element ohne es zu entfernern
     * @return Oberste Element
     * @throws NoSuchElementException Falls der Speicher leer ist
     */
    public T top() throws NoSuchElementException;
}
