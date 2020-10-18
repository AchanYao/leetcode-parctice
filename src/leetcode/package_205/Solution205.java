package leetcode.package_205;

import org.junit.jupiter.api.Test;

/**
 * @author Achan
 * @date 2020/10/16
 */
public class Solution205 {

    public boolean isIsomorphic(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        int[] chars1 = new int[128];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            if (chars1[index] == 0) {
                chars1[index] = t.charAt(i);
            } else {
                if (chars1[index] != t.charAt(i)) {
                    return false;
                }
            }
        }

        int[] chars2 = new int[128];
        for (int i = 0; i < s.length(); i++) {
            int index = t.charAt(i);
            if (chars2[index] == 0) {
                chars2[index] = s.charAt(i);
            } else {
                if (chars2[index] != s.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    void isIsomorphicTest() {
        System.out.println(isIsomorphic("ab", "aa"));
    }
}
