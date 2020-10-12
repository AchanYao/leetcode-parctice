package leetcode.package_38;

/**
 * @author Achan
 * @date 2020/10/12
 */
public class Solution38 {
    public String countAndSay(int n) {
        if (n <= 1) return String.valueOf(n);
        String before = countAndSay(n - 1);
        StringBuilder ans = new StringBuilder();
        int index = 0;
        for (int i = 0; i < before.length(); i++) {
            if (before.charAt(index) != before.charAt(i)) {
                ans.append(i - index).append(before.charAt(index));
                index = i;
            }
        }
        ans.append(before.length() - index).append(before.charAt(index));
        return ans.toString();
    }
}
