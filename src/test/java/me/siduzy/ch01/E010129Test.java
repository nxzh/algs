package me.siduzy.ch01;

import me.siduzy.ch01.sec01.E010129_binary_search;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class E010129Test {


    @Test
    public void testRankSmaller() {
        Assertions.assertEquals(0, E010129_binary_search.rankSmaller(1, new int[]{2}));
        Assertions.assertEquals(0, E010129_binary_search.rankSmaller(1, new int[]{1}));
        Assertions.assertEquals(1, E010129_binary_search.rankSmaller(2, new int[]{1}));

        Assertions.assertEquals(0, E010129_binary_search.rankSmaller(1, new int[]{1, 2}));
        Assertions.assertEquals(1, E010129_binary_search.rankSmaller(2, new int[]{1, 2}));
        Assertions.assertEquals(1, E010129_binary_search.rankSmaller(2, new int[]{1, 3}));
        Assertions.assertEquals(0, E010129_binary_search.rankLarger(0, new int[]{1, 3}));
        Assertions.assertEquals(2, E010129_binary_search.rankSmaller(4, new int[]{1, 3}));

        Assertions.assertEquals(1, E010129_binary_search.rankSmaller(2, new int[]{1, 2, 2, 2, 2, 2, 2, 2, 2, 2}));
        Assertions.assertEquals(1, E010129_binary_search.rankSmaller(2, new int[]{1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3}));
        Assertions.assertEquals(10, E010129_binary_search.rankSmaller(3, new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3}));
        Assertions.assertEquals(2, E010129_binary_search.rankSmaller(2, new int[]{0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3}));
        Assertions.assertEquals(11, E010129_binary_search.rankSmaller(4, new int[]{0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3}));
    }

    @Test
    public void testRankLarger() {
        Assertions.assertEquals(1, E010129_binary_search.rankLarger(1, new int[]{2}));
        Assertions.assertEquals(0, E010129_binary_search.rankLarger(1, new int[]{1}));
        Assertions.assertEquals(0, E010129_binary_search.rankLarger(2, new int[]{1}));

        Assertions.assertEquals(1, E010129_binary_search.rankLarger(1, new int[]{1, 2}));
        Assertions.assertEquals(0, E010129_binary_search.rankLarger(2, new int[]{1, 2}));
        Assertions.assertEquals(1, E010129_binary_search.rankLarger(2, new int[]{1, 3}));
        Assertions.assertEquals(2, E010129_binary_search.rankLarger(0, new int[]{1, 3}));
        Assertions.assertEquals(0, E010129_binary_search.rankLarger(4, new int[]{1, 3}));

        Assertions.assertEquals(0, E010129_binary_search.rankLarger(2, new int[]{1, 2, 2, 2, 2, 2, 2, 2, 2, 2}));
        Assertions.assertEquals(1, E010129_binary_search.rankLarger(2, new int[]{1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3}));
        Assertions.assertEquals(1, E010129_binary_search.rankLarger(2, new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3}));
        Assertions.assertEquals(10, E010129_binary_search.rankLarger(0, new int[]{0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3}));
        Assertions.assertEquals(0, E010129_binary_search.rankLarger(4, new int[]{0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3}));
    }

    @Test
    public void testCount() {
        Assertions.assertEquals(8, E010129_binary_search.count(2, new int[]{0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3}));
        Assertions.assertEquals(11, E010129_binary_search.count(2, new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}));
        Assertions.assertEquals(0, E010129_binary_search.count(1, new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}));
    }

    @Test
    public void testAll() {
        int[] ary = new int[]{0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3};
        int lo = E010129_binary_search.rankSmaller(2, ary);
        int count = E010129_binary_search.count(2, ary);
        for (int i = lo; i <= lo + count - 1; ++i) {
            Assertions.assertEquals(2, ary[i]);
        }
    }
}
