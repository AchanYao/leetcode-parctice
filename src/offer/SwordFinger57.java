package offer;

import java.util.Arrays;

/**
 * @author Achan
 * @date 2020/9/27
 */
public class SwordFinger57 {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (Arrays.binarySearch(nums, i, nums.length, target - nums[i]) > -1) {
                return new int[] {nums[i], target - nums[i]};
            }
        }
        return null;
    }
}
