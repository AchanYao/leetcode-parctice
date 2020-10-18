package leetcode.package_219;

/**
 * @author Achan
 * @date 2020/10/16
 */
public class Solution219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0 && i - j <= k; j--) {
                if (nums[i] > nums[j])
                    break;
                if (nums[j] == nums[i])
                    return true;
            }
        }
        return false;
    }
}
