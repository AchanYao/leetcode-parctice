package leetcode.package_231;

/**
 * @author Achan
 * @date 2020/10/16
 */
public class Solution231 {

    public boolean isPowerOfTwo(int n) {
        while (n != 0) {
            if ((n & 1) != 0) {
                return false;
            }
            n = n >> 1;
        }
        return true;
    }
}
