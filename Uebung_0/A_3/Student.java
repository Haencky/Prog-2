package Uebung_0.A_3;

public class Student extends Person{

    private int matrikelnummer;
    public Student(String name, String vorname, int nummer) {
        super(name, vorname);
        matrikelnummer = nummer;
    }

    public int getMatrikelnummer() {
        return matrikelnummer;
    }

    @Override
    public String toString() {
        return super.toString() + " , " + matrikelnummer;
    }

    /**
     * Vergleicht zusätzlich die Matrikelnummer
     * @param s Zu vergleichender Student
     * @return true falls Name & Vorname gleich UND Matrikelnummer
     */
    public boolean equals(Student s) {
        return super.equals(s) && s.getMatrikelnummer() == this.matrikelnummer;
    }
}
