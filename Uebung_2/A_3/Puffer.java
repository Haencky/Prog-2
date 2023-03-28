package Uebung_2.A_3;

/**
 * @author Tim Schulz
 * @version 28.03.2023
 * Beschreibt einen Speicher generisch
 */
public interface Puffer <T>{

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
     * @param i Übergebener Wert
     * @throws IllegalStateException Falls der Speicher voll ist
     */
    public void insert (T i) throws IllegalStateException;

    /**
     * Entfernt ein Element aus dem Speicher
     * @throws java.util.NoSuchElementException Falls der Speicher leer ist
     */
    public T remove() throws java.util.NoSuchElementException;

}
