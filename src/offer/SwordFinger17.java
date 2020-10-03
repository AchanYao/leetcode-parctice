package offer;

/**
 * @author Achan
 * @date 2020/10/2
 */
public class SwordFinger17 {

    public int[] printNumbers(int n) {
        int m = (int) (Math.pow(10, n) - 1);
        int[] result = new int[m];
        for (int i = 0; i < m;) {
            result[i] = ++i;
        }
        return result;
    }
}
