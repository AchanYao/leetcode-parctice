package leetcode.package_69;

/**
 * @author Achan
 * @date 2020/10/14
 */
public class Solution69 {

    public int mySqrt(int x) {
        if (x <= 1) return x;

        int f = 1;
        int l = (x >> 2);
        int ans = 0;
        while (f <= l) {
            int mid = (l - f) >> 1 + f;
            if ((long) (mid * mid) <= x) {
                f = mid + 1;
                ans = mid;
            } else {
                l = mid - 1;
            }
        }

        return ans;
    }
}
