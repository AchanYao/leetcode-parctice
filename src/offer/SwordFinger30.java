package offer;

import java.util.Stack;

/**
 * @author Achan
 * @date 2020/10/3
 */
public class SwordFinger30 {
}
class MinStack {

    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        min = Integer.min(min, x);
        stack.push(x);
    }

    public void pop() {
        int val = stack.pop();
        if (val == min) {
            min = stack.parallelStream().min(Integer::compareTo).orElse(Integer.MAX_VALUE);
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }
}
