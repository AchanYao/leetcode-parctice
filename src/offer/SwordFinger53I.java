package offer;

import java.util.Arrays;

/**
 * @author Achan
 * @date 2020/10/3
 */
public class SwordFinger53I {
    public int search(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        if (index < 0) return 0;
        int result = 1;
        int pre = index - 1;
        int next = index + 1;
        while (next < nums.length && nums[next++] == target) {
            result++;
        }
        while (pre >= 0 && nums[pre--] == target) {
            result++;
        }
        return result;
    }
}
