package Uebung_4;

public class Main {
    public static void main(String[] args) {
        DynArray<Integer> i = new DynArray<>();
        i.addFirst(5);
        i.addFirst(4);
        i.addFirst(3);
        i.addFirst(2);
        i.addFirst(1);
        i.addFirst(0);

        for (int j = 0; j < 6; j++) {
            i.set(j, i.get(j)*2);
        }
        System.out.println(i.toString());
    }
}
