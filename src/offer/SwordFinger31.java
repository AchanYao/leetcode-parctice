package offer;

import java.util.Stack;

/**
 * @author Achan
 * @date 2020/10/4
 */
public class SwordFinger31 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;

        while (!stack.isEmpty() || i < pushed.length) {
            if (stack.isEmpty()) {
                stack.push(pushed[i++]);
            }
            if (stack.peek() != popped[j] && stack.contains(popped[j])) {
                return false;
            }
            while (stack.peek() != popped[j] && i < pushed.length) {
                stack.push(pushed[i++]);
            }
            if (stack.peek() == popped[j]) {
                stack.pop();
                j++;
            } else {
                return false;
            }
        }
        return j == pushed.length;
    }
}
