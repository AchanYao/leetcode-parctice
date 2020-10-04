package offer;

/**
 * @author Achan
 * @date 2020/10/4
 */
public class SwordFinger62 {
    public int lastRemaining(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}
