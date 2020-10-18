package leetcode.package_977;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Achan
 * @date 2020/10/16
 */
public class Solution977 {
    public int[] sortedSquares(int[] A) {
        int start = 0;
        int end = A.length - 1;
        int i = end;
        int[] B = new int[A.length];
        while (i >= 0) {
            B[i--] = A[start] * A[start] >= A[end] * A[end] ? A[start] * A[start++] : A[end] * A[end--];
        }
        return B;
    }

    @Test
    void sortedSquaresTest() {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-3, -3, -2, 1})));
    }
}
