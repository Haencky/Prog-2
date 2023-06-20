package Uebung_3.A_5;

public class RDVL <T>{

    private int size;   //Anzahl der eingefügten Elemente
    private int capacity;
    private Ringelement entry = null; //Einfügepunkt

    /**
     * Konstruktor für Ringpuffer
     * @param cap Kapazität des
     */
    public RDVL(int cap) {
        capacity = cap;
    }
    /**
     * Listenelement
     */
    private class Ringelement {
        T data; //gespeichertes Datum
        Ringelement next = null;    //Verweis auf nächstes Element
        Ringelement prev = null;    //Verweis auf nächstes Element

        Ringelement (T o) {     //Konstruktor für Element mit
            data = o;
        }
    }

    /**
     * Gibt die Anzahl der belegten Plätze an
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * Gibt einen Wahrheitswert an, ob der Ring leer ist
     * @return 1, falls leer - 0, sonst
     */
    public boolean isEmpty() {
        return entry == null;
    }

    /**
     * Fügt ein neues Element in den Ringpuffer hinzu
     * @param e Element, welches eingefügt wird
     */
    public void add(T e) {
        Ringelement tmp = new Ringelement(e);
        if (isEmpty()) {
            entry = tmp;
        } else if (size == 1) {
            entry.prev = entry.next = tmp;
            tmp.prev = tmp.next = entry;
        } else if (size < capacity) {
            entry.prev = tmp;
            tmp.next = entry;
        } else {
            entry.prev.data = e;
        }
    }
}
