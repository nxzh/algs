package me.siduzy.ch01.sec04;

import edu.princeton.cs.algs4.StdOut;

public class E010411 {
    public static class StaticSETofInts {
        private int[] ary;

        public StaticSETofInts(int[] a) {
            ary = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                ary[i] = a[i];
            }
        }

        boolean contains(int key) {
            int lo = 0;
            int hi = ary.length - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (ary[mid] > key) {
                    hi = mid - 1;
                } else if (ary[mid] < key) {
                    lo = mid + 1;
                } else {
                    return true;
                }
            }
            return false;
        }

        public int findLeftEnd(int key) {
            int lo = 0;
            int hi = ary.length - 1;
            int lE = -1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (ary[mid] > key) {
                    hi = mid - 1;
                } else if (ary[mid] < key) {
                    lo = mid + 1;
                } else {
                    lE = mid;
                    hi = mid - 1;
                }
            }
            return lE;
        }

        public int findRightEnd(int key) {
            int lo = 0;
            int hi = ary.length - 1;
            int rE = -1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (ary[mid] > key) {
                    hi = mid - 1;
                } else if (ary[mid] < key) {
                    lo = mid + 1;
                } else {
                    rE = mid;
                    lo = mid + 1;
                }
            }
            return rE;
        }


        public int howMany(int key) {
            int lo = 0;
            int hi = ary.length - 1;
            int lE = findLeftEnd(key);
            if (lE == -1) {
                return 0;
            }
            int rE = findRightEnd(key);
            return rE - lE + 1;
        }
    }

    public static void main(String[] args) {
        StaticSETofInts set = new StaticSETofInts(new int[]{-1, 1, 1, 1, 2, 2});
        StdOut.println(set.howMany(0));
        StdOut.println(set.howMany(-1)); // 2
        StdOut.println(set.howMany(1)); // 3
        StdOut.println(set.howMany(2)); // 2
    }
}
