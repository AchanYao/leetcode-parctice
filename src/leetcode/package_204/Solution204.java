package leetcode.package_204;

import java.util.Arrays;

/**
 * @author Achan
 * @date 2020/10/16
 */
public class Solution204 {

    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        int count = 0;
        for (int i = 2; i * i < n; i++) {
            if (isPrim[i]) {
                count++;
                for (int j = i * i; j < n; j += i) {
                    isPrim[j] = false;
                }
            }
        }
        return count;
    }
}
