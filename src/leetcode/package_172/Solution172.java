package leetcode.package_172;

/**
 * @author Achan
 * @date 2020/10/15
 */
public class Solution172 {

    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}
