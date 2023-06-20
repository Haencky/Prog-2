package Uebung_4;
import org.junit.jupiter.api.*;

import java.util.NoSuchElementException;

public class DynArrayTest {
    static DynArray<Integer> i = new DynArray<>();
    static DynArray<String> s = new DynArray<>();
    static Integer[] ints = {1,2,3,4,5,6};
    static String[] strings = {"Hello", "there", "!", "General", "Kenobi", "!"};

    @Test
    public void testInts() {
        Assertions.assertEquals(0, i.size());
        Assertions.assertEquals(1, i.capacity());
        Assertions. assertThrows(NoSuchElementException.class, () -> i.removeFirst());
        Assertions.assertThrows(NoSuchElementException.class, () -> i.removeLast());

        for (Integer a : ints)
            i.addLast(a);

        Assertions.assertEquals(ints.length, i.size());
        //Capacity berechnet sich mit kleinster zweierpotenz (bei 6 -> 8)
        Assertions.assertEquals(8, i.capacity());

        //Überprüfen, ob get(int pos) funktioniert
        for (int j = 0; j < i.size(); j++)
            Assertions.assertEquals(ints[j], i.get(j));

        //Überprüfen, ob removeFirst() funktioniert
        for (int j = 0; j < ints.length; j++)
            Assertions.assertEquals(ints[j], i.removeFirst());

        Assertions.assertEquals(0, i.size());
        Assertions.assertEquals(1, i.capacity());

        for (Integer in : ints)
            i.addFirst(in);

        for (int j = 0; j < i.size(); j++)
            Assertions.assertEquals(ints[ints.length-1-j], i.get(j));

        //Verdoppeln der Werte
        for (int j = 0; j < i.size(); j++) {
            i.set(j, i.get(j)*2);
            Assertions.assertEquals(ints[ints.length-1-j]*2, i.get(j));
        }

        for (Integer in : ints)
            Assertions.assertEquals(in*2, i.removeLast());
    }

    @Test
    public void testString() {
        Assertions.assertEquals(0, s.size());
        Assertions.assertEquals(1, s.capacity());
        Assertions. assertThrows(NoSuchElementException.class, () -> s.removeFirst());
        Assertions.assertThrows(NoSuchElementException.class, () -> s.removeLast());

        for (String a : strings)
            s.addLast(a);

        Assertions.assertEquals(strings.length, s.size());
        //Capacity berechnet sich mit kleinster zweierpotenz (bei 6 -> 8)
        Assertions.assertEquals(8, s.capacity());

        //Überprüfen, ob get(int pos) funktioniert
        for (int j = 0; j < s.size(); j++)
            Assertions.assertEquals(strings[j], s.get(j));

        //Überprüfen, ob removeFirst() funktioniert
        for (int j = 0; j < strings.length; j++)
            Assertions.assertEquals(strings[j], s.removeFirst());

        Assertions.assertEquals(0, s.size());
        Assertions.assertEquals(1, s.capacity());

        for (String in : strings)
            s.addFirst(in);

        for (int j = 0; j < s.size(); j++)
            Assertions.assertEquals(strings[strings.length-1-j], s.get(j));

        //Verdoppeln der Werte
        for (int j = 0; j < i.size(); j++) {
            s.set(j, s.get(j)+"-");
            Assertions.assertEquals(strings[strings.length-1-j]+"-", s.get(j));
        }
        for (String in : strings)
            Assertions.assertEquals(in, s.removeLast());
    }
}
