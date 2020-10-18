package leetcode.package_242;

/**
 * @author Achan
 * @date 2020/10/16
 */
public class Solution242 {

    public boolean isAnagram(String s, String t) {
        int n = s.length();
        if (n != t.length()) {
            return false;
        }
        int[] a = new int[26];

        for (int i = 0; i < n; i++) {
            a[s.charAt(i) - 'a']++;
            a[t.charAt(i) - 'a']--;
        }
        for (int j : a) {
            if (j != 0) {
                return false;
            }
        }

        return true;
    }
}
