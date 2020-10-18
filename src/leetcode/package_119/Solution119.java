package leetcode.package_119;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Achan
 * @date 2020/10/15
 */
public class Solution119 {

    /**
     * 杨辉三角<br/>
     * 通过组合数求，时间O(k)，空间O(1)（除答案）
     * @param rowIndex 行数
     * @return 第 rowIndex 杨辉三角
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        long cur = 1;
        for (int i = 0; i <= rowIndex; i++) {
            res.add((int) cur);
            cur = cur * (rowIndex-i)/(i+1);
        }
        return res;
    }

    List<Integer> getRowByList(int rowIndex) {
        // 空间O(k) 时间O(k!)
        if (rowIndex == 1) {
            return new ArrayList<>(Arrays.asList(1, 1));
        }

        int[] array = new int[rowIndex];
        int[] temp = new int[rowIndex];
        for (int i = 1; i <= rowIndex; i++) {
            temp[0] = 1;
            int k = 1;
            for (int j = 0; k < i; k++, j++) {
                temp[k] = array[j] + array[k];
            }
            System.arraycopy(temp, 0, array, 0, k);
        }
        ArrayList<Integer> res = new ArrayList<>();
        Arrays.stream(array).forEach(res::add);
        return res;
    }

    @Test
    void getRowTest() {
        System.out.println(getRow(5));
    }
}
