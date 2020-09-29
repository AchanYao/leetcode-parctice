package leetcode.package_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Achan
 * @date 2020/9/16
 */
public class Solution {
    public String longestPalindrome(String s) {
        // TODO dp优化
        int n = s.length();
        if (n == 0) {
            return "";
        }
        String result = s.charAt(0) + "";
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        // 先判断当前字符串
        for (int i = n; i >= 0; i--) {
            for (int j = 0; j < i && i - j > result.length(); j++) {
                String temp = s.substring(j, i);
                if (isPalindrome(temp)) {
                    dp[i] = Math.max(temp.length(), dp[i - 1]);
                    if (temp.length() > result.length()) {
                        result = temp;
                    }
                } else {
                    dp[i] = Math.max(dp[i], dp[i - 1]);
                }
            }
        }
        return result;
    }

    public boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void longestPalindromeTest() {
        Assertions.assertEquals("cccccccc", longestPalindrome("cccccccc"));
    }

    @Test
    public void isPalindromeTest() {
        Assertions.assertTrue(isPalindrome("a"));
        Assertions.assertTrue(isPalindrome("aba"));
        Assertions.assertTrue(isPalindrome("abba"));
        Assertions.assertFalse(isPalindrome("abc"));
    }
}
