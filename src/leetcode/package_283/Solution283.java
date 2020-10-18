package leetcode.package_283;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Achan
 * @date 2020/10/16
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if (n < 2) return;
        int s = 0;

        // s找到第一个0
        while (s < n && nums[s] != 0) s++;
        int q = s + 1;
        while (q < n) {
            if (nums[q] == 0) {
                q++;
            } else {
                swap(nums, s++, q);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        if (i == j || nums[i] == nums[j]) return;
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    @Test
    void moveZeroesTest() {
        int[] array = new int[] {1, 0};
        moveZeroes(array);
        System.out.println(Arrays.toString(array));
    }
}
