package Uebung_0.A_3;

/**
 * @author Tim Schulz
 * @version 24.03.2023
 */
public abstract class Person {
    private String name;
    private String vorname;

    public Person (String name, String vorname) {
        this.name = name;
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public String getVorname() {
        return vorname;
    }

    public String toString() {
        return name + ", " + vorname;
    }

    /**
     * Vergleicht zwei Personen auf gleichheit bezüglich ihres Namen & Vornamen
     * @param p Zu vergleichende Person
     * @return true falls beides gleich ist
     */
    public boolean equals (Person p) {
        if (p.getName().equals(this.name) && p.getVorname().equals(this.vorname)) {     //Vergleich, ob beides gleich
            return true;
        }
        return false;
    }
}
