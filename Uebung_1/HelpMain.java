package Uebung_1;

import Uebung_0.A_2.Schlange;
import Uebung_0.A_2.SchlangeMitArray;
import Uebung_0.A_2.StapelMitArray;

import java.util.NoSuchElementException;

public class HelpMain {
    public static void main(String[] args) {

        SchlangeMitArray s = new SchlangeMitArray(5);

        System.out.println(s.capacity());
        //System.out.println(s.size());

        for (int i = 0; i < s.capacity(); i++) {
            s.insert(i);
        }

        for (int i = 0; i < s.capacity(); i++) {
            System.out.println(s.remove());
        }
    }
}
