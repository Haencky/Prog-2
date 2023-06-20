package Uebung_3.A_2;

import Uebung_2.A_3.Schlange;
import Uebung_3.A_1.EVL;

import java.util.NoSuchElementException;

public class SchlangeMitEVL <T> implements Schlange <T> {

    private EVL<T> evl; //Liste als für Queue implementierung zum Speichern der Daten

    public SchlangeMitEVL() {
        evl = new EVL<>();
    }

    /**
     * Prüft, ob der Speicher leer ist
     * @return true falls leer, false falls nicht leer
     */
    @Override
    public boolean isEmpty() {
        return evl.size() == 0; //Methode der EVL
    }

    /**
     * Gibt die Anzahl belegten Plätze des Speichers an
     * @return belegte Plätze im Speicher
     */
    @Override
    public int size() {
        return evl.size();  //nimmt von der EVL die Methode
    }

    /**
     * Gibt die maximale Größe des Speichers an (unbegrenzt)
     * @return Maximale Größe des Speichers
     */
    @Override
    public int capacity() {
        return Integer.MAX_VALUE;
    }

    /**
     * Fügt dem Speicher ein neues Element hinzu
     * @param i Übergebener Wert
     */
    @Override
    public void insert(T i) {   //wirft KEINE Exception, da die Speicherkapazität unbegrenzt ist
        evl.append(i);  //Bei einer Queue wird immer hinten angefügt
    }

    /**
     * Entfernt ein Element aus dem Speicher
     * @throws NoSuchElementException Falls der Speicher leer ist
     */
    @Override
    public T remove() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Liste ist leer");
        }
        return evl.removeFirst();
    }

    /**
     * Liefert das erste Element, ohne es zu entfernen
     * @return Erste Element
     * @throws NoSuchElementException Falls der Speicher leer ist
     */
    @Override
    public T front() throws NoSuchElementException {
        if (evl.size() == 0) {
            throw new NoSuchElementException("Speicher ist leer");
        }
        return evl.getFirst();
    }

    public String toString() {
        return evl.toString();
    }
}
