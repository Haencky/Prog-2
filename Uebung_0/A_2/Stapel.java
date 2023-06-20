package Uebung_0.A_2;

import java.util.NoSuchElementException;

/**
 * @author Tim Schulz
 * @version 24.03.2023
 * Erweitert die Schnittstelle Puffer
 */
public interface Stapel extends Puffer {

    /**
     * Liefert das oberste Element ohne es zu entfernern
     * @return Oberste Element
     * @throws NoSuchElementException Falls der Speicher leer ist
     */
    public int top() throws NoSuchElementException;
}
