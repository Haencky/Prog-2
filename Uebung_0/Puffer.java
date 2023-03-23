package Uebung_0;

/**
 * @author Tim Schulz
 * @version 23.03.2023
 * Beschreibt einen Speicher generell
 */
public interface Puffer {

    /**
     * Prüft, ob der Speicher leer ist
     * @return true falls leer, false falls nicht leer
     */
    public boolean isEmpty();

    /**
     * Gibt die Anzahl belegten Plätze des Speichers an
     * @return belegte Plätze im Speicher
     */
    public int size();

    /**
     * Gibt die maximale Größe des Speichers an
     * @return Maximale Größe des Speichers
     */
    public int capacity();

    /**
     * Fügt dem Speicher ein neues Element hinzu
     * @param i Übergebenes Element
     */
    public void insert (int i) throws java.lang.IllegalStateException;


}
