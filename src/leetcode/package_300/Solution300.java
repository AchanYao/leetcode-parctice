package leetcode.package_300;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        int result = -1;
        for (int j : dp) {
            result = Math.max(result, j);
        }
        return result;
    }

    @Test
    public void lengthOfLISTest() {
        System.out.println(lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
    }
}
