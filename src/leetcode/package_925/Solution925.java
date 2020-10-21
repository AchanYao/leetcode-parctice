package leetcode.package_925;

/**
 * @author Achan
 * @date 2020/10/21
 */
public class Solution925 {

    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        while (i < name.length() && j < typed.length()) {
            char c1 = name.charAt(i);
            char c2 = typed.charAt(j);
            if (c1 != c2) {
                return false;
            }
            int count = 0;
            while (i < name.length() && name.charAt(i) == c1) {
                i++;
                count--;
            }
            while (j < typed.length() && typed.charAt(j) == c2) {
                j++;
                count++;
            }
            if (count < 0) {
                return false;
            }
        }
        return i >= name.length() && j >= typed.length();
    }
}
