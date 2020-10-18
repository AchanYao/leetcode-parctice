package leetcode.package_8;

/**
 * @author Achan
 * @date 2020/10/18
 */
public class Solution8 {
    public int myAtoi(String s) {
        s = s.trim();
        int start = 0;
        int end = 0;
        boolean negative = false;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            start = 1;
        }
        if (s.charAt(0) == '-') {
            negative = true;
        }
        for (end = start; end < s.length(); end++) {
            char c = s.charAt(end);
            if (c < '0' || c > '9') {
                break;
            }
        }
        if (start == end) {
            return 0;
        }
        long temp = 0;
        while (start < end) {
            char c = s.charAt(start++);
            temp = negative ? temp * 10 + (c - '0') : temp * 10 - (c - '0');
            if (temp > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (temp < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) temp;
    }
}
