package leetcode.package_1143;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Achan
 * @date 2020/10/1
 */
public class Solution1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[n][m];
    }

    @Test
    void longestCommonSubsequenceTest() {
        System.out.println(longestCommonSubsequence("abc", "abf"));
    }
}
