package Uebung_4;

/**
 * Klasse zum Berechnen des kleinsten gemeinsamen vielfachen ALLER Zahlen von 1 - range
 * Diese Rechnung ist per Hand durch Primzahlzerlegung effizienter zu lösen
 */
public class ProjektEuler {
    /**
     * Bestimmt das kgV aller Zahlen von 1 - range
     * @param range Letzte Zahl (inklusive) die berücksichtigt wird
     * @return kgV aller Zahlen von 1-range
     */
    public static long kZ (int range) {
        //Startwert
        long n = range;
        while (true) {
            //Überprüft, ob das kgV gefunden wurde
            if (check(n,range+1))
                return n;
            //falls nicht, wird n erhöht
            n++;
        }
    }

    /**
     * Überprüft, ob n durch alle Zahlen von 1 bis range teilbar ist
     * @param n zu prüfende Zahl
     * @param range Größte Zahl durch die teilbar sein muss
     * @return true falls durch alle teilbar, false sonst
     */
    public static boolean check(long n, int range) {
        //geht durch alle Zahlen von range durch und überprüft,
        //ob n die Zahlen glatt teilt
        for (int i = 1; i < range; i++) {
            if (n % i != 0)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        int range = 15;
        long start = System.currentTimeMillis();
        long ergebnis = kZ(range);
        long ende = System.currentTimeMillis();
        double used = ende - start;
        double in_min = (used / 1000) / 60;
        System.out.println("Das kgV  aller Zahlen von 1-" + range + " ist: " + ergebnis + "\nZeit: " + (used)+"ms" + "\n" + in_min+" min");
    }
}
