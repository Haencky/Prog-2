package Uebung_5;

public class Euler_Fibonacci {


    public static int[] fib(int grenze) {
        int sum = 0;
        int counter = 0;
        int fibonacci = 0;
        int prev1 = 1;
        int prev2 = 0;

        while ((fibonacci + sum) <= grenze) {
            //System.out.printf("Prev_1: %d, Prev_2: %d\n", prev1, prev2);
            fibonacci = prev1 + prev2;
            prev2 = prev1;
            prev1 = fibonacci;

            if (fibonacci %2 == 0)
                sum += fibonacci;

            counter++;
        }
        int[] a = {sum, counter,prev1, prev2};
        return a;
    }

    public static void main(String[] args) {
        int[] a = fib(4_000_000);
        int e = a[0];
        int t = a[1];
        int eins = a[2];
        int zwei = a[3];
        System.out.printf("Ergebnis: %d, Terme: %d\n", e, t);
        System.out.printf("Wert 1: %d, Wert 2: %d\n", eins, zwei);
    }
}
