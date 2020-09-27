package offer;

import java.util.Stack;

/**
 * @author Achan
 * @date 2020/9/25
 */
public class SwordFinger09 {
    private class CQueue {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        public CQueue() {
        }

        public void appendTail(int value) {
            s1.push(value);
        }

        public int deleteHead() {
            if (s2.isEmpty()) {
                while (!s1.empty()) {
                    s2.push(s1.pop());
                }
            }
            if (s2.isEmpty()) {
                return -1;
            }
            return s2.pop();
        }
    }
}