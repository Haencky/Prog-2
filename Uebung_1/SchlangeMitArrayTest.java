package Uebung_1;

import Uebung_0.A_2.SchlangeMitArray;
import org.junit.jupiter.api.*;

import java.util.NoSuchElementException;

public class SchlangeMitArrayTest {
    private static SchlangeMitArray speicher = null;

    @BeforeEach
    public void SetUp () {
        speicher = new SchlangeMitArray(5);
    }

    /**
     * Testet die Größe vor dem ersten Einfügen
     */
    @Test
    public void testSize () {
        Assertions.assertEquals(0,speicher.size());     //Prüft die size() Funktion
        Assertions.assertTrue(speicher.isEmpty());              //Prüft die isEmpty() Funktion
    }

    @Test
    public void testCapacity () {
        Assertions.assertEquals(5, speicher.capacity());
    }

    /**
     * Testet das Werfen der Exceptions wenn die Schlange leer ist
     */
    @Test
    public void testGetEmpty() {
        Assertions.assertThrows(NoSuchElementException.class, () -> speicher.remove()); //Prüft die remove() Funktion
        Assertions.assertThrows(NoSuchElementException.class, () -> speicher.front());  //Prüft die front() Funktion
    }

    /**
     * Testet das Einfügen von Elementen
     */
    @Test
    public void testInput () {
        speicher.insert(42);                                //Einfügen von "42"
        Assertions.assertEquals(1,speicher.size()); //size sollte jetzt 1 sein
        Assertions.assertFalse(speicher.isEmpty());         //isEmpty() sollte false zurückgeben
    }

    /**
     * Testet das Ausgeben von Werten im Speicher
     */
    @Test
    public void testGetNotEmpty () {
        speicher.insert(42);
        Assertions.assertEquals(42, speicher.front());  //Größe bleibt unverändert (Element bleibt)
        Assertions.assertEquals(42, speicher.remove()); //Größe wird verringert
        Assertions.assertEquals(0,speicher.size());     //Größe wird geprüft
        Assertions.assertTrue(speicher.isEmpty());              //isEmpty() wird getestet
    }

    /**
     * Testet, ob die Exception geworfen wird
     */
    @Test
    public void testToMuchInput () {
        for (int i = 0; i < speicher.capacity(); i++) {
            speicher.insert(i);
        }
        Assertions.assertEquals(5,speicher.size());
        Assertions.assertThrows(IllegalStateException.class, () -> speicher.insert(106));
    }

    @Test
    public void testRemove () {
        for (int i = 0; i < speicher.capacity(); i++) {
            speicher.insert(i);
        }

        for (int i = 0; i < speicher.capacity(); i++) {
            Assertions.assertEquals(i, speicher.remove());
        }
    }

}
