package leetcode.package_66;

/**
 * @author Achan
 * @date 2020/10/12
 */
public class Solution66 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        return plusOne(digits, n - 1);
    }

    public int[] plusOne(int[] digits, int index) {
        if (index < 0) {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            System.arraycopy(digits, 0, ans, 1, digits.length);
            return ans;
        }
        digits[index]++;
        if (digits[index] >= 10) {
            digits[index] = 0;
            return plusOne(digits, index - 1);
        }
        return digits;
    }
}
