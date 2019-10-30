package main.java.de.haw.adp.exercise2;

import edu.princeton.cs.algs4.StdOut;

import java.util.*;
import java.util.stream.Stream;

public class MergeSort {
    private static int counter = 0;

    private static Comparable[] aux;

    private static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        // Sort left half.
        sort(a, lo, mid);
        // Sort right half.
        sort(a, mid + 1, hi);

        merge(a, lo, mid, hi);
    }


    private static void sortBU(Comparable[] a) {

        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) //
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
        }
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {

        int i = lo;
        int j = mid + 1;
        System.arraycopy(a, lo, aux, lo, hi + 1 - lo);

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
                counter += 2;
            } else if (j > hi) {
                a[k] = aux[i++];
                counter += 2;
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
                counter += 4;
            } else {
                a[k] = aux[i++];
                counter += 2;
            }
        }

    }


    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        StdOut.println(Arrays.toString(a));
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String[] a = new Scanner(System.in).nextLine().split("");
        /*
        Queue<String[]> main = new LinkedList<>();
        for (String s : a) {
            main.add(new String[]{s});
        }
        while (main.size() > 1) {
            for (String[] strings : main) {
                System.out.print(Arrays.toString(strings));
            }
            System.out.println();
            String[] first = main.poll();
            String[] second = main.poll();
            assert first != null;
            sortBU(first);
            assert second != null;
            sortBU(second);
            String[] c = Stream.concat(Arrays.stream(first), Arrays.stream(second))
                    .toArray(String[]::new);
            sortBU(c);
            main.add(c);

        }
        show(main.peek());
        */

        sortBU(a);
        System.out.println(counter);
        counter = 0;
        sort(a);
        System.out.println(counter);

    }


}