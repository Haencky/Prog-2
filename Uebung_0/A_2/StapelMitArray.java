package Uebung_0.A_2;

import Uebung_1.A_3.Funktion;
import java.util.NoSuchElementException;

/**
 * @author Tim Schulz
 * @version 24.03.2023
 * Implementiert die Schnittstelle Stapel
 */
public class StapelMitArray implements Stapel {
    int[] arr;      //Array als Speicher
    int size = 0;   //Aktuelle Größe des Arrays

    public StapelMitArray(int maxGroesse) {
        arr = new int[maxGroesse];
    }

    /**
     * Prüft, ob der Speicher leer ist
     * @return true falls leer, false falls nicht leer
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Gibt die Anzahl belegten Plätze des Speichers an
     * @return belegte Plätze im Speicher
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Gibt die maximale Größe des Speichers an
     * @return Maximale Größe des Speichers
     */
    @Override
    public int capacity() {
        return arr.length;
    }

    /**
     * Fügt dem Speicher ein neues Element hinzu
     * @param i Übergebener Wert
     * @throws IllegalStateException Falls der Speicher voll ist
     */
    @Override
    public void insert(int i) throws IllegalStateException {
        if (size == arr.length) {           //Überprüft, ob die maximale Größe schon erreicht ist
            throw new  IllegalStateException ("Speicher voll");
        } else {
            arr[size++] = i;                //Fügt ein neues Element hinzu (size++ zum "oben auflegen")
        }
    }

    /**
     * Entfernt ein Element aus dem Speicher
     * @throws NoSuchElementException Falls der Speicher leer ist
     */
    @Override
    public int remove() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("Speicher leer");  //Falls kein Element vorhanden ist
        } else {
            int ret = arr[--size];
            //size--;
            return ret;
        }
    }

    /**
     * Liefert das oberste Element ohne es zu entfernern
     * @return Oberste Element
     * @throws NoSuchElementException Falls der Speicher leer ist
     */
    @Override
    public int top() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("Speicher leer");
        } else {
            return arr[size-1];       //Verringert size nicht, da das Element nicht entfernt werden soll
        }
    }

    public void applyToAll (Funktion f) {
        int index = 0;      //Index für das Array
        for (int i : arr) {
            arr[index++] = f.auswerten(i);
        }
    }
}
