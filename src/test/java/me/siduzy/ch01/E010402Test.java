package me.siduzy.ch01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static me.siduzy.ch01.sec04.E010402.count;
import static me.siduzy.ch01.sec04.E010402.countOld;

public class E010402Test {

    @Test
    public void testCount() {
        int[] nums = new int[]{-1, Integer.MIN_VALUE, Integer.MIN_VALUE + 1};
        int cntOld = countOld(nums);
        Assertions.assertEquals(1, cntOld);
        int cnt = count(nums);
        Assertions.assertEquals(0, cnt);

        nums = new int[] {1, Integer.MAX_VALUE, Integer.MIN_VALUE};
        cntOld = countOld(nums);
        Assertions.assertEquals(0, cntOld);
        cnt = count(nums);
        Assertions.assertEquals(1, cnt);
    }
    @Test
    public void testMinValue() {
        Assertions.assertEquals(-Integer.MIN_VALUE, Integer.MIN_VALUE);
    }
}
