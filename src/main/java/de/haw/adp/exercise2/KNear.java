package main.java.de.haw.adp.exercise2;


public class KNear {

    private static void sort(int[] a) {
        int i;
        int j;
        int key;

        for (i = 1; i < a.length; i++) {
            key = a[i];
            j = i - 1;

            // Move elements greater than key, to one
            // position ahead of their current position.
            // This loop will run at most k times
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 2, 6, 9, 3, 1, 23, 45, 11, 123, 42, 55, 0, 3, 4, 3, 4, 3};
        sort(a);
        for (int value : a) {
            System.out.println(value);
        }
    }
}
