package Uebung_2.A_4;

import Uebung_2.A_3.SchlangeMitArrayGen;
import org.junit.jupiter.api.*;

import java.util.NoSuchElementException;

/**
 * @author Tim Schulz
 * @version 28.03.2023
 * Test der generischen Schlange
 */
public class SchlangeGenerischTest {
    static SchlangeMitArrayGen<Integer> i = null;
    static SchlangeMitArrayGen<String> s = null;

    /**
     * Legt die zu testenden Objekte an
     */
    @BeforeAll
    public static void setUp() {
        i = new SchlangeMitArrayGen<>(5);
        s = new SchlangeMitArrayGen<>(5);
    }

    /**
     * Testet den generischen Puffer mit dem konkreten Datentyp Integer
     */
    @Test
    public void testInteger () {
        Assertions.assertEquals(0, i.size());
        Assertions.assertTrue(i.isEmpty());
        Assertions.assertEquals(5, i.capacity());
        Assertions.assertThrows(NoSuchElementException.class, () -> i.front());
        Assertions.assertThrows(NoSuchElementException.class, () -> i.remove());

        i.insert(42);   //Einfügen eines Elements

        Assertions.assertEquals(1, i.size());
        Assertions.assertFalse(i.isEmpty());
        Assertions.assertEquals(5, i.capacity());

        Assertions.assertEquals(42, i.front());
        Assertions.assertEquals(42, i.remove());
        Assertions.assertThrows(NoSuchElementException.class, () -> i.remove());

        i.insert(1);
        i.insert(2);
        i.insert(3);
        i.insert(4);
        i.insert(5);

        Assertions.assertThrows(IllegalStateException.class, () -> i.insert(420));
        Assertions.assertEquals(5, i.size());

        Assertions.assertEquals(1, i.remove());
        Assertions.assertEquals(2, i.remove());
        Assertions.assertEquals(3, i.remove());
        Assertions.assertEquals(4, i.remove());
        Assertions.assertEquals(5, i.remove());
        Assertions.assertThrows(NoSuchElementException.class, () -> i.remove());

        Assertions.assertTrue(i.isEmpty());
        Assertions.assertEquals(0, i.size());
    }

    /**
     * Testet die String Implementation
     */
    @Test
    public void testString () {
        Assertions.assertEquals(0, s.size());
        Assertions.assertTrue(s.isEmpty());
        Assertions.assertEquals(5, s.capacity());
        Assertions.assertThrows(NoSuchElementException.class, () -> s.front());
        Assertions.assertThrows(NoSuchElementException.class, () -> s.remove());

        s.insert("Test");

        Assertions.assertFalse(s.isEmpty());
        Assertions.assertEquals(1, s.size());
        Assertions.assertEquals(5, s.capacity());

        Assertions.assertEquals("Test", s.front());
        Assertions.assertEquals("Test", s.remove());
        Assertions.assertThrows(NoSuchElementException.class, () -> s.remove());

        s.insert("Never");
        s.insert("Gonna");
        s.insert("Give");
        s.insert("You");
        s.insert("Up");

        Assertions.assertEquals(5, s.size());
        Assertions.assertThrows(IllegalStateException.class, () -> s.insert("!"));

        Assertions.assertEquals("Never", s.remove());
        Assertions.assertEquals("Gonna", s.remove());
        Assertions.assertEquals("Give", s.remove());
        Assertions.assertEquals("You", s.remove());
        Assertions.assertEquals("Up", s.remove());

        Assertions.assertThrows(NoSuchElementException.class, () -> s.remove());

        Assertions.assertEquals(0, s.size());
        Assertions.assertTrue(s.isEmpty());
    }
}
