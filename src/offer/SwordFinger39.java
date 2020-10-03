package offer;

/**
 * @author Achan
 * @date 2020/10/3
 */
public class SwordFinger39 {
    public int majorityElement(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = 0;
        int count = 0;
        for (int i : nums) {
            if (count == 0) {
                result = i;
            }
            if (i == result) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }
}
