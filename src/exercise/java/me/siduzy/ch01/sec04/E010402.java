package me.siduzy.ch01.sec04;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class E010402 {

    public static int countOld(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (BinarySearch.indexOf(nums, -nums[i]-nums[j]) > j) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int count(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int target = nums[i] + nums[j];
                if (nums[i] > 0 && nums[j] > 0) {
//                    if (target == Integer.MIN_VALUE) // { 1, MAX_VALUE, MIN_VALUE}, -(1+MAX_VALUE) = -(MIN_VALUE) = MIN_VALUE
//                        target = Integer.MIN_VALUE;
//                    }
                    if (target > Integer.MIN_VALUE) {
                        continue;
                    }
                } else if (nums[i] <= 0 && nums[j] <= 0) {
                    if (target == Integer.MIN_VALUE || target >= 0) {
                        continue;
                    }
                }

                if (BinarySearch.indexOf(nums, target) > j) {
                    count++;
                }
            }
        }
        return count;
    }
}
