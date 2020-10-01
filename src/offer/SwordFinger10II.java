package offer;

/**
 * @author Achan
 * @date 2020/10/1
 */
public class SwordFinger10II {

    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 3) {
            return n;
        }
        int pre = 1;
        int next = 2;
        int sum = 0;
        int mod = (int) (1e9 + 7);
        for (int i = 3; i < n + 1; i++) {
            sum = pre + next;
            if (sum > mod) {
                sum -= mod;
            }
            pre = next;
            next = sum;
        }
        return sum;
    }
}
