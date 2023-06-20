package Uebung_0.A_2;

import java.util.NoSuchElementException;

/**
 * @author Tim Schulz
 * @version 24.03.2023
 * Erweitert die Schnittstelle Puffer
 */
public interface Schlange extends Puffer {

    /**
     * Liefert das erste Element, ohne es zu entfernen
     * @return Erste Element
     * @throws NoSuchElementException Falls der Speicher leer ist
     */
    public int front() throws NoSuchElementException;
}
