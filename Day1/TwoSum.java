package day1;

import java.util.*;

/**
 * LeetCode 1 — Two Sum
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int needed = target - nums[i];

            if (map.containsKey(needed)) {
                return new int[]{ map.get(needed), i };
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
