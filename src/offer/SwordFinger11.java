package offer;

import java.util.Arrays;

/**
 * @author Achan
 * @date 2020/9/25
 */
public class SwordFinger11 {

    public int minArray(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }
}
