package Uebung_6;

import Uebung_5.Folge;
import Uebung_5.FolgeMitDynArray;

public class Main {
    public static void main(String[] args) {
        IntSuchbaum b = new IntSuchbaum();
        b.insert(3);
        b.insert(2);
        b.insert(5);
        b.insert(4);
        b.insert(1);
        b.insert(7);

        System.out.println(b.toString());
        System.out.println(b.contains(2));
        System.out.println("Size: " + b.size());
        System.out.println("Höhe: " + b.hoehe());
        System.out.println(b.preorder());
        System.out.println(b.inorder());
        System.out.println(b.postorder());

        System.out.println(b.breitensuche());

        b.remove(3);
        System.out.println(b.toString());




    }
}
