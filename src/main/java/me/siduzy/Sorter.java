package me.siduzy;

import java.util.Arrays;

public class Sorter {

    public static void shellSort(int[] a) {
        int h = 1;
        int n = a.length;
        int factor = 3;
        while (h < n / factor) {
            h = h * factor + 1; // Why +1
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                insertionSortWithDistance(a, i, h);
            }
            h = h / factor;
        }
    }

    public static void selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            exch(a, i, min); // must happen
        }
    }

    private static void insertionSortWithDistance(int[] a, int start, int dist) {
        for (int i = start; i - dist >= 0; i -= dist) {
            if (a[i] < a[i - dist]) {
                exch(a, i, i - dist);
            }
        }
    }

    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; ++i) {
            insertionSortWithDistance(a, i, 1);
        }
    }

    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int a[] = new int[]{1, 3, 5, 2, 4, 6, 8, 7};
        shellSort(a);
        System.out.println(Arrays.toString(a));
    }
}
