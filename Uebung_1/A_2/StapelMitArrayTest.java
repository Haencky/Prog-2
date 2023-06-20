package Uebung_1.A_2;

import Uebung_0.A_2.StapelMitArray;
import Uebung_1.A_3.Funktion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

/**
 * @author Tim Schulz
 * @version 24.03.2023
 */
public class StapelMitArrayTest {
    private static StapelMitArray speicher = null;

    @BeforeEach
    public void setUp() {
        speicher = new StapelMitArray(5);
    }

    /**
     * Testet die initiale Größe
     */
    @Test
    public void testSizeEmpty() {
        Assertions.assertEquals(0,speicher.size());   //Größe sollte 0 sein
        Assertions.assertTrue(speicher.isEmpty());            //Speicher sollte leer sein
    }

    /**
     * Testet die Kapazität
     */
    @Test
    public void testCapacity() {
        Assertions.assertEquals(5,speicher.capacity());
    }

    /**
     * Prüft, ob die Exception geworfen wird
     */
    @Test
    public void testGetEmpty() {
       Assertions.assertThrows(NoSuchElementException.class, () -> speicher.remove());
        Assertions.assertThrows(NoSuchElementException.class, () -> speicher.top());
    }


    /**
     * Testet den ersten Input
     */
    @Test
    public void testInput1() {
        speicher.insert(2);   //Fügt "2" dem speicher hinzu
        Assertions.assertEquals(1,speicher.size());   //Prüft, ob die Größe eins ist
        Assertions.assertFalse(speicher.isEmpty());           //Prüft, ob speicher nicht leer ist
    }

    /**
     * Testet die "get-Funktionen" nach dem ersten einfügen
     */
    @Test
    public void testTop2 () {
        speicher.insert(2);
        Assertions.assertEquals(2, speicher.top());
        Assertions.assertEquals(2, speicher.remove());     //Oberster Wert wird geprüft
        Assertions.assertEquals(0, speicher.size());     //Prüft, ob größe 0 ist
        Assertions.assertTrue(speicher.isEmpty());                 //Prüft, ob speicher leer
    }

    /**
     * Testet, ob zu viele Elemente vorhanden sind
     */
    @Test
    public void testToMuchInput () {
        for (int i = 0; i < speicher.capacity(); i++) { //Füllen des Speichers
            speicher.insert(i);
        }
        Assertions.assertThrows(IllegalStateException.class, () -> speicher.insert(42));
    }

    /**
     * Testet, ob die Werte korrekt entnommen werden (LIFO)
     */
    @Test
    public void testRemove () {
        for (int i = 0; i < speicher.capacity(); i++) {
            speicher.insert(i);
        }

        for (int i = 4; i >= 0; i--) {
            Assertions.assertEquals(i, speicher.remove());
        }
    }

    /**
     * Testet die Methode applyToAll
     * Aufgabe 3
     */
    @Test
    public void testApllyToAll () {
        Funktion verdoppel = (x) -> x*=2;     //Verdoppelt
        Funktion quadrieren = x -> x*=x;    //Quadriert


        for (int i = 1; i < speicher.capacity()+1; i++) {
            speicher.insert(i);
        }

        //Testen des Verdoppelns
        speicher.applyToAll(verdoppel);
        for (int i = speicher.capacity(); i >= 1; i--) {
            Assertions.assertEquals(i*2, speicher.remove());
        }
        for (int i = 1; i < speicher.capacity()+1; i++) {
            speicher.insert(i);
        }

        //Testen des Quadrieren
        speicher.applyToAll(quadrieren);

        for (int i = speicher.capacity(); i >= 1; i--) {
            Assertions.assertEquals(i*i, speicher.remove());
        }
    }
}