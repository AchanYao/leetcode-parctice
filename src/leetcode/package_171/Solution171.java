package leetcode.package_171;

/**
 * @author Achan
 * @date 2020/10/15
 */
public class Solution171 {

    public int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i) - 'A' + 1;
            res = res * 26 + temp;
        }
        return res;
    }
}
