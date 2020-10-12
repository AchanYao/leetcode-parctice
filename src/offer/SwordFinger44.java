package offer;

import org.junit.jupiter.api.Test;

/**
 * @author Achan
 * @date 2020/10/12
 */
public class SwordFinger44 {

    public int findNthDigit(int n) {
        if (n < 10) return n;
        // i 表示位数，k表示当前数字
        long m = n;
        long temp = 0;
        long base = 1;
        long num = 9;
        while ((temp + base * num) < m) {
            temp += base * num;
            base += 1;
            num *= 10;
        }
        long a = (m - temp) / base;
        long b = (m - temp) % base;
        if (b != 0) {
            long c = (long) (Math.pow(10, base - 1) + a);
            return String.valueOf(c).charAt((int) b - 1) - '0';
        } else {
            long c = (long) (Math.pow(10, base - 1) + a - 1);
            return String.valueOf(c).charAt((int) base - 1) - '0';
        }
    }

    @Test
    void findNthDigitTest() {
        System.out.println(findNthDigit(5));
        System.out.println(findNthDigit(11));
        System.out.println(findNthDigit(12));
        System.out.println(findNthDigit(13));
    }
}
