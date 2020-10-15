package leetcode.package_83;

import leetcode.ds.ListNode;

/**
 * @author Achan
 * @date 2020/10/14
 */
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        ListNode pre;
        while (current != null) {
            pre = current;
            current = current.next;
            while (current != null && current.val == pre.val) {
                pre.next = pre.next.next;
                current = pre.next;
            }
        }
        return head;
    }
}
