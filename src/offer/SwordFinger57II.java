package offer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Achan
 * @date 2020/10/4
 */
public class SwordFinger57II {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int limit = (target + 1) / 2;
        int l = 1, r = 2;
        target *= 2;
        while (l < limit) {
            int sum = (l + r) * (r - l + 1);
            if (sum < target) {
                r++;
            } else if (sum == target) {
                list.add(buildArray(l, r));
                l++;
            } else {
                l++;
            }
        }
        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public int[] buildArray(int start, int end) {
        int[] result = new int[end - start + 1];
        for (int i = start; i <= end; i++) {
            result[i - start] = i;
        }
        return result;
    }

    @Test
    void findContinuousSequenceTest() {
        int[][] result = findContinuousSequence(9);
        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
