package leetcode.package_191;

/**
 * @author Achan
 * @date 2020/10/16
 */
public class Solution191 {

    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            ans += (n & 1);
            n = n >>> 1;
        }
        return ans;
    }
}
