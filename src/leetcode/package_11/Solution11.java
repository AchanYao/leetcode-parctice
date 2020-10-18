package leetcode.package_11;

/**
 * @author Achan
 * @date 2020/10/18
 */
public class Solution11 {

    public int maxArea(int[] height) {
        int n = height.length;
        if (n == 2) {
            return height[0] * height[1];
        }

        int res = 0;
        int l = 0, r = n - 1;
        while (l < r) {
            res = Math.max(res, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
