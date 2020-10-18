package leetcode.package_217;

/**
 * @author Achan
 * @date 2020/10/16
 */
public class Solution217 {

    public boolean containsDuplicate(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j])
                    break;
                if (nums[j] == nums[i])
                    return true;
            }
        }
        return false;
    }
}
