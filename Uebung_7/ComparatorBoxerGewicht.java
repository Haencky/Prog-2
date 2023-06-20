package Uebung_7;

import java.util.Comparator;

public class ComparatorBoxerGewicht implements Comparator<Boxer> {

    /**
     * Vergleicht zwei Boxer anhand ihres Gewichtes
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return 0, falls das Gewicht gleich ist |
     * >1, falls das Gewicht von o1 > als Gewicht von o2 |
     * <1, falls das Gewicht von o1 < als Gewicht von o2
     */
    @Override
    public int compare(Boxer o1, Boxer o2) {
        return o1.getGewicht() - o2.getGewicht();
    }
}
