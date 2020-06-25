package me.siduzy.ch01.sec01;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class E010128 {

    public static int uniquify(int[] a) {
        int i = 0;
        for (int j = 1; j < a.length; j++) {
            if (a[i] != a[j]) {
                a[++i] = a[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();
        Arrays.sort(whitelist);
        int[] copy = Arrays.copyOf(whitelist, whitelist.length);
        int uniqueLen = uniquify(whitelist);
        List<Integer> anotherUnique = Arrays.stream(copy).distinct().boxed().collect(Collectors.toList());
        assert uniqueLen == anotherUnique.size() : "length should be same";
        for (int i = 0; i < uniqueLen; ++i) {
            assert whitelist[i] == anotherUnique.get(i);
        }
    }
}
