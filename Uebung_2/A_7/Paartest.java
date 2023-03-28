package Uebung_2.A_7;

import Uebung_2.A_6.Paar;
import org.junit.jupiter.api.*;

/**
 * @author Tim Schulz
 * @version 28.03.2023
 * Unittest für Paar-Klasse
 */
public class Paartest {
    static Paar<Integer, String> e;
    static Paar<Integer, String> z;
    @BeforeAll
    public static void setUp() {
        e = new Paar<>(5, "Prog_2");
        z = new Paar<>(42, "Antwort");
    }

    @Test
    public void testSetAndGetErstes() {
        Assertions.assertEquals(5, e.setErstes(106)); //Erwarte 5
        Assertions.assertEquals(106, e.getErstes());    //Jetzt 106, weil vorher gesetzt

        Assertions.assertEquals(42, z.setErstes(7));   //Erwartet 42
        Assertions.assertEquals(7, z.getErstes());     //Jetzt 12, weil gesetzt
    }

    @Test
    public void testSetAndGetZweites() {
        Assertions.assertEquals("Prog_2", e.setZweites("."));
        Assertions.assertEquals(".", e.getZweites());

        Assertions.assertEquals("Antwort", z.setZweites("Ringe den Zwergen"));
        Assertions.assertEquals("Ringe den Zwergen", z.getZweites());
    }

    @Test
    public void testSetBeides() {
        e.setBeides(5, "Prog_2");
        Assertions.assertEquals(5, e.getErstes());
        Assertions.assertEquals("Prog_2", e.getZweites());

        z.setBeides(42, "Antwort");
        Assertions.assertEquals(42, z.getErstes());
        Assertions.assertEquals("Antwort", z.getZweites());
    }

    @Test
    public void testToString() {
        Assertions.assertEquals("5, Prog_2", e.toString());
        Assertions.assertEquals("42, Antwort", z.toString());
    }

    @Test
    public void testEquals() {
        Assertions.assertFalse(e.equals(z));
        Assertions.assertTrue(e.equals(new Paar<>(5, "Prog_2")));
    }
}
