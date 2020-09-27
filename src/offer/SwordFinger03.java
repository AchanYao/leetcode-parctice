package offer;

import org.junit.jupiter.api.Test;

/**
 * @author Achan
 * @date 2020/9/25
 */
public class SwordFinger03 {

    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        byte[] bytes = new byte[n];
        for (int num : nums) {
            if (bytes[num] == 1) {
                return num;
            } else {
                bytes[num] = 1;
            }
        }
        return -1;
    }

    @Test
    public void findRepeatNumberTest() {
        System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}
