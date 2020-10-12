package leetcode.package_141;

import leetcode.ds.ListNode;

/**
 * @author Achan
 * @date 2020/10/9
 */
public class Solution141 {

    public boolean hasCycle(ListNode head) {
        ListNode q = head, s = head;
        while (s != null && q != null) {
            if (q.next == null) {
                return false;
            }
            q = q.next.next;
            s = s.next;
            if (s == q) {
                break;
            }
        }
        return s != null && q != null;
    }
}
