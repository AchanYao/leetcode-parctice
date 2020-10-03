package offer;

/**
 * @author Achan
 * @date 2020/10/3
 */
public class SwordFinger53II {
    public int missingNumber(int[] nums) {
        int low = 0, high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (high - low) / 2 + low;
            if (mid == nums[mid]) {
                low = mid + 1;
            } else if (mid < nums[mid]) {
                high = mid - 1;
            }
        }
        return mid == nums[mid] ? mid + 1 : mid;
    }
}
