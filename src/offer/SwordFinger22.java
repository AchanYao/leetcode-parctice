package offer;

import leetcode.ds.ListNode;

/**
 * @author Achan
 * @date 2020/10/3
 */
public class SwordFinger22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode headBak = head;
        while (k > 0 && head != null) {
            head = head.next;
            k--;
        }
        while (head != null) {
            head = head.next;
            headBak = headBak.next;
        }
        return headBak;
    }
}
