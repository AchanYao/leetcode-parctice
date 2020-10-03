package leetcode.package_771;

import java.util.Arrays;

/**
 * @author Achan
 * @date 2020/10/2
 */
public class Solution711 {

    public int numJewelsInStones(String J, String S) {
        return (int) Arrays.stream(S.split("")).filter(J::contains).count();
    }
}
