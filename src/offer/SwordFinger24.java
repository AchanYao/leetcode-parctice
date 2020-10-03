package offer;

import leetcode.ds.ListNode;
import org.junit.jupiter.api.Test;

/**
 * @author Achan
 * @date 2020/10/3
 */
public class SwordFinger24 {

    public ListNode reverseList(ListNode head) {
        if (head == null) { return null; }
        ListNode next = head.next;
        ListNode current = head;
        while (next != null) {
            ListNode p = current;
            current = next;
            next = next.next;
            head.next = next;
            current.next = p;
        }
        return current;
    }

    @Test
    void reverseListTest() {
        ListNode head = ListNode.buildList(1, 2, 3, 4, 5);
        System.out.println(ListNode.toString(head));
        System.out.println(ListNode.toString(reverseList(head)));
    }
}
