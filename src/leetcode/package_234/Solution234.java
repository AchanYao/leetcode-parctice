package leetcode.package_234;

import leetcode.ds.ListNode;
import org.junit.jupiter.api.Test;

/**
 * @author Achan
 * @date 2020/10/16
 */
public class Solution234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        ListNode s = head;
        ListNode pre = null;
        ListNode q = head;
        while (q != null && q.next != null) {
            pre = s;
            s = s.next;
            q = q.next.next;
            pre.next = head;
            head = pre;
            if (head.next == head) {
                head.next = null;
            }
        }

        if (q == null) {
            q = s;
        } else {
            q = s.next;
        }
        s = pre;

        while (q != null && s != null && q.val == s.val) {
            q = q.next;
            s = s.next;
        }

        return q == s;
    }

    @Test
    void isPalindromeTest() {
        System.out.println(isPalindrome(ListNode.buildList(0,0)));
    }
}
