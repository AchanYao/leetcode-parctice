package leetcode.package_303;

/**
 * @author Achan
 * @date 2020/10/16
 */
public class NumArray {

    private final int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j] - sums[i];
    }
}
