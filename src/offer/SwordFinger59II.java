package offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Achan
 * @date 2020/10/4
 */
public class SwordFinger59II {
}

class MaxQueue {

    Queue<Integer> queue = new LinkedList<>();
    int max = Integer.MIN_VALUE;

    public MaxQueue() {

    }

    public int max_value() {
        return queue.isEmpty() ? -1 : max;
    }

    public void push_back(int value) {
        queue.offer(value);
        max = Integer.max(value, max);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        } else {
            int val = queue.poll();
            if (max == val) {
                max = queue.stream().max(Integer::compareTo).orElse(-1);
            }
            return val;
        }
    }
}
