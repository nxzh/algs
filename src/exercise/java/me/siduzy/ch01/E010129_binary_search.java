package me.siduzy.ch01;


public class E010129_binary_search {

    public static int rankSmaller(int k, int[] a) {
        int lo = 0, hi = a.length - 1;
        if (k <= a[lo]) { // this check makes sure the a[0] < k
            return 0;
        }
        if (k > a[hi]) {
            return a.length;
        }
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] >= k) {
                if (a[mid - 1] < k) { // mid - 1 won't out of index since a[0] is always less thant k
                    return mid;
                }
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return 1; // a[0]
    }

    public static int rankLarger(int k, int[] a) {
        int lo = 0, hi = a.length - 1;
        if (k < a[lo]) {
            return a.length;
        }
        if (k >= a[hi]) { // this ensures the a[a.length-1] > k;
            return 0;
        }
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] > k) {
                hi = mid - 1;
            } else {
                if (a[mid + 1] > k) {
                    return a.length - (mid + 1);
                }
                lo = mid + 1;
            }
        }
        return 1; // a[a.length-1]
    }

    public static int count(int k, int[] ary) {
        int smaller = rankSmaller(k, ary);
        int larger = rankLarger(k, ary);
        return ary.length - smaller - larger;
    }
}
