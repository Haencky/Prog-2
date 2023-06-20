package Uebung_7;

import Uebung_0.A_3.Person;
import Uebung_4.DynArray;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Comparator<Person> cs = new ComparatorPersonVornameName();
        Comparator<Boxer> cb = new ComparatorBoxerGewicht();
        Suchbaum<Person> b = new Suchbaum<>();

        Person a = new Student("Lena", "Anna", 123);
        Person pb = new Student("Bär", "Berthold", 69420);
        Person c = new Student("Cheen", "Charlie", 555);
        Person d = new Student("Ditto", "Dennis", 12);
        Person e = new Student("Haus", "Baum", 1234);


        b.insert(a);
        b.insert(pb);
        b.insert(e);
        b.insert(c);
        b.insert(d);

        System.out.println(b.contains(new Student("Lena", "Anna", 123)));

        System.out.println(b.toString());
    }
}
