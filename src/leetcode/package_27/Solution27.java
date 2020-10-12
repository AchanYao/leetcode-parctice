package leetcode.package_27;

/**
 * @author Achan
 * @date 2020/10/12
 */
public class Solution27 {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        if (n == 1) {
            if (nums[0] == val) {
                return 0;
            } else {
                return 1;
            }
        }
        int h = 0, t = n - 1;
        while (h < t) {
            while (t >= 0 && nums[t] == val) t--;
            while (h < n && nums[h] != val) h++;
            if (h < t) {
                nums[h] = nums[t];
                nums[t] = val;
            }
        }
        while (t >= 0 && nums[t] == val) t--;
        return t + 1;
    }
}
