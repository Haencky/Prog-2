package Uebung_6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntSuchbaumTest {
    private static IntSuchbaum b;
    private static Integer[] ints = {3,2,5,4,1,7};
    @BeforeEach
    void setUp() {
        b = new IntSuchbaum();
    }


    @Test
    void isEmpty() {
        Assertions.assertTrue(b.isEmpty());
        b.insert(42);
        Assertions.assertFalse(b.isEmpty());
    }

    @Test
    void insert() {
        Assertions.assertTrue(b.isEmpty());
        b.insert(42);
        Assertions.assertFalse(b.isEmpty());
        Assertions.assertEquals(1, b.size());
        b.insert(55);
        Assertions.assertEquals(2, b.size());
    }

    @Test
    void contains() {
        Assertions.assertFalse(b.contains(42));
        b.insert(42);
        Assertions.assertTrue(b.contains(42));
    }

    @Test
    void testToString() {
        Assertions.assertEquals("", b.toString());
        for (Integer i : ints)
            b.insert(i);
        Assertions.assertEquals("(((1)2)3((4)5(7)))", b.toString());
    }

    @Test
    void size() {
        Assertions.assertEquals(0, b.size());
        b.insert(5);
        Assertions.assertEquals(1, b.size());
    }

    @Test
    void hoehe() {
        Assertions.assertEquals(0, b.hoehe());
        for (Integer i : ints)
            b.insert(i);
        Assertions.assertEquals(3, b.hoehe());
        b.insert(6);
        Assertions.assertEquals(4, b.hoehe());
    }


    @Test
    void preorder() {
        Assertions.assertEquals("Preorder: {}", b.preorder());
        for (Integer i : ints)
            b.insert(i);
        Assertions.assertEquals("Preorder: {3 - 2 - 1 - 5 - 4 - 7}", b.preorder());
    }

    @Test
    void inorder() {
        Assertions.assertEquals("Inorder: {}", b.inorder());
        for (Integer i : ints)
            b.insert(i);
        Assertions.assertEquals("Inorder: {1 - 2 - 3 - 4 - 5 - 7}", b.inorder());
    }

    @Test
    void postorder() {
        Assertions.assertEquals("Postorder: {}", b.postorder());
        for (Integer i : ints)
            b.insert(i);
        Assertions.assertEquals("Postorder: {1 - 2 - 4 - 7 - 5 - 3}", b.postorder());
    }

    @Test
    void breitensuche() {
        Assertions.assertEquals("Breitensuche: {}", b.breitensuche());
        for (Integer i : ints)
            b.insert(i);
        Assertions.assertEquals("Breitensuche: {3 - 2 - 5 - 1 - 4 - 7}", b.breitensuche());
    }
}