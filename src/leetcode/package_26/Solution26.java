package leetcode.package_26;

/**
 * @author Achan
 * @date 2020/10/12
 */
public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;
        int max = nums[n - 1];
        int i = 0, j = 0;
        for (; i < n; i++) {
            if (nums[i] > nums[j]) {
                nums[++j] = nums[i];
            }
            if (nums[j] == max) break;
        }
        return ++j;
    }
}
