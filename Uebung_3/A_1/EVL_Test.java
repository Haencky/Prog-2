package Uebung_3.A_1;

import org.junit.jupiter.api.*;

import java.util.NoSuchElementException;

public class EVL_Test {
    static EVL<String> s;
    static EVL<Integer> i;
    static String[] strings = {"Fischer", "Fritz", "fischt", "frische", "Fische"};  //Strings zum Testen
    static Integer[] ints = {54, 74, 90, 14};   //Ints zum Testen

    @BeforeAll
    public static void setUP() {
        s = new EVL<>();
        i = new EVL<>();
    }

    /**
     * Testet die String-EVL
     */
    @Test
    public void testString() {
        Assertions.assertFalse(s.contains("Test"));     //Liste ist leer, deshalb sollte "Test" nicht vorhanden sein
        Assertions.assertEquals(0, s.size());   //Liste leer, deshalb sollte die size == 0 sein
        Assertions.assertEquals("{}", s.toString());
        Assertions.assertThrows(NoSuchElementException.class, () -> s.getFirst());  //Liste leer, deshalb Exception
        Assertions.assertThrows(NoSuchElementException.class, () -> s.getLast());
        Assertions.assertThrows(NoSuchElementException.class, () -> s.removeLast());

       for (String str : strings) {     //Füllen der Liste mit Elementen
           s.append(str);
       }

        Assertions.assertEquals(5, s.size());   //5 Elemente wurden hinzugefügt, deshalb size == 5
        Assertions.assertEquals("Fischer", s.getFirst());   //erstes Element
        Assertions.assertEquals("Fische", s.getLast());     //letztes Element
        Assertions.assertEquals("{Fischer - Fritz - fischt - frische - Fische}", s.toString()); //Stringausgabe
        for (String str : strings) {
            Assertions.assertTrue(s.contains(str)); //Kontrolliert jeweils, ob Element eingefügt wurde
        }

        Assertions.assertEquals("Fische", s.removeLast());  //removeLast wird getestet
        Assertions.assertEquals(4, s.size());   //size == 4, weil 1 entfernt wurde
        Assertions.assertFalse(s.contains("Fische"));   //Sollte nicht mehr da sein, da entfernt mit removeLast

        s.append("Forellen");
        Assertions.assertEquals(5, s.size());   //size == 5, da neues Element
        Assertions.assertTrue(s.contains("Forellen"));  //"Forellen" wurde hinzugefügt
        Assertions.assertEquals("{Fischer - Fritz - fischt - frische - Forellen}", s.toString());   //neuer String

    }

    /**
     * Testet die Integer-EVL
     */
    @Test
    public void testInteger () {
        Assertions.assertFalse(i.contains(69));     //Liste ist leer, deshalb sollte 69 nicht vorhanden sein
        Assertions.assertEquals(0, s.size());   //Liste leer, deshalb sollte die size == 0 sein
        Assertions.assertEquals("{}", s.toString());
        Assertions.assertThrows(NoSuchElementException.class, () -> s.getFirst());  //Liste leer, deshalb Exception
        Assertions.assertThrows(NoSuchElementException.class, () -> s.getLast());
        Assertions.assertThrows(NoSuchElementException.class, () -> s.removeLast());

        for (Integer intiger : ints) {     //Füllen der Liste mit Elementen
            i.append(intiger);
        }

        Assertions.assertEquals(4, i.size());   //4 Elemente wurden hinzugefügt, deshalb size == 4
        Assertions.assertEquals(54, i.getFirst());  //erstes Element
        Assertions.assertEquals(14, i.getLast());   //letztes Element
        Assertions.assertEquals("{54 - 74 - 90 - 14}", i.toString());   //Stringausgabe
        for (Integer in : ints) {
            Assertions.assertTrue(i.contains(in));  //kontrolliert jeweils, ob Element eingefügt wurde
        }

        Assertions.assertEquals(14, i.removeLast());    //testet removeLast
        Assertions.assertEquals(3, i.size());           //Größe sollte 3 sein, wegen removeLast
        Assertions.assertFalse(i.contains(14)); //14 sollte wegen removeLast fehlen

        i.append(42);
        Assertions.assertEquals(4, i.size());   //size == 4 wegen neuem Element (42)
        Assertions.assertTrue(i.contains(42));  //kontrolle, ob 42, hinzugefügt wurde
        Assertions.assertEquals("{54 - 74 - 90 - 42}", i.toString());   //neuer String
    }
}
