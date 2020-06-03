package me.siduzy.alg.ch01;

import me.siduzy.Search;

import java.util.Arrays;

public class TwoSum {
    /**
     * Get the number of pairs which match the condition that the sum of integers in pair is zero.
     * Time complexity: NlogN
     *
     * @param nums array
     * @return the number of the pairs
     */
    public int count(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (Search.binarySearchInLoop(nums, -nums[i]) > i) {
                count++;
            }
        }
        return count;
    }
}
