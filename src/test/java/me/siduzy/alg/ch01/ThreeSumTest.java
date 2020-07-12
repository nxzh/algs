package me.siduzy.alg.ch01;

import me.siduzy.ThreeSum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ThreeSumTest {

    @Test
    public void testCount() {
        ThreeSum threeSum = new ThreeSum();
        // [-4, -3, 7], [-4, -2, 6], [-4, -1, 5], [-4, 0, 4], [-4, 1, 3]
        // [-3, -2, 5], [-3, -1, 4], [-3, 0, 3], [-3, 1, 2]
        // [-2, -1, 3], [-2, 0, 2]
        // [-1, 0, 1]
        int[] nums = new int[]{-4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7};
        int result = threeSum.count(nums);
        Assertions.assertEquals(12, result);
    }
}
