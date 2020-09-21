package leetcode.package_2;

/**
 * Solution
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int temp = 0;

        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (s.substring(temp, j).contains("" + c)) {
                if (result < j - temp) {
                    result = j - temp;
                }
                temp = s.indexOf(c, temp) + 1;
            }
        }
        if (result < s.substring(temp).length()) {
            result = s.substring(temp).length();
        }
        return result;
    }
}