package offer;

import leetcode.ds.ListNode;

import java.util.Stack;

/**
 * @author Achan
 * @date 2020/9/27
 */
public class SwordFinger06 {
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int[] result = new int[stack.size()];
        int index = 0;
        while (!stack.empty()) {
            result[index++] = stack.pop().val;
        }
        return result;
    }
}

