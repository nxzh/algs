package me.siduzy;

public class Search {
    public static int binarySearchInLoop(int[] a, int n) {
        int low = 0;
        int high = a.length - 1;
        // low <= high not low < high
        // Avoid missing numbers. When low = high, then mid = low = high. This happens when the low and high narrows down
        // and finally become the last same index to compare.
        while (low <= high) {
            int mid = low + (high - low) /2; //(high + low) / 2; may memory leak
            if (a[mid] > n) {
                high = mid - 1;
            } else if (a[mid] < n) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int binarySearchInRecursive(int[] a, int n, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (a[mid] > n) {
            return binarySearchInRecursive(a, n, low, mid - 1);
        } else if (a[mid] < n) {
            return binarySearchInRecursive(a, n, mid + 1, high);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        System.out.println("--- * Test Recursive * ---");
        int[] ary = new int[]{0, 1, 3, 5, 7, 9};
        for (int i = 0; i < ary.length; ++i) {
            System.out.println("Searching " + ary[i] + ", result: " + binarySearchInRecursive(ary, ary[i], 0, ary.length - 1));
        }
        System.out.println("--- * Test Loop * ---");
        for (int i = 0; i < ary.length; ++i) {
            System.out.println("Searching " + ary[i] + ", result: " + binarySearchInLoop(ary, ary[i]));
        }
    }
}
