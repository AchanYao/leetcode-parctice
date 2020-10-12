package leetcode.package_416;

import java.util.Arrays;

/**
 * @author Achan
 * @date 2020/10/11
 */
public class Solution416 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) return false;
        int sum = 0, max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        if (target < max) return false;
        int[] dp = new int[target + 1];
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
        }
        return Arrays.binarySearch(dp, target) > -1;
    }
}
