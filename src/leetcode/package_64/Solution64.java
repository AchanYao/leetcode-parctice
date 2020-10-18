package leetcode.package_64;

import java.util.Arrays;

/**
 * @author Achan
 * @date 2020/10/18
 */
public class Solution64 {


    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], 0xfff);
        }
        dp[1][0] = 0;
        dp[0][1] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = Math.min(dp[i][j + 1], dp[i + 1][j]) + grid[i][j];
            }
        }
        return dp[m][n];
    }
}
