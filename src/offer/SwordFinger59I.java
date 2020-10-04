package offer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Achan
 * @date 2020/10/4
 */
public class SwordFinger59I {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        if (k == 1) return nums;
        int l = 0, r = 0, max = Integer.MIN_VALUE, maxIndex = 0;
        for (; r < k; r++) {
            if (nums[r] > max) {
                maxIndex = r;
                max = nums[r];
            }
        }
        int index = 0;
        int[] result = new int[nums.length - k + 1];
        r -= 1;
        for (; r < nums.length; l++, r++) {
            if (nums[r] >= max) {
                maxIndex = r;
                max = nums[r];
            }
            if (maxIndex < l) {
                max = nums[l];
                maxIndex = l;
                for (int i = l + 1; i <= r; i++) {
                    if (nums[i] >= max) {
                        maxIndex = i;
                        max = nums[i];
                    }
                }
            }
            result[index++] = max;
        }
        return result;
    }

    public int[] maxSlidingWindowByDeque(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        if (k == 1) return nums;
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            if (i > 0 && deque.peekFirst() == nums[i - 1])
                deque.removeFirst(); // 删除 deque 中对应的 nums[i-1]
            while (!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast(); // 保持 deque 递减
            deque.addLast(nums[j]);
            if (i >= 0) {
                // 记录窗口最大值
                res[i] = deque.peekFirst();
            }
        }
        return res;
    }

    @Test
    void maxSlidingWindowTest() {
        System.out.println(Arrays.toString(maxSlidingWindowByDeque(new int[]{1, 3, 1, 2, 0, 5}, 3)));
    }
}
