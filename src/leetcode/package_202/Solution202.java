package leetcode.package_202;

import java.util.HashSet;

/**
 * @author Achan
 * @date 2020/10/16
 */
public class Solution202 {

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1) {
            set.add(n);
            int temp = getNext(n);
            if (set.contains(temp)) {
                return false;
            }
            n = temp;
        }
        return true;
    }

    int getNext(int n) {
        int res = 0;
        while (n != 0) {
            int temp = n % 10;
            res += temp * temp;
            n /= 10;
        }
        return res;
    }
}
