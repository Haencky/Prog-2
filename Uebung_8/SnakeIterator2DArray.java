package Uebung_8;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iteriert über ein Array, geraden Zeilen vorwärts, ungerade rückwärts
 * @param <T>
 */
public class SnakeIterator2DArray <T> implements Iterator<T> {

    T[][] arr;  //Internes 2D Array
    private int spalte; //aktuelle Spalte
    private int zeile;  //aktuelle Zeile

    /**
     * Konstruktor
     * @param a Zu iterierendes Array
     */
    public SnakeIterator2DArray(T[][] a) {
        arr = a;
        spalte = 0;
        zeile = 0;
    }

    /**
     * Aussage, ob es ein nächstes Element gibt
     * @return aktuelle Zeile = letzte Zeile?
     */
    @Override
    public boolean hasNext() {
        return zeile < arr.length;
    }

    /**
     * Gibt das aktuelle Element zurück, und verändert die Position wie vorgegeben
     * @return aktuelles Element
     */
    @Override
    public T next() {
        T ret;  //Element das zurückgegeben wird
        //Sollte es kein nächstes Element geben wird eine Exception geworfen
        if (!hasNext())
            throw new NoSuchElementException("Nix da");
        //Sollte es eine gerade Zeile sein wird vorwärts iteriert
        if (zeile % 2 == 0) {
            ret = arr[zeile][spalte++];
            //sollte das Maximum erreicht sein wird die nächste Zeile genommen
            if (spalte == arr[0].length)
                zeile++;
        //Sollte es eine gerade Zeile sein wird rückwärts iteriert
        } else {
            //--spalte um bei 0 anzukommen
            //da vorher immer eine gerade Zeile kommen muss ist der
            // Spaltenwert schon maximal, und es wird von da aus dekrementiert
            ret = arr[zeile][--spalte];
            //sollte das Ende erreicht sein wird die Zeile verändert
            if (spalte == 0)
                zeile++;
        }
        return ret;
    }
}
