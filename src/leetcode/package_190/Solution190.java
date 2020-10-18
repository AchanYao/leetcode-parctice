package leetcode.package_190;

/**
 * @author Achan
 * @date 2020/10/16
 */
public class Solution190 {

    public int reverseBits(int n) {
        int ans = 0;
        int count = 0;
        while (n != 0) {
            int temp = n & 1;
            n = n >> 1;
            ans = ans * 2 + temp;
            count++;
        }
        ans = ans << (32 - count);
        return ans;
    }
}
