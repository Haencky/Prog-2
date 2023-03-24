package Uebung_0.A_3;

/**
 * @author Tim Schulz
 * @version 24.03.2023
 */
public class Boxer extends Person {

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
    public boolean equals (Boxer b) {
        return super.equals(b) && b.getGewicht() == this.gewicht;
    }
}
