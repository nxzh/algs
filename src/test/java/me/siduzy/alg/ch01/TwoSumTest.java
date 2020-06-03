package me.siduzy.alg.ch01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TwoSumTest {

    @Test
    public void testCount() {
        TwoSum twoSum = new TwoSum();
        int[] input = new int[] {-3, -2, -1, 0, 1, 2, 3};
        int res = twoSum.count(input);
        Assertions.assertEquals(3, res);
    }
}
