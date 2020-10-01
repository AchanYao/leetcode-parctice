package leetcode.package_673;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Achan
 * @date 2020/9/20
 */
public class Solution673 {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n];
        int[] p = new int[n];
        p[0] = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] == dp[i] - 1) {
                        p[i] += p[j];
                    }
                }
            }
            if (p[i] == 0) {
                p[i] = 1;
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(p));

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (max == dp[i]) {
                result += p[i];
            }
        }

        return result;
    }

    @Test
    public void findNumberOfLISTest() {
        System.out.println(findNumberOfLIS(new int[]
                {1,3,5,4,7}));
    }
}
