package Uebung_5;

import Uebung_2.A_3.Puffer;

public interface Folge <T> extends Puffer<T>{
    /**
     * Gibt das Element an der gewünschten Stelle zurück
     * @param pos Gewünschte Stelle
     * @return Element an Stelle pos
     */
    public T get(int pos) throws IndexOutOfBoundsException;

    /**
     * Setzt den Wert an gewünschter Position neu
     * @param pos Gewünschte Position
     * @param e   Element das eingefügt wird
     * @return Altes Element
     */
    public T set(int pos, T e) throws IndexOutOfBoundsException;

    /**
     * Entfernt das Element an gewünschter Stelle, alle folgenden Elemente rutschen nach
     * @param pos Entfernende Position
     * @return Element an gewünschter Stelle
     */
    public T remove(int pos) throws IndexOutOfBoundsException;

    /**
     * Fügt ein Element an letzter Stelle ein
     * @param e Übergebener Wert
     */
    public void insert(T e);

    /**
     * Entfernt das erste Element
     * @return Erstes Element
     */
    public T remove();

    /**
     * Fügt ein Element an gewünschter Stelle ein, andere Elemente werden dementsprechend bewegt
     * @param pos Position, an der eingefügt werden soll
     * @param e   Element das eingefügt wird
     */
    public void insert(int pos, T e) throws IndexOutOfBoundsException;

    /**
     * Fügt eine Folge hinten an die Folge an
     * @param f Folge zum Hinzufügen
     */
    public void append(Folge<T> f);

    /**
     * Gibt das Feld zurück
     * @return internes Speichermedium
     */
    public T[] getSpeicher();

}