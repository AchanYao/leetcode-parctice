package leetcode.package_118;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Achan
 * @date 2020/10/15
 */
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                List<Integer> list = new ArrayList<>(1);
                list.add(1);
                res.add(list);
                continue;
            }
            List<Integer> list = new ArrayList<>(numRows);
            list.add(1);
            for (int j = 0, k = 1; k < i; k++, j++) {
                list.add(k, res.get(i - 1).get(j) + res.get(i - 1).get(k));
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }
}
