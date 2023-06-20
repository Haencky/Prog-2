package Uebung_8;

public class Main {
    public static void main(String[] args) {
        Integer[][] a = {
                {0,1,2,3},
                {4,5,6,7},
                {8,9,10,11}
        };

       SnakeIterator2DArray<Integer> s = new SnakeIterator2DArray<>(a);
       while (s.hasNext()) {
           System.out.println(s.next());
       }
    }
}
