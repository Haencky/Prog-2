package Uebung_2.A_4;

import Uebung_2.A_3.StapelMitArrayGen;
import org.junit.jupiter.api.*;

import java.util.NoSuchElementException;

/**
 * @author Tim Schulz
 * @version 28.03.2023
 * Testen der generischen Klasse Stapel
 */
public class StapelGenerischTest {
    static StapelMitArrayGen<String> s = null;
    static StapelMitArrayGen<Integer> i = null;

    @BeforeAll
    public static void setUp () {
        s = new StapelMitArrayGen<>(5);
        i = new StapelMitArrayGen<>(5);
    }

    /**
     * Testet den Integer Buffer
     */
    @Test
    public void testInteger() {
        Assertions.assertEquals(0,i.size());    //Größe sollte 0 sein
        Assertions.assertTrue(i.isEmpty());             //isEmpty sollte true sein
        Assertions.assertEquals(5, i.capacity());   //Capacity sollte 5 sein
        Assertions.assertThrows(NoSuchElementException.class, () -> i.remove());    //beides mal Exception, da leer
        Assertions.assertThrows(NoSuchElementException.class, () -> i.top());

        i.insert(42);    //Einfügen eines Wertes

        Assertions.assertFalse(i.isEmpty());    //Sollte fasle sein
        Assertions.assertEquals(1, i.size());   //sollte 1 sein
        Assertions.assertEquals(5, i.capacity());   //sollte nach wie vor 5 sein

        Assertions.assertEquals(42, i.top());   //eingefügtes Element
        Assertions.assertEquals(42, i.remove());    //Ebenfalls das eingefügte Element
        Assertions.assertThrows(NoSuchElementException.class, () -> i.remove());    //Exception, weil leer

        i.insert(1);
        i.insert(2);
        i.insert(3);    //Einfügen von 5 Elementen
        i.insert(4);
        i.insert(5);

        Assertions.assertThrows(IllegalStateException.class, () -> i.insert(420));  //Exception, weil voll
        Assertions.assertEquals(5, i.remove());
        Assertions.assertEquals(4, i.remove());
        Assertions.assertEquals(3, i.remove()); //LIFO-Ausgabe, weil Stapel
        Assertions.assertEquals(2, i.remove());
        Assertions.assertEquals(1, i.remove());

        Assertions.assertEquals(0, i.size());   //Größe sollte 0 sein
        Assertions.assertTrue(i.isEmpty());             //Stapel sollte leer sein
    }

    @Test
    public void testString () {
        Assertions.assertEquals(0,s.size());    //Größe sollte 0 sein
        Assertions.assertTrue(s.isEmpty());             //true, weil leer
        Assertions.assertEquals(5,s.capacity());
        Assertions.assertThrows(NoSuchElementException.class, () -> s.top());
        Assertions.assertThrows(NoSuchElementException.class, () -> s.remove());

        s.insert("Test");

        Assertions.assertFalse(s.isEmpty());
        Assertions.assertEquals(1, s.size());
        Assertions.assertEquals(5, s.capacity());

        Assertions.assertEquals("Test", s.top());
        Assertions.assertEquals("Test", s.remove());
        Assertions.assertThrows(NoSuchElementException.class, () -> s.remove());

        s.insert("Up");
        s.insert("You");
        s.insert("Give");
        s.insert("Gonna");
        s.insert("Never");

        Assertions.assertThrows(IllegalStateException.class, () -> s.insert("!"));

        Assertions.assertEquals("Never", s.remove());
        Assertions.assertEquals("Gonna", s.remove());
        Assertions.assertEquals("Give", s.remove());
        Assertions.assertEquals("You", s.remove());
        Assertions.assertEquals("Up", s.remove());

        Assertions.assertTrue(s.isEmpty());
        Assertions.assertEquals(0, s.size());
    }
}
