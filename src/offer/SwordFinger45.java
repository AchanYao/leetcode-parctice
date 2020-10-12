package offer;

import java.util.ArrayList;

/**
 * @author Achan
 * @date 2020/10/12
 */
public class SwordFinger45 {

    public String minNumber(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(num);
        }

        list.sort((o1, o2) -> {
            long temp = Long.parseLong("" + o1 + o2) - Long.parseLong("" + o2 + o1);
            if (temp > 0) {
                return 1;
            } else if (temp == 0) {
                return 0;
            } else {
                return -1;
            }
        });
        StringBuilder builder = new StringBuilder();
        for (int i : list) {
            builder.append(i);
        }
        return builder.toString();
    }
}
