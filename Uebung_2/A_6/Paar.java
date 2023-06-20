package Uebung_2.A_6;

/**
 * @author Tim Schulz
 * @version 28.03.2023
 * @param <E> Erstes Element
 * @param <Z> Zweites Element
 */
public class Paar <E, Z> {

    E erstes;
    Z zweites;

    public Paar (E e, Z z) {
        erstes = e;
        zweites = z;
    }

    public E getErstes() {
        return erstes;
    }

    public Z getZweites () {
        return zweites;
    }

    public E setErstes (E e) {
        E tmp = erstes;
        erstes = e;
        return tmp;
    }

    public Z setZweites (Z z) {
        Z tmp = zweites;
        zweites = z;
        return tmp;
    }

    public void setBeides (E e, Z z) {
        erstes = e;
        zweites = z;
    }

    public boolean equals (Paar<E,Z> p) {
        return p.getErstes().equals(this.getErstes()) && p.getZweites().equals(this.getZweites());
    }

    public String toString () {
        return erstes.toString() + ", " + zweites.toString();
    }
}
