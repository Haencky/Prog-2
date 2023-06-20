package Uebung_3.A_3;

import Uebung_2.A_3.Schlange;
import Uebung_2.A_3.SchlangeMitArrayGen;
import Uebung_3.A_2.SchlangeMitEVL;


/**
 * @version 11.04.2023
 * Die verkettete Liste ist wenn es nur um das reine einfügen und entfernen geht deutlich performanter als das Array
 */
public class TimeTestSchlange {
    public static void main(String[] args) {

        System.out.println("Array: " + getTime(new SchlangeMitArrayGen<Integer>(100000)) + "ms");  //Aufruf der Funktion und Systemausgabe mit Array
        System.out.println("EVL: " + getTime(new SchlangeMitEVL<Integer>()) + "ms");    //Aufruf der Funktion und Systemausgabe mit EVL
    }

    /**
     * Berechnet die Zeit der Einfüge & Removezeiten der jeweiligen Liste
     * @param s Schlange, da sowohl SchlangeMitEVL als auch SchlangeMitArray das Interface implementieren können hier beide
     *          der Funktion übergeben werden
     * @return Zeit in Millisekunden
     */
    static long getTime(Schlange<Integer> s) {
        long start = System.currentTimeMillis();    //Beginn der Messung
        int capacity = 100000;  //Kapazität

        for (int i = 0; i < capacity; i++) {
            s.insert(i);    //Einfügen
            s.remove();     //Entfernen
        }

        long finish = System.currentTimeMillis();   //Ende der Messung
        return finish - start;  //Rückgabe der Differenz als benötigte Zeit
    }
}
