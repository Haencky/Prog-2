package Uebung_3.A_1;

import java.util.NoSuchElementException;

/**
 * @version 07.04.2023
 * @param <T>
 */
public class EVL <T> {
    private Listenelement first = null;     //Erstes Element der Liste
    private Listenelement last = null;      //Letztes Element der Liste
    private int size;                       //Größe der Liste

    /**
     * Listenelement der Liste
     */
    private class Listenelement {
        T data;     //Gespeichertes Datum des Listenelements
        Listenelement next = null;  //Verweis auf nächsten Eintrag
        Listenelement (T o) {
            data = o;
        }
    }


    /**
     * Fügt ein neues Element hinten zur Liste hinzu
     * @param o Datum, welches hinzugefügt wird
     */
    public void append(T o) {
        Listenelement l = new Listenelement(o);     //Erzeugt ein neues Listenelement mit der Übergebenen Data
        if (size == 0) {                            //Falls die Liste leer ist, ist das neue Element das erste
            first = l;
        } else if (size == 1) {
            last = l;
            first.next = last;
        } else {
            last.next = l;                          //Setzt "l" ans Ende der Liste
            last = last.next;                       //l wird jetzt auch als letztes Element gespeichert
        }
        size++;                                     //size wird um eins erhöht, da ein Element hinzugefügt wurde
    }

    /**
     * Gibt die verkettete Liste als String zurück
     * @return {[Listenelemente]}
     */
    public String toString() {
        return toString("{", first) + "}";
    }

    /**
     * Private Methode um Rekursives auslesen umzusetzen
     * @param s aktueller String
     * @param l aktuelles Listenelement
     * @return Liste als String, mit rekursiver Implementierung
     */
    private String toString(String s, Listenelement l) {
        if (l != null) {
            if (l != first)
                s += " - ";
            s += l.data.toString();
            return toString(s, l.next);
        }
        return s;
    }

    /**
     * Gibt das erste Element an
     * @return erstes Element
     */
    public T getFirst() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("Liste ist leer");
        }
        return first.data;
    }

    /**
     * Gibt das letzte Element zurück
     * @return letztes Element
     */
    public T getLast() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("Liste ist leer");
        }
        return last.data;
    }


    /**
     * Gibt das letzte Element zurück, und entfernt es aus der Liste
     * @return letztes Element
     */
    public T removeLast() throws NoSuchElementException{
        if (size == 0)
            throw new NoSuchElementException("Liste ist leer");
        Listenelement ret = last;
        Listenelement tmp = first;
        while (tmp.next != last) {
            tmp = tmp.next;
        }
        last = tmp;
        last.next = null;
        size--;
        return ret.data;
    }

    /**
     * Gibt die Größe der Liste an (Anzahl der Objekte)
     * @return Listengröße
     */
    public int size() {
        return size;
    }


    /**
     * Überprüft, ob ein Element gespeichert ist
     * @param e zu findendes Element
     * @return true, falls gespeichert - false sonst
     */
    public boolean contains (T e) {
        Listenelement tmp = first;
        while (tmp != null) {
            if(tmp.data.equals(e))
                return true;
            tmp = tmp.next;
        }
        return false;
    }

    public T removeFirst() {
        T ret = first.data;
        first = first.next;
        size--;
        return ret;
    }

    public void zip(EVL<T> other) {
        if (other.size == 0) {
            return;
        }
        if (this.size == 0) {
            this.first = other.first;
            this.last = other.last;
        }
        Listenelement thisAktuell = this.first;
        Listenelement otherAktuell = other.first;

        while (thisAktuell != null && otherAktuell != null) {
            //@TODO zip Vervollständigen (A4)
        }
    }
}
