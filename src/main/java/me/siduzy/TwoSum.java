package me.siduzy;

import me.siduzy.Search;

import java.util.Arrays;

/**
 * find all the number of pairs which sum is zero
 * Assuming that the number is different from any other each.
 */
public class TwoSum {
    /**
     * Get the number of pairs which match the condition that the sum of integers in pair is zero.
     * Time complexity: NlogN
     *
     * @param nums array
     * @return the number of the pairs
     */
    public static int count(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (Search.binarySearchInLoop(nums, -nums[i]) > i) {
                count++;
                System.out.println(i + ", " + Search.binarySearchInLoop(nums, -nums[i]));
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int count = count(new int[]{-5, -5, -4, -3, -2, -1, 0, 1, 1, 2, 3, 4, 5});
        System.out.println(count);
    }
}
