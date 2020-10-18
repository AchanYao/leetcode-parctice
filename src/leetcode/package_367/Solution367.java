package leetcode.package_367;

/**
 * @author Achan
 * @date 2020/10/16
 */
public class Solution367 {

    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        long l = 2;
        long r = num >> 1;
        long mid = (r - l) / 2 + l;
        long temp = mid * mid;
        while (l <= r) {
            mid = (r - l) / 2 + l;
            if (temp == num) {
                return true;
            } else if (temp > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
