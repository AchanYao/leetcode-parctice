package offer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Achan
 * @date 2020/10/4
 */
public class SwordFinger61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (nums[l] == 0) {
            l++;
        }
        if (nums[r] - nums[l] >= nums.length) {
            return false;
        }
        int temp = l;
        for (l += 1; l <= r; l++) {
            if (nums[l - 1] == nums[l]) return false;
            if ((temp -= nums[l] - nums[l - 1] - 1) < 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    void isStraightTest() {
        System.out.println(isStraight(new int[]{0, 0, 1, 1, 5}));
    }
}
