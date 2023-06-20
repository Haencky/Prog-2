package Uebung_5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class FolgeMitDynArrayTest {

    FolgeMitDynArray<Integer> i;
    FolgeMitDynArray<String>  s;
    static Integer[] ints = {1,3,9};
    static String[] strings = {"Alle", "Entchen", "schwimmen"};

    @BeforeEach
    void setUp() {
        i = new FolgeMitDynArray<>();
        s = new FolgeMitDynArray<>();
    }

    @AfterEach
    void tearDown() {
        i = null;
        s = null;
    }

    @Test
    void isEmpty() {
        //Noch kein Element enthalten, daher true
        Assertions.assertTrue(i.isEmpty());
        Assertions.assertTrue(s.isEmpty());
    }

    @Test
    void size() {
        //Noch leer, deshalb 0
        Assertions.assertEquals(0, i.size());
        Assertions.assertEquals(0, s.size());

        //hinzufügen von 1 Element
        i.insert(1);
        s.insert("Test");

        //size sollte jetzt 1 sein
        Assertions.assertEquals(1, i.size());
        Assertions.assertEquals(1, s.size());

        //isEmpty() sollte false sein
        Assertions.assertFalse(i.isEmpty());
        Assertions.assertFalse(s.isEmpty());
    }

    @Test
    void capacity() {
        //Bei Erstellung ist capacity = 1
        Assertions.assertEquals(1, i.capacity());
        Assertions.assertEquals(1, s.capacity());

        //Einfügen von 5-Elementen
        for (Integer j = 0; j < 5; j++) {
            i.insert(j);
            s.insert(j.toString());
        }
        //Auf 8 erhöht, da size größer als 2^2 ist -> 2^3=8
        Assertions.assertEquals(8, i.capacity());
        Assertions.assertEquals(8, s.capacity());

        //Entfernen von 4 Elementen (jetzt noch 1)
        i.remove();
        i.remove();
        i.remove();
        i.remove();

        s.remove();
        s.remove();
        s.remove();
        s.remove();

        //Capacity muss 2 sein, weil 1 1/4 von 4 ist
        /*
        C, S
        8, 5
        8, 4
        8, 3
        4, 2
        2, 1
         */
        Assertions.assertEquals(2, i.capacity());
        Assertions.assertEquals(2, s.capacity());
    }

    @Test
    void get() {
        //Komplett leer, deshalb geht get(0) nicht
        Assertions.assertThrows(NoSuchElementException.class, () -> i.get(0));
        Assertions.assertThrows(NoSuchElementException.class, () -> s.get(0));

        //Einfügen von Elementen
        i.insert(1);
        s.insert("Test");

        //Ein Element vorhanden, deshalb get(0)
        Assertions.assertEquals(1, i.get(0));
        Assertions.assertEquals("Test", s.get(0));

        //Nur ein Element vorhanden, deshalb get(1) Fehler
        Assertions.assertThrows(NoSuchElementException.class, () -> i.get(1));
        Assertions.assertThrows(NoSuchElementException.class, () -> s.get(1));
    }

    @Test
    void set() {
        //Komplett leer, weshalb nichts überschrieben werden kann
        Assertions.assertThrows(NoSuchElementException.class, () -> i.set(0, 1));
        Assertions.assertThrows(NoSuchElementException.class, () -> s.set(0, "Test"));

        //einfügen von Werten
        i.insert(1);
        s.insert("Hallo");

        //Überschreiben von Werten
        i.set(0, 420);
        s.set(0, "Tschüss");

        //Überprüfen, ob überschreiben erfolgreich
        Assertions.assertEquals(420, i.get(0));
        Assertions.assertEquals("Tschüss", s.get(0));
    }

    @Test
    void remove_ohne_pos() {
        //Ist komplett leer, deshalb Fehler
        Assertions.assertThrows(NoSuchElementException.class, () -> i.remove());
        Assertions.assertThrows(NoSuchElementException.class, () -> s.remove());

        //Hinzufpgen von Elementen
        for (int j = 0; j < ints.length; j++) {
            i.insert(ints[j]);
            s.insert(strings[j]);
        }

        //Überprüfen
        for (int j = 0; j < ints.length; j++) {
            Assertions.assertEquals(ints[j], i.remove());
            Assertions.assertEquals(strings[j], s.remove());
        }
    }

    @Test
    void insert_ohne_pos() {
        //Einfügen von Elementen
        for (int j = 0; j < ints.length; j++) {
            //Überprüfen, ob size() stimmt
            Assertions.assertEquals(j, i.size());
            Assertions.assertEquals(j, s.size());
            i.insert(ints[j]);
            s.insert(strings[j]);
        }

        //Überprüfen
        for (int j = 0; j < ints.length; j++) {
            Assertions.assertEquals(ints[j], i.get(j));
            Assertions.assertEquals(strings[j], s.get(j));
        }
    }

    @Test
    void Remove_mit_pos() {
        //Einfügen von Elementen
        for (int j = 0; j < ints.length; j++) {
            i.insert(ints[j]);
            s.insert(strings[j]);
        }

        //Überprüfen, ob remove(int pos) klappt
        Assertions.assertEquals(ints[1], i.remove(1));
        Assertions.assertEquals(strings[1], s.remove(1));

        //Überprüfen, ob size verringert wurde
        Assertions.assertEquals(ints.length-1, i.size());
        Assertions.assertEquals(strings.length-1, s.size());

        //Überprüfen, ob richtig geschoben wurde
        Assertions.assertEquals(ints[2], i.get(1));
        Assertions.assertEquals(strings[2], s.get(1));
    }

    @Test
    void Insert_mit_pos() {
        //Einfügen von Elementen
        for (int j = 0; j < ints.length; j++) {
            i.insert(ints[j]);
            s.insert(strings[j]);
        }

        //Mittendrin einfügen
        i.insert(2, 7); // -> 1,3,7,9
        s.insert(1, "meine"); // -> Alle meine Entchen schwimmen

        //Mit String ausgabe überprüfen, ob korrekt eingefügt
        Assertions.assertEquals("{1 - 3 - 7 - 9}", i.toString());
        Assertions.assertEquals("{Alle - meine - Entchen - schwimmen}", s.toString());
    }

    @Test
    void addFirst() {
        //Ein Element einfügen
        i.insert(5);
        s.insert("du!");

        //Eins vorne einfügen
        i.addFirst(4);
        s.addFirst("Hallo");

        //Überprüfen, ob erstes Element das eingefügte ist
        Assertions.assertEquals(4, i.get(0));
        Assertions.assertEquals("Hallo", s.get(0));
    }

    @Test
    void addLast() {
        //initiales Befüllen
        for (int j = 0; j < ints.length; j++) {
            i.addLast(ints[j]);
            s.addLast(strings[j]);
        }

        //Hinten anfügen von Elementen
        i.addLast(420);
        s.addLast("auf");

        //Überprüfen, ob letztes Element das eingefügte ist
        Assertions.assertEquals(420, i.removeLast());
        Assertions.assertEquals("auf", s.removeLast());
    }

    @Test
    void removeLast() {
        for (int j = 0; j < ints.length; j++) {
            i.addLast(ints[j]);
            s.addLast(strings[j]);
        }

        Assertions.assertEquals(ints[ints.length-1], i.removeLast());
        Assertions.assertEquals(strings[strings.length-1], s.removeLast());
    }

    @Test
    void removeFirst() {
        for (int j = 0; j < ints.length; j++) {
            i.addLast(ints[j]);
            s.addLast(strings[j]);
        }

        Assertions.assertEquals(ints[0], i.removeFirst());
        Assertions.assertEquals(strings[0], s.removeFirst());
    }
}