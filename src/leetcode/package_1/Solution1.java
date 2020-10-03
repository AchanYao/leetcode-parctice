package leetcode.package_1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Solution
 */
public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            if (map.containsKey(target - nums[i])) {
                int val = map.get(target - nums[i]);
                if (val != i) {
                    return new int[]{i, val};
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int val = map.get(target - nums[i]);
                if (val != i) {
                    return new int[]{i, val};
                }
            }
        }
        return new int[] {};
    }

    @Test
    void twoSumTest() {
        System.out.println(Arrays.toString(twoSum(new int[] {3, 2, 4}, 6)));
    }
}