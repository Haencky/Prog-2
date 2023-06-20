package Uebung_2.A_3;

import java.util.NoSuchElementException;

/**
 * @author Tim Schulz
 * @version 28.03.2023
 * Erweitert die Schnittstelle Puffer
 */
public interface Schlange <T> extends Puffer <T> {

    /**
     * Liefert das erste Element, ohne es zu entfernen
     * @return Erste Element
     * @throws NoSuchElementException Falls der Speicher leer ist
     */
    public T front() throws NoSuchElementException;
}
