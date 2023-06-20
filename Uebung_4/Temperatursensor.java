package Uebung_4;

public class Temperatursensor {
    float[] arr = null;
    int size = 0;

    public Temperatursensor(int capacity) {
        arr = new float[capacity];
    }

    public void insert(float f) {
        arr[size++ % arr.length] = f;
    }
}
