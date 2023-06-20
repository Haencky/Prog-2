package Uebung_7;

import Uebung_0.A_3.Person;

import java.util.Comparator;

public class ComparatorPersonVornameName implements Comparator<Person> {

    /**
     * Vergleicht zwei Personen zuerst anhand ihres Vornamen & dann anhand des Namens
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return 1, falls o1 > o2, -1, falls o1 < o2, 0, falls o1 = o2
     */
    @Override
    public int compare(Person o1, Person o2) {
        //Falls o1 in der Sortierung größer ist, wird 1 zurückgegeben
        if (o1.getVorname().compareTo(o2.getVorname()) > 0)
            return 1;
        //Falls o1 in der Sortierung kleiner ist, wird -1 zurückgegeben
        else if (o1.getVorname().compareTo(o2.getVorname()) < 0)
            return -1;
        //Falls die Vornamen gleich sind, wird der Name überprüft
        //Falls die Namen gleich sind, wird 0 zurückgegeben
        //Falls die Namen ungleich sind, wird 1 zurückgegeben, falls o1>o2,
        // -1 falls o1<o2
        else {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
