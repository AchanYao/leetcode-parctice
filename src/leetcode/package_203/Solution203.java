package leetcode.package_203;

import leetcode.ds.ListNode;

/**
 * @author Achan
 * @date 2020/10/16
 */
public class Solution203 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode node = head;
        ListNode pre = null;
        while (node != null) {
            pre = node;
            node = node.next;
            while (node!= null && node.val == val) {
                pre.next = pre.next.next;
                node = pre.next;
            }
        }
        return head;
    }
}
