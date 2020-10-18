package leetcode.package_169;

import java.util.Arrays;

/**
 * @author Achan
 * @date 2020/10/15
 */
public class Solution169 {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
