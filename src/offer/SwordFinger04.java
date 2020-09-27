package offer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Achan
 * @date 2020/9/25
 */
public class SwordFinger04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int start = 0;
        int end = matrix.length - 1;
        int mid = start + (end - start) / 2;
        while (start <= end) {
            if (matrix[mid][0] < target) {
                if (mid == matrix.length - 1 || matrix[mid + 1][0] > target) {
                    break;
                }
                start = mid + 1;
                mid = start + (end - start) / 2;
            } else if (matrix[mid][0] == target) {
                return true;
            } else {
                end = mid - 1;
                mid = start + (end - start) / 2;
            }
        }

        for (int i = 0; i < mid; i++) {
            if (Arrays.binarySearch(matrix[i], target) > -1) {
                return true;
            }
        }
        return false;
    }


    @Test
    public void findNumberIn2DArrayTest() {
        System.out.println(findNumberIn2DArray(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        }, 5));
    }
}
