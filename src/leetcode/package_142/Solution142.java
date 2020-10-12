package leetcode.package_142;

import leetcode.ds.ListNode;

/**
 * @author Achan
 * @date 2020/10/10
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode q = head, s = head;
        while (s != null && q != null) {
            if (q.next == null) {
                return null;
            }
            q = q.next.next;
            s = s.next;
            if (s == q) {
                break;
            }
        }

        if (q == null || s == null) {
            return null;
        }

        ListNode ptr = head;
        while (ptr != s) {
            ptr = ptr.next;
            s = s.next;
        }
        return ptr;
    }
}