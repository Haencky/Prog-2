package Uebung_7;
import Uebung_0.A_3.Person;

public class Student extends Person implements Comparable<Student> {
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
    public boolean equals(Uebung_0.A_3.Student s) {
        return super.equals(s) && s.getMatrikelnummer() == this.matrikelnummer;
    }

    /**
     * Sortiert zwei Studenten anhand ihrer Matrikelnummer
     * @param s the Student to be compared.
     * @return -1, falls s.Matrikelnummer kleiner Matrikelnummer |
     *  0, falls s.Matrikelnummer gleich Matrikelnummer |
     *  1, falls s.Matrikelnummer größer Matrikelnummer |
     */
    @Override
    public int compareTo(Student s) {
        return s.matrikelnummer - this.matrikelnummer;
    }
}
