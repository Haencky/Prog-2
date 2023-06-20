package Uebung_9;

import Uebung_2.A_3.Puffer;
import Uebung_2.A_3.Schlange;
import Uebung_3.A_2.SchlangeMitEVL;

public class GenericUtil <T>{

    public static <U> U gambling(U e, U z) {
        return Math.random() > 0.5 ? e : z;
    }

    public static <U> Schlange<U> toSchlange(U[] a) {
        SchlangeMitEVL<U> s = new SchlangeMitEVL<>();
        for (int i = 0; i < a.length; i++) {
            s.insert(a[i]);
        }
        return s;
    }

    public static <U> U gambling(Puffer<U> p1, Puffer<U> p2) {
        return (U) (Math.random() > 0.5 ? p1 : p2);
    }
}
