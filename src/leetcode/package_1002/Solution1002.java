package leetcode.package_1002;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Achan
 * @date 2020/10/14
 */
public class Solution1002 {
    public List<String> commonChars(String[] A) {
        int[] a = new int[26];

        for (int i = 0; i < A.length; i++) {
            String s = A[i];
            if (i == 0) {
                for (int j = 0; j < s.length(); j++) {
                    a[s.charAt(j) - 'a']++;
                }
                continue;
            }

            int[] b = new int[26];
            for (int j = 0; j < s.length(); j++) {
                if (a[s.charAt(j) - 'a'] != 0) {
                    b[s.charAt(j) - 'a']++;
                }
            }

            for (int j = 0; j < a.length; j++) {
                a[j] = Math.min(a[j], b[j]);
            }
        }

        ArrayList<String> res = new ArrayList<>(26);
        for (int i = 0; i < a.length; i++) {
            int count = a[i];
            while (count > 0) {
                count--;
                res.add(String.valueOf((char) (i + 'a')));
            }
        }
        return res;
    }
}
