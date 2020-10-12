package leetcode.package_35;

import org.junit.jupiter.api.Test;

/**
 * @author Achan
 * @date 2020/10/12
 */
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        // 二分查找比当前值小的第一个数
        int n = nums.length;
        int f = 0;
        int t = n - 1;
        int ans = n;
        while (f <= t) {
            int m = (t - f) / 2 + f;
            if (nums[m] < target) {
                f = m + 1;
            } else {
                t = m - 1;
                ans = m;
            }
        }
        return ans;
    }

    @Test
    void searchInsertTest() {
        System.out.println(searchInsert(new int[] {1}, 1));
    }
}
