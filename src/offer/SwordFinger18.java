package offer;

import leetcode.ds.ListNode;

/**
 * @author Achan
 * @date 2020/10/10
 */
public class SwordFinger18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode current = head;
        while (current.next.val != val) {
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }
}
