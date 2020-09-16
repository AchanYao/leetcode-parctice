package package_19;

import java.util.Objects;

/**
 * @author Achan
 * @date 2020/9/16
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        ListNode start = head;
        while (n-- > 0) {
            node = node.next;
        }
        if (node == null) {
            return Objects.requireNonNull(head).next;
        }
        while (node.next != null) {
            head = head.next;
            node = node.next;
        }
        if (head.next != null) {
            head.next = head.next.next;
        }
        return start;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        if (next == null) {
            return val + "->null";
        }
        return val + "->" + next.toString();
    }
}
