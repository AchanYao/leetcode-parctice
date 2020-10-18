package leetcode.package_6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author Achan
 * @date 2020/10/18
 */
public class Solution6 {

    public String convert(String s, int numRows) {
        int n = s.length();
        if (n <= numRows || numRows <= 1) {
            return s;
        }
        ArrayList<StringBuilder> list = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        boolean toDown = false;
        int row = 0;
        for (char c : s.toCharArray()) {
            list.get(row).append(c);
            if (row == numRows || row == 0) {
                toDown = !toDown;
            }
            if (toDown) {
                row++;
            } else {
                row--;
            }
        }
        StringBuilder res = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            res.append(list.get(i));
        }
        return res.toString();
    }

    @Test
    void convertTest() {
        System.out.println(convert("abc", 2));
    }
}
