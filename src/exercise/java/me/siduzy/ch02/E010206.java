package me.siduzy.ch02;

import edu.princeton.cs.algs4.StdOut;

public class E010206 {
    public static boolean isCircularRotation(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        if (s.length() == 0 && t.length() == 0) {
            return true;
        }
        int nextPos = -1;
        while ((nextPos = t.indexOf(s.charAt(0), nextPos + 1)) > 0) {
            if (isCircularRotation(s, t, nextPos)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCircularRotation(String s, String t, int tBegin) {
        int N = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt((tBegin + i) % N)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        StdOut.println(isCircularRotation(null, "TGACGAC")); // false
        StdOut.println(isCircularRotation("", null));// false
        StdOut.println(isCircularRotation("", "")); // true
        StdOut.println(isCircularRotation("A", "C")); // false
        StdOut.println(isCircularRotation("ACTGACG", "TGACGAC")); // true
    }
}
