package Uebung_3.A_2;

import org.junit.jupiter.api.*;

import java.util.NoSuchElementException;

public class SchlangeMitEVLTest {

    static SchlangeMitEVL<Integer> i;
    static SchlangeMitEVL<String> s;
    static Integer[] ints = {3, 7, 9, 1};
    static String[] strings = {"Elben", "Zwerge", "Menschen", "Dunkler Herrscher"};

    @BeforeAll
    static void setUp() {
        i = new SchlangeMitEVL<>();
        s = new SchlangeMitEVL<>();
    }

    @Test
    void testInteger() {
        Assertions.assertEquals(0, i.size());   //size == 0, weil leer
        Assertions.assertEquals(Integer.MAX_VALUE, i.capacity());   //Capacity sollte "unbegrenzt" sein
        Assertions.assertTrue(i.isEmpty()); //Speicher leer, deshalb true
        Assertions.assertThrows(NoSuchElementException.class, () -> i.remove());    //Leer, deshalb kann man nicht entnehmen
        Assertions.assertThrows(NoSuchElementException.class, () -> i.front());

        for (Integer in : ints) {   //Einfügen von Elementen
            i.insert(in);
        }

        Assertions.assertFalse(i.isEmpty());    //Sollte nicht leer sein
        Assertions.assertEquals(ints.length, i.size()); //Size == Anzahl eingefügter Elemente

        for (int j = 0; j < ints.length; j++) {    //Überprüfen der Ausgabefunktionen
            Assertions.assertEquals(ints[j], i.front());
            Assertions.assertEquals(ints[j], i.remove());

        }

        Assertions.assertEquals(0, i.size());   //Sollte jetzt leer sein
        Assertions.assertTrue(i.isEmpty());
    }

    @Test
    void testString() {
        Assertions.assertEquals(0, s.size());   //size == 0, weil leer
        Assertions.assertEquals(Integer.MAX_VALUE, s.capacity());   //Capacity sollte "unbegrenzt" sein
        Assertions.assertTrue(i.isEmpty()); //Speicher leer, deshalb true
        Assertions.assertThrows(NoSuchElementException.class, () -> s.remove());    //Leer, deshalb kann man nicht entnehmen
        Assertions.assertThrows(NoSuchElementException.class, () -> s.front());

        for (String str : strings) {   //Einfügen von Elementen
            s.insert(str);
        }

        Assertions.assertFalse(s.isEmpty());    //Sollte nicht leer sein
        Assertions.assertEquals(strings.length, s.size()); //Size == Anzahl eingefügter Elemente

        for (int j = 0; j < strings.length; j++) {    //Überprüfen der Ausgabefunktionen
            Assertions.assertEquals(strings[j], s.front());
            Assertions.assertEquals(strings[j], s.remove());

        }

        Assertions.assertEquals(0, s.size());   //Sollte jetzt leer sein
        Assertions.assertTrue(s.isEmpty());
    }
}
