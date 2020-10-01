package offer;

/**
 * @author Achan
 * @date 2020/10/1
 */
public class SwordFinger10I {
    public int fib(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        int a = (int) (1e9 + 7);
        int pre = 0;
        int next = 1;
        int sum = 0;
        int i = 2;
        while (i <= n) {
            i++;
            sum = pre + next;
            if (sum >= a) {
                sum -= a;
            }
            pre = next;
            next = sum;
        }
        return sum % a;
    }
}
