package leetcode.package_387;

/**
 * @author Achan
 * @date 2020/11/2
 */
public class Solution387 {

    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] map = new int[26];
        for (char c : chars) {
            map[c - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (map[c - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
