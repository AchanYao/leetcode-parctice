package leetcode.package_67;

/**
 * @author Achan
 * @date 2020/10/14
 */
public class Solution67 {
    boolean flag = false;

    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int m = b.length();
        int n = a.length();
        int i = 1;
        for (; i <= n && i <= m; i++) {
            builder.append(add(a.charAt(n - i), b.charAt(m - i)));
        }
        for (; i <= n; i++) {
            builder.append(add(a.charAt(n - i), '0'));
        }
        for (; i <= m; i++) {
            builder.append(add(b.charAt(m - i), '0'));
        }
        if (flag) {
            builder.append(1);
        }
        return builder.reverse().toString();
    }

    int add(char c1, char c2) {
        int res = (c1 - '0') + (c2 - '0');
        if (flag) {
            res++;
            flag = false;
        }
        if (res > 1) {
            res = res % 2;
            flag = true;
        }
        return res;
    }
}
