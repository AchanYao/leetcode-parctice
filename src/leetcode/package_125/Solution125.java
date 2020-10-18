package leetcode.package_125;

import org.junit.jupiter.api.Test;

/**
 * @author Achan
 * @date 2020/10/15
 */
public class Solution125 {

    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            while (i < j && !match(i, chars)) {
                i++;
            }
            while (i < j && !match(j, chars)) {
                j--;
            }
            if (chars[i++] != chars[j--]) {
                return false;
            }
        }
        return true;
    }

    boolean match(int i, char[] chars) {
        if (chars[i] <= 'z' && chars[i] >= 'a') {
            return true;
        }
        if (chars[i] <= 'Z' && chars[i] >= 'A') {
            chars[i] = (char) (chars[i] - 'A' + 'a');
            return true;
        }
        return chars[i] <= '9' && chars[i] >= '0';
    }

    @Test
    void isPalindromeTest() {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
