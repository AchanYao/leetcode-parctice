package leetcode.package_258;

/**
 * @author Achan
 * @date 2020/10/16
 */
public class Solution258 {

    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
