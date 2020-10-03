package leetcode.package_268;

/**
 * @author Achan
 * @date 2020/10/1
 */
public class Solution268 {

    public int missingNumber(int[] nums) {
        int temp = nums.length;
        for (int i = 1; i < nums.length; i++) {
            temp ^= i ^ nums[i];
        }
        return temp;
    }
}
