package offer;

/**
 * @author Achan
 * @date 2020/10/4
 */
public class SwordFinger14II {
    static final int MOD = (int) (1e9 + 7);

    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int b = n % 3;
        long rem = 1;
        for (int a = n / 3 - 1; a > 0; a--) {
            rem = (rem * 3) % MOD;
        }
        if(b == 0) return (int)(rem * 3 % MOD);
        if(b == 1) return (int)(rem * 4 % MOD);
        return (int)(rem * 6 % MOD);
    }
}
