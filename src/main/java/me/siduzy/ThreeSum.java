package me.siduzy;

import me.siduzy.Search;

import java.util.Arrays;

public class ThreeSum {

    /**
     * Get the number of triples which match the condition that the sum of integers in triple is zero.
     * Time complexity: N²logN
     *
     * @param nums array
     * @return the number of the pairs
     */
    public int count(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Search.binarySearchInRecursive(nums, -nums[i] - nums[j], j + 1, nums.length - 1) > j) {
                    count++;
                }
            }
        }
        return count;
    }
}
