package Uebung_2.Zusatz;

public class Eulerprojekt {

    public static int eulersumme (int range) {
        int e = 0;
        for (int i = 0; i < range; i++) {
            if (i % 3 == 0 | i % 5 == 0) {
                e += i;
            }
        }
        return e;
    }

    public static void main(String[] args) {
        System.out.println(eulersumme(10000));
    }
}
