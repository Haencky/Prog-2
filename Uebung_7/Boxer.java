package Uebung_7;
import Uebung_0.A_3.Person;

public class Boxer extends Person implements Comparable<Boxer>{
    private int gewicht;
    public Boxer(String name, String vorname, int gewicht) {
        super(name, vorname);
        this.gewicht = gewicht;
    }

    @Override
    public String toString() {
        return super.toString() + " , " + gewicht;
    }

    public int getGewicht() {
        return gewicht;
    }

    /**
     * Vergleicht einen Boxer mit einem anderen
     * @param b Zu vergleichender Boxer
     * @return true, falls Name & Vorname UND gewicht gleich sind
     */
    public boolean equals (Uebung_0.A_3.Boxer b) {
        return super.equals(b) && b.getGewicht() == this.gewicht;
    }

    /**
     *
     * @param b the Boxer to be compared.
     * @return 1, falls b schwerer ist | -1, falls b leichter ist |
     * 1, falls gewicht gleich name aber größer | -1, falls gewicht gleich
     * name aber kleiner | 1, falls gewicht & name gleich vorname aber größer |
     * -1, fall gewicht & name gleich vorname aber kleiner | 0, falls gleich
     */
    @Override
    public int compareTo(Boxer b) {
        int comp = b.gewicht - this.gewicht;
        //Vergleicht zuerst das Gewicht.
        //Sollte b schwerer sein, ist b "größer"
        if (comp != 0)
            return comp;
        //Sollte das Gewicht gleich sein
        else {
            //Wird der Nachname verglichen
            int compareName = b.getName().compareTo(getName());
            //Sollten sie ungleich sein, wird die Antwort zurück gegeben
            if (compareName != 0)
                return compareName;
            //als Letztes wird dann der Vorname verglichen
            else {
                return b.getVorname().compareTo(getVorname());
            }
        }
    }
}
